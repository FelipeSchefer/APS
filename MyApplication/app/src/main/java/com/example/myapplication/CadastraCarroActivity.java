package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraCarroActivity extends AppCompatActivity {

    RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_carro);

        repositoryConcessionaria = new RepositoryConcessionaria(this);
    }

    public void cadastrarCarro(View view) {
        EditText marca = findViewById(R.id.userMarcaId);
        EditText ano = findViewById(R.id.userAnoId);
        EditText modelo = findViewById(R.id.userModeloId);

        if(marca.getText().toString().equals("")){
            Toast.makeText(this,"A marca não poder ser vazio", Toast.LENGTH_LONG).show();
        } else if (ano.getText().toString().equals("")) {
            Toast.makeText(this,"O ano não poder ser vazio", Toast.LENGTH_LONG).show();
        } else if (modelo.getText().toString().equals("")) {
            Toast.makeText(this,"O modelo não poder ser vazia", Toast.LENGTH_LONG).show();
        } else {
            Carro carro = new Carro();
            carro.setMarca(marca.getText().toString());
            carro.setAno(ano.getText().toString());
            carro.setModelo(modelo.getText().toString());

            Toast.makeText(this, carro.getMarca() + " Cadastro com sucesso", Toast.LENGTH_LONG).show();

            repositoryConcessionaria.adicionarCarro(carro);

            finish();
        }
    }
}