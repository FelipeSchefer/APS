package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditarClienteActivity extends AppCompatActivity {

    private RepositoryConcessionaria repositoryConcessionaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String nome = intent.getStringExtra("nome");
        String CPF = intent.getStringExtra("CPF");

        TextView atualizaId = findViewById(R.id.textViewEditaClienteIndex);
        TextView atualizaNomeId = findViewById(R.id.textViewEditaClienteNome);
        TextView atualizaCpfId = findViewById(R.id.textViewEditaClienteCpf);

        atualizaId.setText(id);
        atualizaNomeId.setText(nome);
        atualizaCpfId.setText(CPF);
    }

    public void atualizarRegistroCliente(View view) {
        TextView id = findViewById(R.id.textViewEditaClienteIndex);
        TextView nome = findViewById(R.id.textViewEditaClienteNome);
        TextView CPF = findViewById(R.id.textViewEditaClienteCpf);

        String atualizaId = id.getText().toString();
        String atualizaNome = nome.getText().toString();
        String atualizaCPF = CPF.getText().toString();

        repositoryConcessionaria = new RepositoryConcessionaria(this);
        boolean editado = repositoryConcessionaria.editarClientePeloId(atualizaId, atualizaNome, atualizaCPF);

        if(editado){
            Intent intent = new Intent(this, LoginClienteActivity.class);
            startActivity(intent);
        }
    }
}