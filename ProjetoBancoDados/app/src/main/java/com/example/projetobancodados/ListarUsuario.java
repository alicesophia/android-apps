package com.example.projetobancodados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import helper.banco.Base64Critpo;

public class ListarUsuario extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText email;
    private TextView nomeUser;
    private TextView userUser;
    private TextView senhaUser;
    private TextView emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        email = findViewById(R.id.emailConsulta);
        nomeUser = findViewById(R.id.nome);
        userUser = findViewById(R.id.usuario);
        senhaUser = findViewById(R.id.senha);
        emailUser = findViewById(R.id.email);

        FirebaseApp.initializeApp(getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuario"); /** Conexão com banco */
    }
    public void consultaUsuario (View view) {

        if (TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(this, "Informe o e-mail a ser consultado.", Toast.LENGTH_LONG).show();
        }else{

            String id = email.getText().toString();
            id = Base64Critpo.codificar(id);

            databaseReference = databaseReference.child(id);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    if(usuario!= null){

                        userUser.setText(usuario.getUsuario());
                        nomeUser.setText(usuario.getNome());
                        emailUser.setText(usuario.getEmail());
                        senhaUser.setText(usuario.getSenha());
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
    }
    public void excluiUsuario (View view){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuario");
        if (TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this,"informe o email a ser excluido.",Toast.LENGTH_LONG).show();;
        }else{
            String id = email.getText().toString();
            id = Base64Critpo.codificar(id);

            databaseReference = databaseReference.child(id);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    databaseReference.removeValue();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
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