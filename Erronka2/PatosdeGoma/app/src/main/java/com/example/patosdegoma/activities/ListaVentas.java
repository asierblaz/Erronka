package com.example.patosdegoma.activities;

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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patosdegoma.R;
import com.example.patosdegoma.models.Produktua;
import com.example.patosdegoma.models.Salmenta;

public class ListaVentas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ventas2);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        /*Icono y color del texto del menu*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Salmentak</font>"));

        ListView Lista = findViewById(R.id.Lista);
        ArrayAdapter<Salmenta> salmentaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Salmenta.salmentak);
        Lista.setAdapter(salmentaArrayAdapter);

        Lista.setOnItemClickListener(this::listaClick);

        try{
            ((TextView) findViewById(R.id.SalmentakTitle)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_SalmentakTitle", null, getPackageName()));
        }catch(Exception e){
            Log.d("String", e.getMessage());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pv_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.MenuSortu:
                Intent intent = new Intent(ListaVentas.this, CrearPedido.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    public void listaClick(AdapterView<?> adapterView, View view, int i, long l) {
        Salmenta s1 = Salmenta.salmentak.get(i);
        Intent intent = new Intent(ListaVentas.this, DetallesSalmenta.class);
        intent.putExtra("salmenta", s1);
        startActivity(intent);

    }


}