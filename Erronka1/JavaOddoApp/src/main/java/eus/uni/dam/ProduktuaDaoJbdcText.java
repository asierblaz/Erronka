package eus.uni.dam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class ProduktuaDaoJbdcText implements ProduktuaDao {
	
	public List<Produktua> produktuak= new ArrayList<>();
	//String filename = "produktuak.csv";
	String filename="..\\PatosdeGoma\\app\\src\\main\\res\\raw\\produktuak.csv";
	
	
	
	public ProduktuaDaoJbdcText() {
	}

	
	public Collection<Produktua> getProduktuak() {
		return produktuak;
	};

	/** Datu-basetik datuak berreskuratu eta memoriako zerrendan kargatu. 
	 *  
	 */
	
	@PostConstruct
	public void hasieran() {
		this.produktuaToArray(produktuak);
	}
	
	
	
	public Collection<Produktua> findAll() {
		return produktuak;
	}

	/** DBan INSERT bat egin, eta dena ondo balego, memorian be egin insert-a.
	 * 
	 * @param pelicula
	 */
	public void insert(Produktua produktua) {
		// DBan insert-a
		produktuak.add(produktua);
		Produktua.produktuak.add(produktua);
	};

	/** DBan UPDATE bat egin, eta dena ondo balego, memorian be...
	 *  
	 * @param pelicula
	 */
	public void edit(Produktua produktua) {
		//TO-DO
	};
	
	/**
	 * DBan DELETE bat egin, eta dena ondo balego, memorian be 
	 * @param id
	 */	
	public void delete(long id) {
		//TO-DO
	};

	/** Momentuoro, aldaketak, bai memorian, bai dban bertan egin izan ditugu,
	 *  beraz, ez da beharrezkoa orain zerrendako datuak dban berriz gordetzea. 
	 *  (DB-an beste norbaitek, beste aplikazio batetik 
	 *  eginiko aldaketez ez gara enteratzen. Kontuz)   
	 * 
	 */
	@PreDestroy
	public void destroy() {
		this.produktuakToFile();
	}
	
	
	//connect
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
	
	//Insertar productos al csv
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
	



}
