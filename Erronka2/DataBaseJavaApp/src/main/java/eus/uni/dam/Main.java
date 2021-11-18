package eus.uni.dam;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.postgres.ProductTemplate;
import model.postgres.ResPartner;
import model.postgres.SaleOrderLine;

@SpringBootApplication
public class Main {

	private static ControllerSqlServer cs;
	private static ControllerPostgres cp;
	private static List<ProductTemplate> produktuak;
	private static List<ResPartner> bezeroak;
	private static List<SaleOrderLine> erosketak;
	private static ControllerXML cxml = new ControllerXML();

	public static void main(String[] args) throws Throwable {
		datuakInportatu();
		cs = new ControllerSqlServer();

		System.out.println();
		System.out.println("------------PATINHOS GOMOSOS----------------");

		int n, kantitatea;

		Scanner in = new Scanner(System.in);

		System.out.println("\tMENUA\n" + "====================================\n" + "1.- Datu Guztiak Esportatu\n"
				+ "2.- Esportatu nahi diren datuak aukeratu\n" + "3.- Log-a Irakurri\n" + "4.- Log-a Ikusi\n"
				+ "5-Irten");

		System.out.print("\nAukeratu zenbaki bat ");

		n = in.nextInt();

		while (n != 5) {

			if (n == 1) { // datu guztiak esportatu

				datuakEsportatu();
				addToLog("Datu base osoa esportatu da");

			}
			if (n == 2) { // menu

				System.out.println("\tESPORTATU NAHI DIREN DATUAK AUKERATU\n" + "====================================\n"
						+ "1.- X produktu baino gutxiago dituzten erosketak\n"
						+ "2.- Azken Exportazioaren konfigurazioa\n" + "3.- Atzera");

				System.out.print("\nAukeratu zenbaki bat ");

				int aukera = in.nextInt();

				while (aukera != 3) {

					if (aukera == 1) { // x produktu baino gehiago dituzten erosketak

						System.out.print("\nAukeratu Produktu kopuru bat ");
						kantitatea = Math.abs(in.nextInt());

						if (kantitatea == 0) {
							System.out.println("Kantitatea ezin da 0 izan");
						} else {
							try {

								cxml.setProduktuKantitatea(kantitatea);
								cs.deleteErosketaGuztiak();
								cs.erosketakXBainoGutxiago(erosketak, kantitatea);
								System.out.println(
										kantitatea + " produktu baino gutxiago dituzten erosketak esportatu dira");
								cxml.addToLogXML(
										kantitatea + " produktu baino gutxiago dituzten erosketak esportatu dira");
							} catch (Exception e) {
								System.err.println("Fitxategia ez da aurkitu");

							}
						}

					}
					if (aukera == 2) {
						kantitatea = 0;
						try {
							kantitatea = cxml.getProduktuKantitateaXml();
							cs.deleteErosketaGuztiak();
							cs.erosketakXBainoGutxiago(erosketak, kantitatea);
							System.out.println("Aurretik dagoen konfigurazioa esportatu da, " + kantitatea
									+ " produktu baino gutxiago dituzten erosketak esportatu dira");
							cxml.addToLogXML("Aurretik dagoen konfigurazioa esportatu da, " + kantitatea
									+ " produktu baino gutxiago dituzten erosketak esportatu dira");

						} catch (Exception e) {
							System.err.println("Fitxategia ez da aurkitu");
						}
						if (kantitatea == 0) {
							System.out.println("Ez da aurkitu aurretik konfiguraziorik");
						}

					}

					System.out.println(
							"\tESPORTATU NAHI DIREN DATUAK AUKERATU\n" + "====================================\n"
									+ "1.- X produktu baino gutxiago dituzten erosketak\n"
									+ "2.- Azken Exportazioaren konfigurazioa\n" + "3.- Atzera");

					System.out.print("\nAukeratu zenbaki bat ");
					aukera = in.nextInt();
				}
			}

			if (n == 3) { // Log-a Irakurri
				try {
					System.out.println("\n\tLog-ean dauden Erregistroak:\n");
					System.out.println(cxml.irakurriLoga());
				} catch (Exception e) {
					System.err.println("Fitxategia ez da aurkitu");
				}
			}

			if (n == 4) {
				logaIrekiProcess();
			}

			System.out.println("\tMENUA\n" + "====================================\n" + "1.- Datu Guztiak Esportatu\n"
					+ "2.- Esportatu nahi diren datuak aukeratu\n" + "3.- Log-a Irakurri\n" + "4.- Log-a Ikusi\n"
					+ "5- Irten");
			System.out.print("\nAukeratu zenbaki bat ");
			n = in.nextInt();

		}
		System.out.println("\nEskerrik asko (Patinhos Gomosos)");
		cs.closeContext();
	}

	public static void datuakInportatu() {

		// datuak postgresetik hartu
		cp = new ControllerPostgres();
		produktuak = cp.produktuakToList();
		bezeroak = cp.bezeroakToList();
		erosketak = cp.erosketakToList();
		cp.closeContext();
	}

	public static void datuakEsportatu() {

		// datuak postgresetik hartu
		cs.produktuakToDB(produktuak);
		cs.bezeroakToDB(bezeroak);
		cs.erosketakToDB(erosketak);
	}

	public static void addToLog(String s) throws Throwable {
		try {
			cxml.addToLogXML(s);
		} catch (Exception e) {
			System.out.println("Fitxategia ez da existitzen, berri bat sortu da");
			cxml.createXML();
			cxml.addToLogXML(s);
		}

	}

	public static void logaIrekiProcess() {

		try {

			ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe\"","file:///C:/Users/blazquez.asier/Documents/DAM2/Erronka/Erronka2/DataBaseJavaApp/options.xml");
			// ProcessBuilder pb = new ProcessBuilder("chrome",
			// "C:\\Users\\blazquez.asier\\Desktop\\Nueva carpeta\\options.xml");
			Process p1 = pb.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
