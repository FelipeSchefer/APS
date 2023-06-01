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

    public void listarUser(View view){

        Intent intent = new Intent(this,ListagemUserActivity.class);

        startActivity(intent);
    }

    public void logar(View view) {
        EditText login = findViewById(R.id.editTextLogin);
        EditText senha = findViewById(R.id.editTextSenha);


        if(login.getText().toString().equals("")){
            Toast.makeText(this,"Seu login está incorreto",Toast.LENGTH_LONG).show();
            return;
        }
        if (senha.getText().toString().equals("")) {
            Toast.makeText(this,"Sua senha está incorreta",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, ListagemUserLoginActivity.class);

        intent.putExtra("email" , login.getText().toString());
        intent.putExtra("senha", senha.getText().toString());

        startActivity(intent);

        login.setText("");
        senha.setText("");
    }
    public void abrirCadastroUsuario(View view) {
        Intent intent = new Intent(this, CadastraUsuarioActivity.class);
        startActivity(intent);
    }


}