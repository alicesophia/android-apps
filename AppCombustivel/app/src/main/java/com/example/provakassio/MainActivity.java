package com.example.provakassio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void proximaPagina(View view) {
        Intent intent = new Intent(this, Combustivel.class);
        startActivity(intent);
    }

    public void calcularTemperatura(View view){

        EditText edTemperatura = (EditText) findViewById(R.id.edTemperatura);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        double fahrenheit = Double.valueOf(edTemperatura.getText().toString());
        double celsius = 0;

        celsius = ((fahrenheit - 32) / 1.8);

        resultado.setText(String.valueOf(celsius));

    }

}
