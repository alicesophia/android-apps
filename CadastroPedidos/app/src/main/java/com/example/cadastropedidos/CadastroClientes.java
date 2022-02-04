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

public class CadastroClientes extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    private EditText edSenha;
    private EditText edEndereco;
    private EditText edSexo;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_clientes);

        edNome = findViewById(R.id.edNomeCliente);
        edEmail = findViewById(R.id.edEmailCliente);
        edSenha = findViewById(R.id.edSenhaCliente);
        edEndereco = findViewById(R.id.edEnderecoCliente);
        edSexo = findViewById(R.id.edSexoCliente);

        FirebaseApp.initializeApp(getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Cliente");
    }

    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this, CadastroClientes.class);
        startActivity(proximaIntent);
    }

    public void voltarPagina(View view){
        Intent proximaIntent = new Intent(this,ConsultaProduto.class);
        startActivity(proximaIntent);
    }

    public void gravarCliente(View view){
        if(TextUtils.isEmpty(edNome.getText().toString())){
            Toast.makeText(this,"Informe o seu nome.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(edEmail.getText().toString())){
            Toast.makeText(this,"Informe seu e-mail.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(edSenha.getText().toString())){
            Toast.makeText(this,"Informe sua senha.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(edEndereco.getText().toString())){
            Toast.makeText(this, "Informe seu endereço.", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(edSexo.getText().toString())){
            Toast.makeText(this, "Informe seu sexo.", Toast.LENGTH_LONG).show();
        }else{

            String id = Base64Critpo.codificar(edEmail.getText().toString());

            Cliente cliente = new Cliente(id,
                                          edNome.getText().toString(),
                                          edEmail.getText().toString(),
                                          edSenha.getText().toString(),
                                          edEndereco.getText().toString(),
                                          edSexo.getText().toString());

            databaseReference.child(id).setValue(cliente);

            Toast.makeText(this,"Cliente gravado com sucesso.",Toast.LENGTH_LONG).show();
            edNome.setText("");
            edEmail.setText("");
            edSenha.setText("");
            edEndereco.setText("");
            edSexo.setText("");
        }
    }


}
