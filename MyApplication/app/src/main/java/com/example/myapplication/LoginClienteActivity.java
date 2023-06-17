package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginClienteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cliente);
    }

    public void listarCliente(View view){
        Intent intent = new Intent(this, ListagemClienteActivity.class);
        startActivity(intent);
    }

    public void buscarCliente(View view) {
        EditText CPF = findViewById(R.id.clienteCPFId);

        if(CPF.getText().toString().equals("")){
            Toast.makeText(this,"Campo está vaziou ou incorreto",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, BuscaClienteActivity.class);
        intent.putExtra("cpfCliente", CPF.getText().toString());
        startActivity(intent);

        CPF.setText("");
    }
    public void abrirCadastroCliente(View view) {
        Intent intent = new Intent(this, CadastraClienteActivity.class);
        startActivity(intent);
    }
}