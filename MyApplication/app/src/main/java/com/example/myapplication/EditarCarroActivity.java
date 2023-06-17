package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditarCarroActivity extends AppCompatActivity {
    private RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carro);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String marca = intent.getStringExtra("marca");
        String ano = intent.getStringExtra("ano");
        String modelo = intent.getStringExtra("modelo");

        TextView atualizaId = findViewById(R.id.textViewEditaIndex);
        TextView marcaId = findViewById(R.id.textViewEditaMarca);
        TextView anoId = findViewById(R.id.textViewEditaAno);
        TextView modeloId = findViewById(R.id.textViewEditaModelo);

        atualizaId.setText(id);
        marcaId.setText(marca);
        anoId.setText(ano);
        modeloId.setText(modelo);
    }

    public void atualizarRegistroCarro(View view) {
        TextView id = findViewById(R.id.textViewEditaIndex);
        TextView marca = findViewById(R.id.textViewEditaMarca);
        TextView ano = findViewById(R.id.textViewEditaAno);
        TextView modelo = findViewById(R.id.textViewEditaModelo);

        String atualizaId = id.getText().toString();
        String atualizaMarca = marca.getText().toString();
        String atualizaAno = ano.getText().toString();
        String atualizaModelo = modelo.getText().toString();

        repositoryConcessionaria = new RepositoryConcessionaria(this);
        boolean editado = repositoryConcessionaria.editarCarroPeloId(atualizaId, atualizaMarca, atualizaAno, atualizaModelo);

        if(editado){
            Intent intent = new Intent(this, LoginCarroActivity.class);
            startActivity(intent);
        }

        Toast.makeText(this,"Eiditando !!" + id,Toast.LENGTH_LONG).show();
    }
}