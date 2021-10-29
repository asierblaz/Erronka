package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
    String user = "openpg";
    String pass = "openpgpwd";

    private Button verListaProductosBtn;
    private Button verListaVentasBtn;
    private MenuItem aboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));

        verListaProductosBtn = findViewById(R.id.verProductosButton);
        verListaVentasBtn = findViewById(R.id.verVentasButton);

        verListaProductosBtn.setOnClickListener(this::goToListaProductos);
        verListaVentasBtn.setOnClickListener(this::goToListaVentas);
        Produktua.categorias.add("Guztiak");
        BezeroakQuery.setPriority(10);
        BezeroakQuery.start();
    }
// funcion para crear el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        aboutUs = menu.findItem(R.id.app_bar_search);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itemAbout:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemAjustes:
                Intent intent2 = new Intent(this, ListaProductos.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToListaProductos(View view) {
        Intent intent = new Intent(this, ListaProductos.class);
        startActivity(intent);
    }
    public void goToListaVentas(View view) {
        Intent intent = new Intent(this, ListaVentas.class);
        startActivity(intent);
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

    Thread BezeroakQuery = new Thread(() ->
    {
        try {
            String query = "select id, name from res_partner where user_id = 12";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Bezeroa b = new Bezeroa(
                        rs.getInt(1), rs.getString(2)
                );
                Bezeroa.bezeroak.add(b);
                Log.d("Bezeroa", b.toString());
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    }
    );


}
