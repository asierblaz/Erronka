package repo.sqlserver;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.sqlserver.Bezeroa;
import model.sqlserver.Erosketa;
import model.sqlserver.Produktua;

@Repository
@Transactional // Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan,
				// transakzioa bukatu
public class SqlServerDao {

	// A través de la anotación @PersistenceContext, se inyectará automáticamente
	// un EntityManager producido desde el entityManagerFactory definido en la clase
	// DatabaseConfig.
	@PersistenceContext
	private EntityManager entityManager;

	public void createProduktua(Produktua product) {
		entityManager.persist(product);
		return;
	}

	public void updateProduktua(Produktua product) {
		entityManager.merge(product);
		return;
	}

	public void createBezeroa(Bezeroa bezeroa) {
		entityManager.persist(bezeroa);
		return;
	}

	public void updateBezeroa(Bezeroa bezeroa) {
		entityManager.merge(bezeroa);
		return;
	}

	public void createBezeroa(Erosketa erosketa) {
		entityManager.persist(erosketa);
		return;
	}

	public void updateErosketa(Erosketa erosketa) {
		entityManager.merge(erosketa);
		return;
	}

	public void createErosketa(Erosketa erosketa) {
		entityManager.persist(erosketa);
		return;
	}

	public void deleteAllErosketak() {
    	entityManager.createQuery("delete from Erosketa").executeUpdate();
	}	

	
	public Produktua getProduktuaById(int id) {
		return entityManager.find(Produktua.class, id);
	}

	public Bezeroa getBezeroaById(int id) {
		return entityManager.find(Bezeroa.class, id);
	}
}