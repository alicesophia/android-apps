package com.example.provakassio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Combustivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this,  ComparoCombustivel.class);
        startActivity(intent);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this,  MainActivity.class);
        startActivity(intent);
    }

    public void calcularCombustivel(View view){
        EditText valorCombustivel = (EditText) findViewById(R.id.valor);
        EditText qtdLitros = (EditText) findViewById(R.id.litros);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        RadioGroup opcoes = (RadioGroup) findViewById(R.id.radiogroup1);

        double valor = Double.valueOf(valorCombustivel.getText().toString());
        double litros = Double.valueOf(qtdLitros.getText().toString());
        double total = valor*litros;

        switch (opcoes.getCheckedRadioButtonId()){
            case R.id.alcool:
                if (litros <= 30){
                    total -= (total * 3) / 100;
                }else if (litros > 30 & litros <= 40){
                    total -= (total * 3.5) / 100;
                }else if (litros > 40 & litros <= 50){
                    total -= (total * 4.5) / 100;
                }else if (litros > 50){
                    total -= (total * 7) / 100;
                }
                break;
            case R.id.gasolina:
                if (litros <= 10){
                    total -= (total * 2) / 100;
                }else if (litros > 10 & litros <= 20){
                    total -= (total * 3) / 100;
                }else if (litros > 20 & litros <= 30){
                    total -= (total * 4.5) / 100;
                }else if (litros > 30){
                    total -= (total * 7) / 100;
                }
        }

        resultado.setText("Valor total a pagar: " +total);

    }
}
