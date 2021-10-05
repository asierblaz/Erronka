package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;


public class ListaProductos extends AppCompatActivity {

    private Spinner catSpinner;
    private ListView listaProductos;
    private ArrayAdapter<Produktua> produktuakAdapter = null;
    private ArrayList<Produktua> produktuak = Produktua.produktuak;
    private Button buscarButton;
    private TextView txtBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        //definir elementos
        listaProductos = findViewById(R.id.listProductos);
        catSpinner = findViewById(R.id.catSpinner);
        buscarButton = findViewById(R.id.buscarButton);
        txtBuscar = findViewById(R.id.txtBuscar);


        //adapter lista productos
        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);

        //Añadir categorias al spinner
        ArrayAdapter<String> cats = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Produktua.categorias);
        catSpinner.setAdapter(cats);

        //funciones
        buscarButton.setOnClickListener(this::buscar);
        //Evento categoria
        catSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("Guztiak")) {
                    imprimirTodos();
                } else {
                    printByCategory(adapterView.getItemAtPosition(i).toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                imprimirTodos();
            }
        });

        //evento list View
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Produktua p1 = produktuak.get(position);
                Intent intent = new Intent(ListaProductos.this, DetallesProductos.class);
                intent.putExtra("prod", p1);
                startActivity(intent);
                //Toast.makeText(ListaCat.this, "Has pulsado: "+ p1.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }


    //imprime todos los productos
    public void imprimirTodos() {
        produktuak= Produktua.produktuak;
        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);
    }

    //imprime los productos por categoria
    public void printByCategory(String categoria) {

        ArrayList<Produktua> prods = new ArrayList<Produktua>();
        for (Produktua p : Produktua.produktuak) {
            if (p.getCategoria().toLowerCase().equals(categoria.toLowerCase()) ){
                prods.add(p);
            }
            produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, prods);
            listaProductos.setAdapter(produktuakAdapter);

        }
    }

    public void buscar(View V){
        printByName(txtBuscar.getText().toString().toLowerCase());
    }


    public void printByName(String name){
        ArrayList<Produktua> prods = new ArrayList<Produktua>();
        if (!name.isEmpty()) {
            for (Produktua p : Produktua.produktuak) {
                if (p.getName().toLowerCase().contains(name)) {
                    prods.add(p);
                }
                produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, prods);
                listaProductos.setAdapter(produktuakAdapter);

            }
        } else {
            produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
            listaProductos.setAdapter(produktuakAdapter);
        }
    }


}