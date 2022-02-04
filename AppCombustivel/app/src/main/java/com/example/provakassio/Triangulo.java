package com.example.provakassio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Triangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this,  ComparoCombustivel.class);
        startActivity(intent);
    }

    public void retornarNomeTriangulo(View view){
        EditText v1 = (EditText) findViewById(R.id.lado1);
        EditText v2 = (EditText) findViewById(R.id.lado2);
        EditText v3 = (EditText) findViewById(R.id.lado3);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        int lado1 = Integer.valueOf(v1.getText().toString());
        int lado2 = Integer.valueOf(v2.getText().toString());
        int lado3 = Integer.valueOf(v3.getText().toString());
        String nomeTriangulo = "";

        if (lado1 == lado2 & lado2 == lado3){
            nomeTriangulo = "equilátero";
        }else if ((lado1 == lado2 & lado2 != lado3)
               |  (lado1 == lado3 & lado1 != lado2)
               |  (lado2 == lado3 & lado2 != lado1)
               |  (lado2 == lado1 & lado2 != lado3)
               |  (lado3 == lado2 & lado3 != lado1)
               |  (lado3 == lado1 & lado3 != lado2)){
            nomeTriangulo = "isóceles";
        }else{
            nomeTriangulo="escaleno";
        }

        resultado.setText("Seu triângulo é um: "+nomeTriangulo);

    }

}
