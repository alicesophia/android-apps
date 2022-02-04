package com.example.appreceita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Fatorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorial);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this, JurosComposto.class);
        startActivity(intent);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this, Calculadora.class);
        startActivity(intent);
    }

    public void calcularFatorial(View view){

        EditText numeroFatorial = (EditText) findViewById(R.id.fatorial);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        int numero = Integer.valueOf(numeroFatorial.getText().toString());

        for (int i = numero-1; i > 0; i--){
            numero = numero * i;
        }

        resultado.setText(String.valueOf(numero));

    }

}
