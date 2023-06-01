package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListagemUserLoginActivity extends AppCompatActivity {

    RepositoryUser repositoryUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_user);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String senha = intent.getStringExtra("senha");


        repositoryUser = new RepositoryUser(this);

        List<User> listaUser =  repositoryUser.buscarUserPeloId(email, senha);

        ListView listView = findViewById(R.id.listViewUser);
        AdapterUserListagem adapterUserListagem =
                new AdapterUserListagem(this, listaUser);

        listView.setAdapter(adapterUserListagem);
    }
}