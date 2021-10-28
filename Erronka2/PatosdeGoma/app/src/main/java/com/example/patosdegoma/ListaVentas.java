package com.example.patosdegoma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaVentas extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ventas);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        SalmentakQuery.setPriority(Thread.MAX_PRIORITY);
        SalmentakQuery.start();

        ListView Lista = findViewById(R.id.Lista);
        Log.d("TAG", Salmenta.salmentak.toString());
        ArrayAdapter<Salmenta> salmentaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Salmenta.salmentak);
        Lista.setAdapter(salmentaArrayAdapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Salmenta s1 = Salmenta.salmentak.get(i);
                Log.d("TAG", s1.toStringAll());

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_create_sale);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ListaVentas.this, CrearPedido.class);
                return true;
            }
        });
        return true;
    }


    public Connection Connect() {
        String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
        String user = "openpg";
        String pass = "openpgpwd";
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

    Thread SalmentakQuery = new Thread(() ->
    {
        try {
            String query = "Select id, name, state, date_order, create_date, partner_id, " +
                    "invoice_status, amount_untaxed, amount_tax, amount_total from sale_order " +
                    "order by name desc";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Salmenta s = new Salmenta(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7),
                        rs.getFloat(8), rs.getFloat(9),
                        rs.getFloat(10)
                );
                Salmenta.salmentak.add(s);
                Log.d("Salmenta", s.toString());
            }
            conn.close();
        } catch (Exception e) {
            Log.d("TAG", "run: Failed"+ e.getMessage());
        }
    });

}