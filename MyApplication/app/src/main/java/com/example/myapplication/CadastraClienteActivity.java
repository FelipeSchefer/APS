package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraClienteActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cliente);

        repositoryConcessionaria = new RepositoryConcessionaria(this);
    }

    public void cadastrarCliente(View view) {
        EditText nome = findViewById(R.id.nomeClienteId);
        EditText CPF = findViewById(R.id.cpfClienteId);

        if(nome.getText().toString().equals("")){
            Toast.makeText(this,"O nome não poder ser vazio", Toast.LENGTH_LONG).show();
        } else if (CPF.getText().toString().equals("")) {
            Toast.makeText(this,"O CPF não poder ser vazio", Toast.LENGTH_LONG).show();
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(nome.getText().toString());
            cliente.setCPF(CPF.getText().toString());

            Toast.makeText(this, "Cliente " + cliente.getNome() + " cadastrado com sucesso", Toast.LENGTH_LONG).show();

            repositoryConcessionaria.adicionarCliente(cliente);

            finish();
        }
    }
}