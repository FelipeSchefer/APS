package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BuscaClienteActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_cliente);

        Intent intent = getIntent();
        String CPF = intent.getStringExtra("cpfCliente");

        Toast.makeText(this,"CPF " + CPF,Toast.LENGTH_LONG).show();

        repositoryConcessionaria = new RepositoryConcessionaria(this);

        List<Cliente> listaCliente =  repositoryConcessionaria.buscarClientePeloCPF(CPF);
        if(listaCliente.isEmpty()){
            Toast.makeText(this,"Cliente não encontrado",Toast.LENGTH_LONG).show();
        }else{
            ListView listView = findViewById(R.id.listViewCliente);
            AdapterClienteListagem adapterClienteListagem =
                    new AdapterClienteListagem(this, listaCliente);

            listView.setAdapter(adapterClienteListagem);
        }
    }
}