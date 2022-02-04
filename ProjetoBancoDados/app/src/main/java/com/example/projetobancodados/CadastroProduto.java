package com.example.projetobancodados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadastroProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
    }

    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this,CadastroProduto.class);
        startActivity(proximaIntent);
    }
    public void voltarPagina(View view){
        Intent proximaIntent = new Intent(this,ListViewClasse.class);
        startActivity(proximaIntent);
    }
}
