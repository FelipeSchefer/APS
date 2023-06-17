package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListagemClienteActivity extends AppCompatActivity {
    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_cliente);

        repositoryConcessionaria = new RepositoryConcessionaria(this);

        List<Cliente> listaCliente =  repositoryConcessionaria.listarCliente();

        ListView listView = findViewById(R.id.listViewCliente);
        AdapterClienteListagem adapterClienteListagem =
                new AdapterClienteListagem(this, listaCliente);

        listView.setAdapter(adapterClienteListagem);
    }
}