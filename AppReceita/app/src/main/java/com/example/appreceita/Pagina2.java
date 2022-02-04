package com.example.appreceita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Pagina2 extends AppCompatActivity {

    int resultadoApp = 0;
    int resultadoJogador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void proximaPagina(View view){
        Intent intent = new Intent(this, JurosComposto.class);
        startActivity(intent);
    }

    public void selecionarPedra(View view){
        selecionarOpcao("pedra");
    }

    public void selecionarPapel(View view){
        selecionarOpcao("papel");
    }

    public void selecionarTesoura(View view){
        selecionarOpcao("tesoura");
    }

    public void selecionarOpcao(String opcao){
        ImageView imagem = (ImageView) findViewById(R.id.imagemApp);
        TextView texto = (TextView) findViewById(R.id.valorFinal);
        TextView placarApp = (TextView) findViewById(R.id.placarApp);
        TextView placarJogador = (TextView) findViewById(R.id.placarJogador);

        String[] opcoesApp = {"pedra","papel","tesoura"};
        int numero = new Random().nextInt(3);

        String opcao1 = opcoesApp[numero];

        if (opcao1.equals("pedra")){
            imagem.setImageResource(R.drawable.pedra);
        }else if (opcao1.equals("tesoura")){
            imagem.setImageResource(R.drawable.tesoura);
        }else{
            imagem.setImageResource(R.drawable.papel);
        }

        if (opcao1.equals(opcao)){
            texto.setText("Empate!");
        }else if (opcao1.equals("pedra") & (opcao.equals("papel"))
               | (opcao1.equals("tesoura") & opcao.equals("pedra"))
               | (opcao1.equals("papel")) & opcao.equals("tesoura")){
            texto.setText("Você ganhou!");
            resultadoJogador += 1;
        }else{
            texto.setText("Você perdeu!");
            resultadoApp += 1;
        }

        placarApp.setText(String.valueOf(resultadoApp));
        placarJogador.setText(String.valueOf(resultadoJogador));

    }

}
