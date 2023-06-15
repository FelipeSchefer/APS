package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListagemClienteActivity extends AppCompatActivity {

    RepositoryCliente repositoryCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_cliente);

        repositoryCliente = new RepositoryCliente(this);

        List<Cliente> listaCliente =  repositoryCliente.listarCliente();

        ListView listView = findViewById(R.id.listViewCliente);
        AdapterClienteListagem adapterClienteListagem =
                new AdapterClienteListagem(this, listaCliente);

        listView.setAdapter(adapterClienteListagem);
    }
}