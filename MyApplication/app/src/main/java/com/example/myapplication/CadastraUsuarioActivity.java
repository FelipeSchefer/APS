package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastraUsuarioActivity extends AppCompatActivity {

    RepositoryUser repositoryUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_usuario);

        repositoryUser = new RepositoryUser(this);
    }

    public void cadastrarUsuario(View view) {
        EditText nome = findViewById(R.id.userNomeId);
        EditText email = findViewById(R.id.userEmailId);
        EditText senha = findViewById(R.id.userSenhaId);

        if(nome.getText().toString().equals("")){
            Toast.makeText(this,"O nome não poder ser vazio", Toast.LENGTH_LONG).show();
        } else if (email.getText().toString().equals("")) {
            Toast.makeText(this,"O emailo não poder ser vazio", Toast.LENGTH_LONG).show();
        } else if (senha.getText().toString().equals("")) {
            Toast.makeText(this,"A senha não poder ser vazia", Toast.LENGTH_LONG).show();
        } else {
            User user = new User();
            user.setNome(nome.getText().toString());
            user.setEmail(email.getText().toString());
            user.setSenha(senha.getText().toString());

            Toast.makeText(this, user.getNome() + " bem vindo você acabou de cadastrar-se", Toast.LENGTH_LONG).show();

            repositoryUser.adicionarUser(user);

            finish();
        }
    }
}