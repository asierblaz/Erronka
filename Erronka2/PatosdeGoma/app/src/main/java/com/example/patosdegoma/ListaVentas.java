package com.example.patosdegoma;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaVentas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ventas);

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        DataConnect.SalmentakQuery();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));

        ListView Lista = findViewById(R.id.Lista);
        ArrayAdapter<Salmenta> salmentaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Salmenta.salmentak);
        Lista.setAdapter(salmentaArrayAdapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Salmenta s1 = Salmenta.salmentak.get(i);

            }
        });

        findViewById(R.id.salmentakbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaVentas.this, CrearPedido.class);
                startActivity(intent);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pv_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_create_sale);
        /*menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ListaVentas.this, CrearPedido.class);
                //intent.putExtra("iDpedido", Salmenta.salmentak.get(0).getId());
                startActivity(intent);
                Log.d("TAG", intent.getAction());
                return true;
            }
        });*/
        return true;
    }
}