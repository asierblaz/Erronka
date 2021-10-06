package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button verListaProductosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("o");

        //Carga csv a produktuak
        Produktua.fileToArraylist(this);
        Produktua.categoriasToArray();
        verListaProductosBtn = findViewById(R.id.verProductosButton);
        verListaProductosBtn.setOnClickListener(this::goToListaProductos);

    }


    public void goToListaProductos(View view) {
        Intent intent = new Intent(this, ListaProductos.class);
        startActivity(intent);
    }

}
