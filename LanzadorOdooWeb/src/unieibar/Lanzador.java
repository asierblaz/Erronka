package unieibar;

import java.io.*;

public class Lanzador {

public static void main(String[] args) {
try {

ProcessBuilder pb = new ProcessBuilder("chrome","http://192.168.65.15:8069");
Process p1 = pb.start();


} catch (Exception e) {
e.printStackTrace();
}
}

}
