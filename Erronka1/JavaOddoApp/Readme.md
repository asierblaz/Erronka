# Datu Atzipena
Spring erabilita Odoon dauden produktuen datuak fitxategi batera esportatzen ditugu, horretarako PostgresSql datu base batera egiten dugu konexioa eta produktuen ezaugarriak csv batera esportatzen ditugu,horretaz gain, datu-baseko deskargak eta txertaketak kontrolatzeko log-a ere implementatu dugu.

Hauek dira csv-en formatuak:

*Log.csv*

```
Konexio Data : 05-10-2021 10:13:25|  produktuen kantitatea ez da aldatu ,78, daude

```

*Produktuak.csv*
```
1,Alduin,Skyrim,19.9,pgskrm0001
2,Aquaman,DC Comics,19.9,pgdccm0001
3,Aragorn,El Señor de los Anillos,19.9,pglotr0001
4,Arwen,El Señor de los Anillos,19.9,pglotr0002
5,Atreus,God of War,19.9,pggofw0001
6,Batman,DC Comics,19.9,pgdccm0002
7,Beetlejuice,Misc,19.9,pgbtjc0001
…
```

Esan dugunez erronkaren datu atzipenerako Spring erabili dugu, hau da klase diagrama:

![Alt text](https://cdn.discordapp.com/attachments/805837040566534207/898469350602846238/JavaAplikazioa.png "Spring Klase Diagrama")

### Datu Basera Konexioa

```java
	private Connection connect() throws SQLException {
		// SQLite connection string

		Connection conn = null;

		try {

			conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma", "openpg","openpgpwd");
			System.out.println(conn.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}


	//insertar productos al arrayList
	
	public void produktuaToArray(List<Produktua> produktuak){
		String sql = "SELECT product_template.id,product_template.name,product_category.name,product_template.list_price,"
				+ " product_template.default_code FROM product_template inner join product_category on product_template.categ_id"
				+ " = product_category.id ORDER BY product_template.id";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
			Produktua p1= new Produktua(rs.getInt("id"),rs.getString("name"),rs.getString(3),rs.getFloat(4),rs.getString("default_code").toLowerCase());
			insert(p1);
			System.out.println(p1);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
```
produktuakToArray funtzioa datu basetik produktuak jasotzen ditu eta ArrayList<Produktua> batean sartzen ditu gero fitxategi batera idazteko, kasu honetan hau da gure @PostConstruct

### Fitxategira Datuak Inprimatu

```java
public void produktuakToFile() {
		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(new FileWriter(filename));
			String l;
			for (Produktua p : produktuak) {
				outputStream.println(p.getId() + "," + p.getName() + "," + p.getCategoria()+ ","+p.getPrezioa()+","+p.getImagen());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + filename +" fitxategian.");
			}
		}
	}
	
```
Gure listan dauden Produktuak irakurri eta fitxategia gordetzen ditugu, hau izango da gure bean-ren @PreDestroy

### Konexio Log-a

Horretarako beste GenerateLog izeneko beste bean bat egin dugu, hemen konparatzen dugu lehen genituen produktuak orain ditugunekin , horretarako bi funtzio egin ditugu. 

```java
	public int readFile() {
		BufferedReader bufferLectura = null;
		int produktuKantitatea = 0;
		try {
			bufferLectura = new BufferedReader(new FileReader(filename));
			// Leer una linea del archivo
			String linea = bufferLectura.readLine();
			while (linea != null) {
				// Sepapar la linea leída con el separador definido previamente
				String[] campos = linea.split(",");
				produktuKantitatea = Integer.parseInt(campos[1]);
				// Volver a leer otra línea del fichero
				linea = bufferLectura.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// cerrar el buffer de lectura
			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return produktuKantitatea;

	}
	
```

readFile() funtzioarekin aurretik daukagun log fitxategia irakurtzen dugu eta produktuen kantitatea itzultzen digu.

```java

public void logToFile(int produktuKantitatea) {
		String s = "";
		int zenbat = 0;
		int produktuakArray = Produktua.produktuak.size();

		if (produktuKantitatea > produktuakArray) {
			zenbat = produktuKantitatea - produktuakArray;
			s = zenbat + " produktu kendu dira," + produktuakArray + ", daude";
		}
		if (produktuKantitatea < produktuakArray) {
			zenbat = produktuakArray - produktuKantitatea;
			s = zenbat + " produktu gehitu dira," + produktuakArray + ", daude";
		}
		if (produktuKantitatea == produktuakArray) {

			s = "produktuen kantitatea ez da aldatu ," + produktuakArray + ", daude";
		}
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(filename, true));
			outputStream.println("Konexio Data : " + fecha + "|  " + s);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + filename + " fitxategian.");
			}
		}

	}
```
Funtzio hau produktuKantitatean jasotzen da eta horren arabera datuak fitxategian idazten ditu, hau izango da GenerateLog bean-aren @PreDestroy.
