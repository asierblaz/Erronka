package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesProductos extends AppCompatActivity {

    private TextView textNombre;
    private TextView textCategoria;
    private TextView textPrecio;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));
        textNombre = findViewById(R.id.textNombre);
        textPrecio = findViewById(R.id.texPrecio);
        textCategoria = findViewById(R.id.textCategoria);
        img = findViewById(R.id.imageView);
        Produktua p1 = (Produktua) getIntent().getSerializableExtra("prod");

        textNombre.setText(p1.getName());
        textCategoria.setText(p1.getCategoria());
        float precio = (float) (p1.getPrezioa()*1.21);
        textPrecio.setText(String.format("%.2f", precio)+" €");

    int imageRes= getResources().getIdentifier("@drawable/nofoto",null,getPackageName());
        Drawable draw= getResources().getDrawable(imageRes);
        img.setImageDrawable(draw);

        try {
            img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + p1.getImagen(), null, getPackageName())));

        } catch (Exception e) {
            img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));

        }

    }
}