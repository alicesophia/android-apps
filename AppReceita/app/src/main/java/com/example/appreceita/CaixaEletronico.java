package com.example.appreceita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CaixaEletronico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa_eletronico);
    }

    public void voltarPagina(View view){
        Intent intent = new Intent(this,  Calculadora.class);
        startActivity(intent);
    }

    public void realizarSaque(View view){
        EditText valor = (EditText) findViewById(R.id.valor);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        int valor1 = Integer.valueOf(valor.getText().toString());
        int nota100 = 0;
        int nota50 = 0;
        int nota20 = 0;
        int nota10 = 0;
        int nota5 = 0;
        int nota2 = 0;
        int valorAux = valor1;

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                for (int k = 0; k < 100; k++){
                    for (int l = 0; l < 100; l++){
                        for (int m = 0; m < 100; m++){
                            for (int n = 0; n < 100; n++){
                                if (valorAux >= 100){
                                    nota100++;
                                    valorAux -= 100;
                                }else{
                                    break;
                                }
                            }
                            if (valorAux >= 50){
                                nota50++;
                                valorAux -= 50;
                            }else{
                                break;
                            }
                        }
                        if (valorAux >= 20){
                            nota20++;
                            valorAux -= 20;
                        }else{
                            break;
                        }
                    }
                    if (valorAux >= 10){
                        nota10++;
                        valorAux -= 10;
                    }else{
                        break;
                    }
                }
                if (valorAux >= 5){
                    nota5++;
                    valorAux -= 5;
                }else{
                    break;
                }
            }
            if (valorAux >= 2){
                nota2++;
                valorAux -= 2;
            }
        }

        resultado.setText("Para sacar R$" + valor1 + " serão necessárias:\n" +nota100+ " nota(s) de Cem,\n" +nota50+ " nota(s) de Cinquenta,\n" +nota20+ " nota(s) de Vinte,\n"
                          +nota10+" nota(s) de Dez,\n" +nota5+ " nota(s) de Cinco,\n" +nota2+ " nota(s) de Dois.");
    }
}
