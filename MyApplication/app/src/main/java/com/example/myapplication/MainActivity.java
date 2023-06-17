package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirEstoque(View view) {
        Intent intent = new Intent(this, LoginCarroActivity.class);
        startActivity(intent);
    }

    public void cadastrarCliente(View view) {
        Intent intent = new Intent(this,LoginClienteActivity.class);
        startActivity(intent);
    }
}