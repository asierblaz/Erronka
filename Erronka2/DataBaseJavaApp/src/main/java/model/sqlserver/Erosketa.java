package model.sqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the erosketa database table.
 * 
 */
@Entity
@NamedQuery(name="Erosketa.findAll", query="SELECT e FROM Erosketa e")
public class Erosketa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private boolean fakturatua;

	private int kantitatea;

	private int orderId;

	private float prezioTotala;

	//bi-directional many-to-one association to Produktua
	@ManyToOne
	@JoinColumn(name="productId")
	private Produktua produktua;

	//bi-directional many-to-one association to Bezeroa
	@ManyToOne
	@JoinColumn(name="bezeroId")
	private Bezeroa bezeroa;

	public Erosketa(int id, Date data, boolean fakturatua, int kantitatea, int orderId, float prezioTotala) {
		super();
		this.id = id;
		this.data = data;
		this.fakturatua = fakturatua;
		this.kantitatea = kantitatea;
		this.orderId = orderId;
		this.prezioTotala = prezioTotala;

	}

	public Erosketa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean getFakturatua() {
		return this.fakturatua;
	}

	public void setFakturatua(boolean fakturatua) {
		this.fakturatua = fakturatua;
	}

	public int getKantitatea() {
		return this.kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getPrezioTotala() {
		return this.prezioTotala;
	}

	public void setPrezioTotala(float prezioTotala) {
		this.prezioTotala = prezioTotala;
	}

	public Produktua getProduktua() {
		return this.produktua;
	}

	public void setProduktua(Produktua produktua) {
		this.produktua = produktua;
	}

	public Bezeroa getBezeroa() {
		return this.bezeroa;
	}

	public void setBezeroa(Bezeroa bezeroa) {
		this.bezeroa = bezeroa;
	}

}