package com.example.myapplication;

import java.io.Serializable;

public class Carro implements Serializable {

    private int id = 0;
    private String marca = "";
    private String ano = "";
    private String modelo = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if(marca.equals("")){
            throw new IllegalArgumentException("A marca não pode ser vazio");
        }else {
            this.marca = marca;
        }
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        if(ano.equals("")){
            throw new IllegalArgumentException("O ano não pode ser vazio");
        }else {
            this.ano = ano;
        }

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if(modelo.equals("")){
            throw new IllegalArgumentException("O modelo não pode ser vazia");
        }else {
            this.modelo = modelo;
        }
    }
}
