package com.example.patosdegoma;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.view.View;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Produktua implements Serializable {

    public static ArrayList<Produktua> produktuak = new ArrayList<Produktua>();
    public static ArrayList<String> categorias = new ArrayList<String>();
    private int id;
    private String name;
    private String categoria;
    private String imagen;
    private float prezioa;
    public static final String SEPARADOR = ",";

    public Produktua(int id, String name, String categoria, float prezioa, String imagen) {
        super();
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.prezioa = prezioa;
        this.imagen=imagen;
    }

    public Produktua() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Produktua> getProduktuak() {
        return produktuak;
    }

    public float getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return this.getName() + "\n";
    }

    public static void categoriasToArray() {
        categorias.add("Guztiak");
        for (Produktua p : produktuak) {

            if (!esta(p.getCategoria())) {
                categorias.add(p.getCategoria());
            }
        }
    }

    public static boolean esta(String s) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void fileToArraylist(Context c) {
        String separador = ",";
        BufferedReader bufferLectura = null;
        try {
            InputStream is = c.getResources().openRawResource(R.raw.produktuak);

            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            while (linea != null) {

                // Sepapar la linea leída con el separador definido previamente
                String[] campos = linea.split(separador);
                Produktua p1 = new Produktua(Integer.parseInt(campos[0]), campos[1], campos[2], Float.parseFloat(campos[3]),campos[4]);
                Produktua.produktuak.add(p1);

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


    }


}


