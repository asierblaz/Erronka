package com.example.patosdegoma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.patosdegoma.R;
import com.example.patosdegoma.models.Produktua;
import com.example.patosdegoma.models.Salmenta;

import org.w3c.dom.Text;

public class DetallesSalmenta extends AppCompatActivity {

    private TextView salmentaName;
    private TextView state;
    private TextView dateOrder;
    private TextView createDate;
    private TextView invoiceStatus;
    private TextView partnerId;
    private TextView amountTax;
    private TextView amountUntaxed;
    private TextView amountTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_salmenta);


        Salmenta s1 = (Salmenta) getIntent().getSerializableExtra("salmenta");
        //Icono y color del texto del menu
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Log.d("Venta", s1.toStringAll());

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Salmentak</font>"));

        salmentaName = findViewById(R.id.salmentaTextView);
        state = findViewById(R.id.stateTextView);
        dateOrder = findViewById(R.id.dateTextView);
        createDate = findViewById(R.id.createDateTextview);
        invoiceStatus = findViewById(R.id.invoiceStatusTextView);
        amountTax = findViewById(R.id.amountaxTextView);
        amountUntaxed = findViewById(R.id.untaxedTextView);
        amountTotal = findViewById(R.id.amountTotalTextView);

        salmentaName.setText(s1.getName());
        state.setText(s1.getState());
        dateOrder.setText(s1.getDate_order());
        createDate.setText(s1.getCreate_date());
        amountTotal.setText(s1.getAmount_total() + "");
        amountUntaxed.setText(s1.getAmount_untaxed() + "");
        amountTax.setText(s1.getAmount_tax() + "€");
    }
}