package eus.uni.dam;

import java.util.ArrayList;

public class Produktua {

	private int id;
	private String name;
	private String categoria;
	private float prezioa;
	private String imagen;
	public static ArrayList<Produktua> produktuak = new ArrayList<Produktua>();
	public Produktua(int id, String name, String categoria, float prezioa, String imagen) {
		super();
		this.id = id;
		this.name = name;
		this.categoria = categoria;
		this.prezioa= prezioa;
		this.imagen= imagen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Produktua [id=" + id + ", name=" + name + ", categoria=" + categoria + ", prezioa=" + prezioa
				+ ", imagen=" + imagen + "]";
	}
	
	

	
	
	
	
	
}
