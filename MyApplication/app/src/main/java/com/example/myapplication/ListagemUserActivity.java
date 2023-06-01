package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListagemUserActivity extends AppCompatActivity {

    RepositoryUser repositoryUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_user);

        repositoryUser = new RepositoryUser(this);

        //ArrayList<User> listaUser = (ArrayList<User>) getIntent().getSerializableExtra("lista_user");

        List<User> listaUser =  repositoryUser.listarUser();

        ListView listView = findViewById(R.id.listViewUser);
        AdapterUserListagem adapterUserListagem =
                new AdapterUserListagem(this, listaUser);

        listView.setAdapter(adapterUserListagem);
    }

}
