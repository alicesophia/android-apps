package com.example.projetobancodados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewClasse extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lista = findViewById(R.id.lista);

        String[] frutas = {"banana", "maçã", "melão", "melancia"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, frutas);

        lista.setAdapter(adapter);

    }

    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this,ListarUsuario.class);
        startActivity(proximaIntent);
    }

    public void voltarPagina(View view){
        Intent voltarIntent = new Intent(this, ListarEmail.class);
        startActivity(voltarIntent);
    }
}
