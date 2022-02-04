package com.example.projetobancodados;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListarEmail extends AppCompatActivity {

    private ListView lista;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_email);
        lista = findViewById(R.id.listaUsuario);

        FirebaseApp.initializeApp(getApplicationContext());/** Conexão com banco */
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuario"); /** Conexão com banco */

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i = 0;

                String[] usuario = new String[(int) dataSnapshot.getChildrenCount()];
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    Usuario u = item.getValue(Usuario.class);
                    usuario[i] = u.getNome() + " - " + u.getEmail();
                    i++;
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, usuario);
                lista.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void proximaPagina(View view){
        Intent proximaIntent = new Intent(this,ListViewClasse.class);
        startActivity(proximaIntent);
    }

    public void voltarPagina(View view){
        Intent voltarIntent = new Intent(this,MainActivity.class);
        startActivity(voltarIntent);
    }

}
