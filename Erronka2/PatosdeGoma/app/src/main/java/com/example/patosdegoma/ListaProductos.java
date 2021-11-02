package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import java.util.ArrayList;


public class ListaProductos extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Spinner catSpinner;
    private ListView listaProductos;
    private ArrayAdapter<Produktua> produktuakAdapter = null;
    private ArrayList<Produktua> produktuak = Produktua.produktuak;
    private ArrayList<Produktua> produktuakfiltro = Produktua.produktuak;
    public ArrayList<Produktua> produktuakActual = Produktua.produktuak;
    private SearchView search;

    String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
    String user = "openpg";
    String pass = "openpgpwd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));

        listaProductos = findViewById(R.id.listProductos);
        catSpinner = findViewById(R.id.catSpinner);
        Thread.currentThread().setPriority(1);
        DataConnect.ProduktuakQuery();

        produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);

        ArrayAdapter<String> cats = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Produktua.categorias);
        catSpinner.setAdapter(cats);

        catSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                printByCategory(adapterView.getItemAtPosition(i).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                printByCategory("Guztiak");
            }
        });

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Produktua p1 = produktuakActual.get(position);
                Intent intent = new Intent(ListaProductos.this, DetallesProductos.class);
                intent.putExtra("prod", p1);
                intent.putExtra("array", produktuakActual);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        search = (SearchView) menuItem.getActionView();

        search.setQueryHint("");
        search.setOnQueryTextListener(this);
        return true;
    }

    public void printByCategory(String categoria) {
        ArrayList<Produktua> prods = new ArrayList<>();
        if (categoria.equals("Guztiak")){
            produktuakActual = Produktua.produktuak;
            produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuakActual);
            listaProductos.setAdapter(produktuakAdapter);
        }
        else{
        for (Produktua p : Produktua.produktuak) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                prods.add(p);
            }
            produktuakActual = prods;
            produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuakActual);
            listaProductos.setAdapter(produktuakAdapter);

        }
        }
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        filtrado(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filtrado(s);
        return false;
    }

    public void filtrado(String name) {
        ArrayList<Produktua> prods = new ArrayList<>();
        if (!name.isEmpty()) {
            for (Produktua p : Produktua.produktuak) {
                if (p.getName().toLowerCase().contains(name)) {
                    prods.add(p);
                }
                produktuakActual =prods;
                produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuakActual);
                listaProductos.setAdapter(produktuakAdapter);

            }
        } else {

            produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuak);
            listaProductos.setAdapter(produktuakAdapter);
        }
    }


}