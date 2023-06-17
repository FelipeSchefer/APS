package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListagemCarroLoginActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        Intent intent = getIntent();
        String modelo = intent.getStringExtra("modelo");
        String ano = intent.getStringExtra("ano");

        repositoryConcessionaria = new RepositoryConcessionaria(this);

        List<Carro> listaCarro =  repositoryConcessionaria.buscarCarroPeloModAno(modelo, ano);
        if(listaCarro.isEmpty()){
            Toast.makeText(this,"Veículo não encontrado",Toast.LENGTH_LONG).show();
        }else{
            ListView listView = findViewById(R.id.listViewCarro);
            AdapterCarroListagem adapterCarroListagem =
                    new AdapterCarroListagem(this, listaCarro);

            listView.setAdapter(adapterCarroListagem);
        }
    }
}