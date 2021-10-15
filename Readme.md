# GARAPEN TEKNIKOA

Proiektu honetan garatu diren funtzionalitate garrantzitsuenak aipatuko ditugu

# Multimedia Programazioa Eta Gailu Mugikorrak
Android Aplikazio bat garatu dugu odoon dauden produktuak bistaratzeko, horretarako spring erabilita esportatzen dugu csv fitxategi bat produktuen datuekin eta android-en irakurtzen ditugu.

![Alt text](https://cdn.discordapp.com/attachments/805837040566534207/898469337629868063/AndroidAplikazioa.png "Android Klase Diagrama")

Produktuen irakurketa egiteko hurrengo funtzioa erabiltzen dugu:


```android
    public static void fileToArraylist(Context c) {
        String separador = ",";
        BufferedReader bufferLectura = null;
        try {
            InputStream is = c.getResources().openRawResource(R.raw.produktuak);

            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            while (linea != null) {

                // Sepapar la linea leída con el separador definido previamente
                String[] campos = linea.split(separador);
                Produktua p1 = new Produktua(Integer.parseInt(campos[0]), campos[1], campos[2], Float.parseFloat(campos[3]),campos[4]);
                Produktua.produktuak.add(p1);

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
```

Ikus daitekeenez, produktuak zerrenda batean gordetzen ditugu, gero ListaProductos-en erakusteko..

### Produktuak lista batean ikusi: 
Horretarako produktuen listarekin ArrayAdapter bat sortzen dugu eta ListView bateri esleitzen diogu.
```
  //adapter lista productos
        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);
```

### Produktuak kategoriaren arabera filtratu:
 
Kategoriak ArrayList<String> batean sartu ditugu, horrekin Spinner bati gehitu dizkiogu eta spinner horren balioa aldatzen denean produktuen lista eguneratzen da eta kategoria hortako produktuak bistaratuko dira.

```
    public void printByCategory(String categoria) {

        ArrayList<Produktua> prods = new ArrayList<Produktua>();
        for (Produktua p : Produktua.produktuak) {
            if (p.getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
                prods.add(p);
            }
            produktuakActual = prods;
            produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuakActual);
            listaProductos.setAdapter(produktuakAdapter);

        }
    }
```

### Produktuak izenaren arabera bilatu:

Produktuak izenaren arabera bilatu ahal izango dira, horretarako funtzio hau erabili dugu.

```    
	public void filtrado(String name) {
        ArrayList<Produktua> prods = new ArrayList<Produktua>();
        if (!name.isEmpty()) {
            for (Produktua p : Produktua.produktuak) {
                if (p.getName().toLowerCase().contains(name)) {
                    prods.add(p);
                }
                produktuakActual =prods;
                produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuakActual);
                listaProductos.setAdapter(produktuakAdapter);

            }
        } else {

            produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
            listaProductos.setAdapter(produktuakAdapter);
        }
    }
```

Sartutako hitza produktuen izenekin alderatzen da; produktu batek karaktere-kate hori badu, gure aplikazioan erakusten den zerrenda bati gehitzen zaio, horri esker bilatzailea berehalakoa da.

Letra baten sarketa detektatzeko, gertaera hauek erabiltzen ditugu

```
	@Override
    public boolean onQueryTextSubmit(String s) {
        filtrado(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        filtrado(s);
        return false;
    }
```

### Produktuen datuak ikusi:

Produktu baten izenean klik egin eta gero Intent baten bitartez produktu objetua DetallesProducto activity-ra bidaltzen dugu eta bertan datuak imprimatzen ditugu.

```
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Produktua p1 = produktuakActual.get(position);
                Intent intent = new Intent(ListaProductos.this, DetallesProductos.class);
                intent.putExtra("prod", p1);
                startActivity(intent);
            }
        });
    }
```

Produktuen datuak jasotzeko:
```
Produktua p1 = (Produktua) getIntent().getSerializableExtra("prod");
```

# Datu Atzipena

