package model.postgres;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the res_country database table.
 * 
 */
@Entity
@Table(name="res_country")
@NamedQuery(name="ResCountry.findAll", query="SELECT r FROM ResCountry r")
public class ResCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="address_format")
	private String addressFormat;

	@Column(name="address_view_id")
	private Integer addressViewId;

	private String code;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	private String name;

	@Column(name="name_position")
	private String namePosition;

	@Column(name="phone_code")
	private Integer phoneCode;

	@Column(name="state_required")
	private Boolean stateRequired;

	@Column(name="vat_label")
	private String vatLabel;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	@Column(name="zip_required")
	private Boolean zipRequired;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resCountry")
	private List<ResPartner> resPartners;

	public ResCountry() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressFormat() {
		return this.addressFormat;
	}

	public void setAddressFormat(String addressFormat) {
		this.addressFormat = addressFormat;
	}

	public Integer getAddressViewId() {
		return this.addressViewId;
	}

	public void setAddressViewId(Integer addressViewId) {
		this.addressViewId = addressViewId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePosition() {
		return this.namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public Integer getPhoneCode() {
		return this.phoneCode;
	}

	public void setPhoneCode(Integer phoneCode) {
		this.phoneCode = phoneCode;
	}

	public Boolean getStateRequired() {
		return this.stateRequired;
	}

	public void setStateRequired(Boolean stateRequired) {
		this.stateRequired = stateRequired;
	}

	public String getVatLabel() {
		return this.vatLabel;
	}

	public void setVatLabel(String vatLabel) {
		this.vatLabel = vatLabel;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public Boolean getZipRequired() {
		return this.zipRequired;
	}

	public void setZipRequired(Boolean zipRequired) {
		this.zipRequired = zipRequired;
	}

	public List<ResPartner> getResPartners() {
		return this.resPartners;
	}

	public void setResPartners(List<ResPartner> resPartners) {
		this.resPartners = resPartners;
	}

	public ResPartner addResPartner(ResPartner resPartner) {
		getResPartners().add(resPartner);
		resPartner.setResCountry(this);

		return resPartner;
	}

	public ResPartner removeResPartner(ResPartner resPartner) {
		getResPartners().remove(resPartner);
		resPartner.setResCountry(null);

		return resPartner;
	}

}