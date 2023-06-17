package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
        AdapterCarroListagem adapterCarroListagem =
                new AdapterCarroListagem(this, listaCarro);

        listView.setAdapter(adapterCarroListagem);
    }

}
