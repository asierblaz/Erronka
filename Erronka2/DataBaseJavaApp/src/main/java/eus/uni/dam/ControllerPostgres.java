package eus.uni.dam;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.postgres.ProductTemplate;
import model.postgres.ResPartner;
import model.postgres.SaleOrderLine;
import repo.postgres.PostgresDao;

public class ControllerPostgres {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(PostgresSqlDatuBasearenKonfigurazioa.class);
	PostgresDao postgresDao = appContext.getBean(PostgresDao.class);

	public List<ProductTemplate> produktuakToList() {
		return postgresDao.getAllProductTemplates();
	}
	
	public List<ResPartner> bezeroakToList() {
		return postgresDao.getAllResPartners();
	}

	public List<SaleOrderLine> erosketakToList() {
		return postgresDao.getAllSaleOrderLines();
	}
	
	
	
	public void closeContext() {
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
