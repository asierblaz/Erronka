package model.postgres;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="complete_name")
	private String completeName;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	private String name;

	@Column(name="parent_path")
	private String parentPath;

	@Column(name="removal_strategy_id")
	private Integer removalStrategyId;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="parent_id")
	private ProductCategory productCategory;

	//bi-directional many-to-one association to ProductCategory
	@OneToMany(mappedBy="productCategory")
	private List<ProductCategory> productCategories;

	//bi-directional many-to-one association to ProductTemplate
	@OneToMany(mappedBy="productCategory")
	private List<ProductTemplate> productTemplates;

	public ProductCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompleteName() {
		return this.completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentPath() {
		return this.parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public Integer getRemovalStrategyId() {
		return this.removalStrategyId;
	}

	public void setRemovalStrategyId(Integer removalStrategyId) {
		this.removalStrategyId = removalStrategyId;
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

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<ProductCategory> getProductCategories() {
		return this.productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	public ProductCategory addProductCategory(ProductCategory productCategory) {
		getProductCategories().add(productCategory);
		productCategory.setProductCategory(this);

		return productCategory;
	}

	public ProductCategory removeProductCategory(ProductCategory productCategory) {
		getProductCategories().remove(productCategory);
		productCategory.setProductCategory(null);

		return productCategory;
	}

	public List<ProductTemplate> getProductTemplates() {
		return this.productTemplates;
	}

	public void setProductTemplates(List<ProductTemplate> productTemplates) {
		this.productTemplates = productTemplates;
	}

	public ProductTemplate addProductTemplate(ProductTemplate productTemplate) {
		getProductTemplates().add(productTemplate);
		productTemplate.setProductCategory(this);

		return productTemplate;
	}

	public ProductTemplate removeProductTemplate(ProductTemplate productTemplate) {
		getProductTemplates().remove(productTemplate);
		productTemplate.setProductCategory(null);

		return productTemplate;
	}

}