package com.example.appreceita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class JurosComposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_composto);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this, Pagina2.class);
        startActivity(intent);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this, Fatorial.class);
        startActivity(intent);
    }

    public void calcularJuros(View view){

        EditText valor = (EditText) findViewById(R.id.valor2);
        EditText juros = (EditText) findViewById(R.id.juros);
        EditText parcelas = (EditText) findViewById(R.id.parcelas);
        TextView valorFinal = (TextView) findViewById(R.id.valorFinal);

        double valorD = Double.valueOf(valor.getText().toString());
        double jurosD = Double.valueOf(juros.getText().toString());
        int    parcelasD = Integer.valueOf(parcelas.getText().toString());

        for (int i = 1; i <= parcelasD; i++){
            valorD += ((jurosD * valorD) / 100);
        }

        valorFinal.setText(String.valueOf(valorD));

    }
}
