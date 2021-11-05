package repo.postgres;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.postgres.ProductCategory;
import model.postgres.ProductTemplate;
import model.postgres.ResPartner;
import model.postgres.SaleOrderLine;


@Repository
@Transactional  
public class PostgresDao {

    @PersistenceContext
    private EntityManager entityManager;

    
    @SuppressWarnings("unchecked")
    public List<ProductTemplate> getAllProductTemplates() {
        return entityManager.createQuery("from ProductTemplate").getResultList();
    }
   
    
    @SuppressWarnings("unchecked")
    public List<ProductCategory> getAllProductCategories() {
    	return entityManager.createQuery("from ProductCategory").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<ResPartner> getAllResPartners() {
    	return entityManager.createQuery("from ResPartner").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<SaleOrderLine> getAllSaleOrderLines() {
    	return entityManager.createQuery("from SaleOrderLine").getResultList();
    }
    
    


  

}