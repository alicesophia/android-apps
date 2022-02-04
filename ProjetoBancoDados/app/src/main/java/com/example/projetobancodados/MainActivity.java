package com.example.projetobancodados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import helper.banco.Base64Critpo;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText email;
    EditText usuario;
    EditText senha;

    private DatabaseReference databaseReference; /** Conexão com banco */

    /**FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(cadapprinaldo,"https://cadapprinaldo.firebaseio.com/");*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        usuario = findViewById(R.id.editUsuario);
        email = findViewById(R.id.editEmail);
        senha = findViewById(R.id.editSenha);

        FirebaseApp.initializeApp(getApplicationContext());/** Conexão com banco */
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuario"); /** Conexão com banco */
    }

    public void gravarUsuario(View view){
        if(TextUtils.isEmpty(nome.getText().toString())){
            Toast.makeText(this,"Informe o seu nome.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this,"Informe seu e-mail.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(senha.getText().toString())){
            Toast.makeText(this,"Informe sua senha.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(usuario.getText().toString())){
            Toast.makeText(this, "Informe seu usuario.", Toast.LENGTH_LONG).show();
        }else{

            String id = Base64Critpo.codificar(email.getText().toString());

            Usuario user = new Usuario(id,
                                       nome.getText().toString(),
                                       usuario.getText().toString(),
                                       email.getText().toString(),
                                       senha.getText().toString());

            databaseReference.child(id).setValue(user);

            Toast.makeText(this,"Usuário gravado com sucesso.",Toast.LENGTH_LONG).show();
            nome.setText("");
            email.setText("");
            usuario.setText("");
            senha.setText("");
        }
    }
    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this, ListarEmail.class);
        startActivity(proximaIntent);
    }
}