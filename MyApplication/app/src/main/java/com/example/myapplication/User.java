package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {

    private int id = 0;
    private String nome = "";
    private String email = "";
    private String senha = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals("")){
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }else {
            this.nome = nome;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.equals("")){
            throw new IllegalArgumentException("O email não pode ser vazio");
        }else {
            this.email = email;
        }

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.equals("")){
            throw new IllegalArgumentException("A senha não pode ser vazia");
        }else {
            this.senha = senha;
        }
    }
}
