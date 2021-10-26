package dataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.ProductTemplate;

@Repository
@Transactional  //Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan, transakzioa bukatu 
public class ProductTemplateDao {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Almacena la product en la base de datos
     */
    public void create(ProductTemplate product) {
        entityManager.persist(product);
        return;
    }

    /**
     * Elimina el usuario de la base de datos.
     */
    public void delete(ProductTemplate product) {
        if (entityManager.contains(product))
            entityManager.remove(product);
        else
            entityManager.remove(entityManager.merge(product));
        return;
    }

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<ProductTemplate> getAll() {
        return entityManager.createQuery("from ProductTemplate").getResultList();
    }

    /**
     * Devuelve un usuario en base a su Id
     */
    public ProductTemplate getById(int id) {
        return entityManager.find(ProductTemplate.class, id);
    }

    /**
     * Actualiza el usuario proporcionado
     */
    public void update(ProductTemplate product) {
        entityManager.merge(product);
        return;
    }

}