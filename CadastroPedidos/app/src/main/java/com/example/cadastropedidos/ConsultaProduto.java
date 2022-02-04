package com.example.cadastropedidos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ConsultaProduto extends AppCompatActivity {

    private EditText codigo;
    private TextView codProduto;
    private TextView desProduto;
    private TextView valProduto;
    private TextView qtdEstoque;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_produto);

        codigo = findViewById(R.id.codigoConsulta);
        codProduto = findViewById(R.id.codigo);
        desProduto = findViewById(R.id.descricao);
        valProduto = findViewById(R.id.valor);
        qtdEstoque = findViewById(R.id.qtdEstoque);

        FirebaseApp.initializeApp(getApplicationContext());
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Produto");
    }

    public void consultarProduto(View view) {

        if (TextUtils.isEmpty(codigo.getText().toString())) {
            Toast.makeText(this, "Informe o e-mail a ser consultado.", Toast.LENGTH_LONG).show();
        }else{

            String id = codigo.getText().toString();
            id = Base64Critpo.codificar(id);

            databaseReference = databaseReference.child(id);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Produto produto = dataSnapshot.getValue(Produto.class);
                    if(produto!= null){

                        codProduto.setText(produto.getCodigo());
                        desProduto.setText(produto.getDescricao());
                        valProduto.setText(produto.getValor());
                        qtdEstoque.setText(produto.getQtdEstoque());
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
    }
    public void excluirProduto(View view){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Produto");
        if (TextUtils.isEmpty(codigo.getText().toString())){
            Toast.makeText(this,"informe o código a ser excluído.",Toast.LENGTH_LONG).show();
        }else{
            String id = codigo.getText().toString();
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
        Intent proximaIntent = new Intent(this, CadastroClientes.class);
        startActivity(proximaIntent);
    }

    public void voltarPagina(View view){
        Intent proximaIntent = new Intent(this,MainActivity.class);
        startActivity(proximaIntent);
    }

}
