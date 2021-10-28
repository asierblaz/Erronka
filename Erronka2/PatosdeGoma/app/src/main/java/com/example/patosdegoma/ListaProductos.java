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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;


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
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));
        //definir elementos
        listaProductos = findViewById(R.id.listProductos);
        catSpinner = findViewById(R.id.catSpinner);
        Thread.currentThread().setPriority(1);
        ProduktuakQuery.setPriority(10);
        ProduktuakQuery.start();

        //adapter lista productos
        produktuakAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);

        //Añadir categorias al spinner
        ArrayAdapter<String> cats = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Produktua.categorias);
        catSpinner.setAdapter(cats);

        //funciones
        //Evento categoria
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

        //evento list View
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
    //a

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        search = (SearchView) menuItem.getActionView();

        search.setQueryHint("");
        search.setOnQueryTextListener(this);
        return true;
    }

    public Connection Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Log.d("Connection", conn.toString());
            return conn;
        } catch (SQLException se) {
            Log.d("SQLException", "oops! No se puede conectar. Error: " + se.toString());
        } catch (ClassNotFoundException e) {
            Log.d("ClassNotFoundException", "oops! No se encuentra la clase. Error: " + e.getMessage());
        }
        return null;
    }

    Thread ProduktuakQuery = new Thread(() ->
    {
        try {
            String query = "select product_template.id, product_template.name, product_category.complete_name as category, product_template.list_price, product_template.default_code from product_template\n" +
                    "inner join product_category on product_template.categ_id =product_category.id \n" +
                    "order by name asc";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Produktua p = new Produktua(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5).toLowerCase()
                );
                Produktua.produktuak.add(p);
                Log.d("Produktua", p.toString());
            }
            Produktua.categoriasToArray();
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    }
    );

    //imprime todos los productos
//    public void imprimirTodos() {
//        produktuak = Produktua.produktuak;
//        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
//        listaProductos.setAdapter(produktuakAdapter);
//    }

    //imprime los productos por categoria
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