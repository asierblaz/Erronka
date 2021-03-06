package com.example.patosdegoma.activities;

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
import android.widget.TextView;

import com.example.patosdegoma.R;
import com.example.patosdegoma.models.Produktua;

import java.util.ArrayList;


public class ListaProductos extends AppCompatActivity {

    public ArrayList<Produktua> produktuakActual = Produktua.produktuak;
    String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
    String user = "openpg";
    String pass = "openpgpwd";
    private Spinner catSpinner;
    private ListView listaProductos;
    private ArrayAdapter<Produktua> produktuakAdapter = null;
    private ArrayList<Produktua> produktuak = Produktua.produktuak;
    private ArrayList<Produktua> produktuakfiltro = Produktua.produktuak;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos2);


        //Icono y color del texto del menu
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Produktuak</font>"));

        listaProductos = findViewById(R.id.listProductos);
        catSpinner = findViewById(R.id.catSpinner);

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

        listaProductos.setOnItemClickListener(this::productoClick);

        try{
            ((TextView) findViewById(R.id.CatList)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_CatList", null, getPackageName()));
            ((TextView)findViewById(R.id.ProdList)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_ProdList", null, getPackageName()));
            ((TextView)findViewById(R.id.ProdTitle)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_ProdTitle", null, getPackageName()));
            ((TextView)findViewById(R.id.CatList2)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_CatList", null, getPackageName()));
            ((TextView)findViewById(R.id.ProdList2)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_ProdList", null, getPackageName()));
            ((MenuItem)findViewById(R.id.MenuBilatu)).setTitle(getResources().getIdentifier("@string/"+MainActivity.lang+"_MenuBilatu",null,getPackageName()));
        }catch(Exception e){
            Log.d("String", e.getMessage());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.MenuBilatu);
        search = (SearchView) menuItem.getActionView();

        search.setQueryHint("");
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        });
        return true;
    }

    public void printByCategory(String categoria) {
        ArrayList<Produktua> prods = new ArrayList<>();
        if (categoria.equals("Guztiak")) {
            produktuakActual = Produktua.produktuak;
            produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuakActual);
            listaProductos.setAdapter(produktuakAdapter);
        } else {
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

    public void filtrado(String name) {
        ArrayList<Produktua> prods = new ArrayList<>();
        if (!name.isEmpty()) {
            for (Produktua p : Produktua.produktuak) {
                if (p.getName().toLowerCase().contains(name)) {
                    prods.add(p);
                }
                produktuakActual = prods;
                produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuakActual);
                listaProductos.setAdapter(produktuakAdapter);

            }
        } else {

            produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuak);
            listaProductos.setAdapter(produktuakAdapter);
        }
    }

    public void productoClick(AdapterView<?> adapterView, View view, int position, long id) {
        Produktua p1 = produktuakActual.get(position);
        Intent intent = new Intent(ListaProductos.this, DetallesProductos.class);
        intent.putExtra("prod", p1);
        intent.putExtra("array", produktuakActual);
        startActivity(intent);
    }

}