package eus.uni.dam;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dataAccess.ProductTemplateDao;
import model.ProductTemplate;

@SpringBootApplication
public class AppProduktuak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa.class);
		ProductTemplateDao produktuaDao = appContext.getBean(ProductTemplateDao.class);

	List<ProductTemplate> produktuak = produktuaDao.getAll();
		
	
	System.out.println("-------------PRODUKTUAK:------------------------");
	for(ProductTemplate p:produktuak) {
			System.out.println(p.getName());
					}
		
	System.out.println("-------------------------------------");
		
		
		
	//	System.out.println("estoy probando "+ produktuaDao.getById(82).getName());
	//	System.out.println(Arrays.toString((produktuaDao.getAll()).toArray()));
		
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
