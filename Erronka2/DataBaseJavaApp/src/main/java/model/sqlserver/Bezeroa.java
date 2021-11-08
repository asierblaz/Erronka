package model.sqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bezeroa database table.
 * 
 */
@Entity
@NamedQuery(name="Bezeroa.findAll", query="SELECT b FROM Bezeroa b")
public class Bezeroa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String herrialdea;

	private String izena;

	private String telefonoa;

	//bi-directional many-to-one association to Erosketa
	@OneToMany(mappedBy="bezeroa")
	private List<Erosketa> erosketas;

	public Bezeroa() {
	}
	
	

	public Bezeroa(int id, String email, String herrialdea, String izena, String telefonoa) {
		super();
		this.id = id;
		this.email = email;
		this.herrialdea = herrialdea;
		this.izena = izena;
		this.telefonoa = telefonoa;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHerrialdea() {
		return this.herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getTelefonoa() {
		return this.telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public List<Erosketa> getErosketas() {
		return this.erosketas;
	}

	public void setErosketas(List<Erosketa> erosketas) {
		this.erosketas = erosketas;
	}

	public Erosketa addErosketa(Erosketa erosketa) {
		getErosketas().add(erosketa);
		erosketa.setBezeroa(this);

		return erosketa;
	}

	public Erosketa removeErosketa(Erosketa erosketa) {
		getErosketas().remove(erosketa);
		erosketa.setBezeroa(null);

		return erosketa;
	}

}