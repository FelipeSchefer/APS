package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListagemCarroActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        repositoryConcessionaria = new RepositoryConcessionaria(this);

        List<Carro> listaCarro =  repositoryConcessionaria.listarCarro();

        ListView listView = findViewById(R.id.listViewCarro);

        AdapterCarroListagem adapterCarroListagem = new AdapterCarroListagem(this, listaCarro);

        listView.setAdapter(adapterCarroListagem);
    }
}
