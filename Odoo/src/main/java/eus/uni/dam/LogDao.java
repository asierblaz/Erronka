package eus.uni.dam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class LogDao {
	
	
	String filename="..\\PatosdeGoma\\app\\src\\main\\res\\raw\\log.csv";
    String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

	
	public LogDao() {
		
	}

	@PostConstruct
	public void logToFile() {
		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(new FileWriter(filename));
			String l;
				outputStream.println("Fecha : "+ fecha);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + filename +" fitxategian.");
			}
		}
		
	}

		


		



}
