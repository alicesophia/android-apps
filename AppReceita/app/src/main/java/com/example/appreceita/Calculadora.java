package com.example.appreceita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this, Fatorial.class);
        startActivity(intent);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this, CaixaEletronico.class);
        startActivity(intent);
    }

    public void calcular(View view) {

        EditText valor1 = (EditText) findViewById(R.id.valor1);
        EditText valor2 = (EditText) findViewById(R.id.valor2);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        RadioGroup opcoes = (RadioGroup) findViewById(R.id.radiogroup1);

        int v1 = Integer.valueOf(valor1.getText().toString());
        int v2 = Integer.valueOf(valor2.getText().toString());
        int valorFinal = 0;

        switch (opcoes.getCheckedRadioButtonId()){
            case R.id.somar:
                valorFinal = v1+v2;
                break;
            case R.id.subtrair:
                valorFinal = v1-v2;
                break;
            case R.id.multiplicar:
                valorFinal = v1*v2;
                break;
            case R.id.dividir:
                valorFinal = v1/v2;
                break;
        }

        resultado.setText(String.valueOf(valorFinal));

    }


}
