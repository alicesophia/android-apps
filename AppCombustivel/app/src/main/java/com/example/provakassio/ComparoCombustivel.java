package com.example.provakassio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class ComparoCombustivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparo_combustivel);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this,  Triangulo.class);
        startActivity(intent);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this,  Combustivel.class);
        startActivity(intent);
    }

    public void calcularCombustivel(View view){
        EditText gAlcool = (EditText) findViewById(R.id.edAlcoolGasto);
        EditText gGasolina = (EditText) findViewById(R.id.edGasolinaGasto);
        EditText vAlcool = (EditText) findViewById(R.id.edAlcoolPreco);
        EditText vGasolina = (EditText) findViewById(R.id.edGasolinaPreco);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        double gastoAlcool = Double.valueOf(gAlcool.getText().toString());
        double gastoGasolina = Double.valueOf(gGasolina.getText().toString());
        double valorAlcool = Double.valueOf(vAlcool.getText().toString());
        double valorGasolina = Double.valueOf(vGasolina.getText().toString());

        double gastoFinalAlcool = valorAlcool*gastoAlcool;
        double gastoFinalGasolina = valorGasolina*gastoGasolina;

        if (gastoAlcool > gastoFinalGasolina){
            resultado.setText("É mais viável abastecer usando gasolina.\n"+
                              "Gasto usando álcool: " +gastoFinalAlcool +
                              "\nGasto usando gasolina: " +gastoFinalGasolina);
        }else{
            resultado.setText("É mais viável abastecer usando álcool.\n"+
                              "Gasto usando álcool: " +gastoFinalAlcool +
                              "\nGasto usando gasolina: " +gastoFinalGasolina);
        }


    }

}
