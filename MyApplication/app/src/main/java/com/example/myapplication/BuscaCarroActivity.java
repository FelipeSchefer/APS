package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsic;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class BuscaCarroActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        Intent intent = getIntent();
        String modelo = (String) intent.getSerializableExtra("modelo");
        String ano = (String) intent.getSerializableExtra("ano");

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