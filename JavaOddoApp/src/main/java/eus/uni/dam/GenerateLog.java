package eus.uni.dam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class GenerateLog {
	
	
	private String filename="..\\PatosdeGoma\\app\\src\\main\\res\\raw\\log.csv";
    private String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	
	public GenerateLog() {
		
	}

	@PreDestroy
	
	public void destroy() {
	
	logToFile(readFile());
	}
	
	
	
	
	public void logToFile(int produktuKantitatea) {
		String s="";
		int zenbat=0;
		int produktuakArray= Produktua.produktuak.size();
		
		
		if(produktuKantitatea > produktuakArray) {
			zenbat = produktuKantitatea-produktuakArray;
			s=zenbat+" produktu kendu dira,"+produktuakArray+", daude";
		}
		if(produktuKantitatea < produktuakArray) {
			zenbat= produktuakArray- produktuKantitatea;
			s=zenbat+" produktu gehitu dira,"+produktuakArray+", daude";
		}
		if(produktuKantitatea == produktuakArray) {
			
			s="produktuen kantitatea ez da aldatu ,"+produktuakArray+", daude";
		}
		
		
		
		PrintWriter outputStream = null;
				
		try {
			outputStream = new PrintWriter(new FileWriter(filename,true));
			outputStream.println("Fecha : "+ fecha+ "|  " + s );
			
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
	
	

	public int readFile() {
		BufferedReader bufferLectura = null;
		int produktuKantitatea=0;
		try {
			// Abrir el .csv en buffer de lectura
			bufferLectura = new BufferedReader(new FileReader(filename));
			// Leer una linea del archivo
			String linea = bufferLectura.readLine();
			while (linea != null) {
				// Sepapar la linea leída con el separador definido previamente
				String[] campos = linea.split(",");
				produktuKantitatea= Integer.parseInt(campos[1]);
				
			//produktuKantitatea = Integer.parseInt(campos[2]);

				//System.out.println(Arrays.toString(campos));
				// Volver a leer otra línea del fichero
				linea = bufferLectura.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Cierro el buffer de lectura
			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			return produktuKantitatea;

	}

		


		



}
