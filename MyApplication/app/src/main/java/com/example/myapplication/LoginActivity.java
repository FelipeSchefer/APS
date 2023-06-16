package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void listarCarro(View view){
        Intent intent = new Intent(this, ListagemCarroActivity.class);
        startActivity(intent);
    }

    public void buscar(View view) {
        EditText modelo = findViewById(R.id.editTextModelo);
        EditText ano = findViewById(R.id.editTextAno);

        if(modelo.getText().toString().equals("")){
            Toast.makeText(this,"Seu modelo está incorreto",Toast.LENGTH_LONG).show();
            return;
        }
        if (ano.getText().toString().equals("")) {
            Toast.makeText(this,"Sua ano está incorreta",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, ListagemCarroLoginActivity.class);

        intent.putExtra("modelo" , modelo.getText().toString());
        intent.putExtra("ano", ano.getText().toString());

        startActivity(intent);

        modelo.setText("");
        ano.setText("");
    }
    public void abrirCadastroCarro(View view) {
        Intent intent = new Intent(this, CadastraCarroActivity.class);
        startActivity(intent);
    }
}