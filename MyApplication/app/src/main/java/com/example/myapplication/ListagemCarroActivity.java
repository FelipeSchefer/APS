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

    public void editarRegistroCarro(View view) {
        TextView id = findViewById(R.id.textViewIndex);
        TextView marca = findViewById(R.id.textViewMarca);
        TextView ano = findViewById(R.id.textViewAno);
        TextView modelo = findViewById(R.id.textViewModelo);

        Intent intent = new Intent(this, EditarCarroActivity.class);
        intent.putExtra("id" , id.getText().toString());
        intent.putExtra("marca" , marca.getText().toString());
        intent.putExtra("ano" , ano.getText().toString());
        intent.putExtra("modelo" , modelo.getText().toString());
        startActivity(intent);
    }
}
