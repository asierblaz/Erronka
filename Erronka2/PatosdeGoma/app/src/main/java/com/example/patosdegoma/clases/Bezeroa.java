package com.example.patosdegoma.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Bezeroa implements Serializable {

    public static ArrayList<Bezeroa> bezeroak = new ArrayList<>();

    int id;
    String name;

    public Bezeroa(int id, String name) {
        super();
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return name + '\n';
    }

}
