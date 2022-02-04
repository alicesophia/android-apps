package com.example.cadastropedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import helper.banco.Base64Critpo;

public class MainActivity extends AppCompatActivity {

    private EditText codigo;
    private EditText descricao;
    private EditText valor;
    private EditText qtdestoque;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = findViewById(R.id.edCodProduto);
        descricao = findViewById(R.id.edDesProduto);
        valor = findViewById(R.id.edValProduto);
        qtdestoque = findViewById(R.id.edQtdEstoque);

        FirebaseApp.initializeApp(getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Produto");
    }

    public void gravarProduto(View view){
        if(TextUtils.isEmpty(codigo.getText().toString())){
            Toast.makeText(this,"Informe o código.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(descricao.getText().toString())){
            Toast.makeText(this,"Informe a descrição.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(valor.getText().toString())){
            Toast.makeText(this,"Informe o valor.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(qtdestoque.getText().toString())){
            Toast.makeText(this, "Informe o estoque.", Toast.LENGTH_LONG).show();
        }else{

            String id = Base64Critpo.codificar(codigo.getText().toString());

            Produto produto = new Produto(id,
                                          codigo.getText().toString(),
                                          descricao.getText().toString(),
                                          valor.getText().toString(),
                                          qtdestoque.getText().toString());

            databaseReference.child(id).setValue(produto);

            Toast.makeText(this,"Produto gravado com sucesso.",Toast.LENGTH_LONG).show();
            codigo.setText("");
            descricao.setText("");
            valor.setText("");
            qtdestoque.setText("");
        }
    }

    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this,ConsultaProduto.class);
        startActivity(proximaIntent);
    }
}
