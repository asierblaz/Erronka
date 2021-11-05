package com.example.patosdegoma.clases;

import java.io.*;
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
    public String toStringAll() {
        return this.getId() + "\t"+ this.getName() +"\t" + this.getCategoria() +"\t" + this.getPrezioa() +"\t" + this.getImagen() + "\n";
    }

    public static void categoriasToArray() {
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

}


