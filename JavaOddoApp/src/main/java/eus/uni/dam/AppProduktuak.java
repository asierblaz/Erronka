package eus.uni.dam;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppProduktuak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduktuaDaoJbdcText produktuaDao = appContext.getBean(ProduktuaDaoJbdcText.class);
		//ProduktuaDao produktuaDao = appContext.getBean(ProduktuaDaoJbdcText.class);
		System.out.println("Ditugun Produktuak:");
		for(Produktua prod:produktuaDao.getProduktuak()) {
			System.out.println(prod);
	    }	
		//GenerateLog log = appContext.getBean(GenerateLog.class);

		((AnnotationConfigApplicationContext) appContext).close();
		
		

	}

}
