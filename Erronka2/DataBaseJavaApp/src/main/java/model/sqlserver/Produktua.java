package model.sqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produktua database table.
 * 
 */
@Entity
@NamedQuery(name="Produktua.findAll", query="SELECT p FROM Produktua p")
public class Produktua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String categoria;

	private String imagen;

	private String name;

	private float prezioa;

	//bi-directional many-to-one association to Erosketa
	@OneToMany(mappedBy="produktua")
	private List<Erosketa> erosketas;

	public Produktua() {
	}

	public int getId() {
		return this.id;
	}

	public Produktua(int id, String categoria, String imagen, String name, float prezioa) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.imagen = imagen;
		this.name = name;
		this.prezioa = prezioa;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrezioa() {
		return this.prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public List<Erosketa> getErosketas() {
		return this.erosketas;
	}

	public void setErosketas(List<Erosketa> erosketas) {
		this.erosketas = erosketas;
	}

	public Erosketa addErosketa(Erosketa erosketa) {
		getErosketas().add(erosketa);
		erosketa.setProduktua(this);

		return erosketa;
	}

	public Erosketa removeErosketa(Erosketa erosketa) {
		getErosketas().remove(erosketa);
		erosketa.setProduktua(null);

		return erosketa;
	}

}