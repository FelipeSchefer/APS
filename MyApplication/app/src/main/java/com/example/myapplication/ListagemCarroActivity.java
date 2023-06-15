package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListagemCarroActivity extends AppCompatActivity {

    RepositoryCarro repositoryCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        repositoryCarro = new RepositoryCarro(this);

        List<Carro> listaCarro =  repositoryCarro.listarCarro();

        ListView listView = findViewById(R.id.listViewUser);
        AdapterCarroListagem adapterCarroListagem =
                new AdapterCarroListagem(this, listaCarro);

        listView.setAdapter(adapterCarroListagem);
    }

}
