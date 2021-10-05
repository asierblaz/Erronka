package eus.uni.dam;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppProduktuak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//init
		ProduktuaDaoJbdcText produktuaDao = appContext.getBean(ProduktuaDaoJbdcText.class);
		//ProduktuaDao produktuaDao = appContext.getBean(ProduktuaDaoJbdcText.class);
		System.out.println("Ditugun Produktuak:");
		for(Produktua prod:produktuaDao.getProduktuak()) {
			System.out.println(prod);
	    }	
		
		//postdestroy
		((AnnotationConfigApplicationContext) appContext).close();
		
		ApplicationContext appContext2 = new AnnotationConfigApplicationContext(AppConfig.class);
		LogDao logdao = appContext2.getBean(LogDao.class);
		((AnnotationConfigApplicationContext) appContext2).close();


	}

}
