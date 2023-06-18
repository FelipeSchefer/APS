package com.example.myapplication;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RepositoryConcessionaria extends SQLiteOpenHelper {
    private static final String NOME_DB = "db_concessionaria";
    private static final int VERSION = 1;

    public RepositoryConcessionaria(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder strBuiSQL = new StringBuilder();
        strBuiSQL.append("create table carro( ")
                 .append("id INTEGER PRIMARY KEY, ")
                 .append("marca TEXT NOT NULL, ")
                 .append("ano TEXT NOT NULL, ")
                 .append("modelo TEXT NOT NULL )");

        Log.i("carro","sql criacao tabela carro" + strBuiSQL.toString());

        sqLiteDatabase.execSQL(strBuiSQL.toString());

        StringBuilder strBuiSQL1 = new StringBuilder();
        strBuiSQL1.append("create table cliente( ")
                .append("id INTEGER PRIMARY KEY, ")
                .append("nome TEXT NOT NULL, ")
                .append("CPF TEXT NOT NULL )");

        Log.i("cliente","sql criacao tabela cliente" + strBuiSQL1.toString());

        sqLiteDatabase.execSQL(strBuiSQL1.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //--------------------- REPOSITORY CARRO
    public void adicionarCarro(Carro carro){
        ContentValues contentValues = new ContentValues();
        contentValues.put("marca", carro.getMarca());
        contentValues.put("ano", carro.getAno());
        contentValues.put("modelo", carro.getModelo());
        getWritableDatabase().insert("carro",null,contentValues);
    }

    public List<Carro> listarCarro() {
        List<Carro> listaCarro = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM carro", null);

        while (cursor.moveToNext()) {
            int idColInd = cursor.getColumnIndex("id");
            int id = cursor.getInt(idColInd);

            int marcaColInd = cursor.getColumnIndex("marca");
            String marca = cursor.getString(marcaColInd);

            int anoColInd = cursor.getColumnIndex("ano");
            String ano = cursor.getString(anoColInd);

            int modeloColInd = cursor.getColumnIndex("modelo");
            String modelo = cursor.getString(modeloColInd);

            Carro carro = new Carro();
            carro.setId(id);
            carro.setMarca(marca);
            carro.setAno(ano);
            carro.setModelo(modelo);
            listaCarro.add(carro);
        }

        cursor.close();
        return listaCarro;
    }


    public List<Carro> buscarCarroPeloModAno(String modeloBusca, String anoBusca){
        List<Carro> listaCarro = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM carro WHERE modelo = '" + modeloBusca + "' AND ano = '" + anoBusca + "'",null);
        cursor.moveToFirst();
        if(cursor.getCount() == 0){
            return new ArrayList<>();
        }
        int idColInd = cursor.getColumnIndex("id");
        int id = cursor.getInt(idColInd);

        int marcaColInd = cursor.getColumnIndex("marca");
        String marca = cursor.getString(marcaColInd);

        int anoColInd = cursor.getColumnIndex("ano");
        String ano = cursor.getString(anoColInd);

        int modeloColInd = cursor.getColumnIndex("modelo");
        String modelo = cursor.getString(modeloColInd);

        for(int i=0; i < cursor.getCount(); i++){
            Carro carro = new Carro();
            carro.setId(id);
            carro.setMarca(marca);
            carro.setAno(ano);
            carro.setModelo(modelo);
            listaCarro.add(carro);
            cursor.moveToNext();
        }
        cursor.close();
        return listaCarro;
    }

    public boolean editarCarroPeloId(String id, String marca, String ano, String modelo){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("marca", marca);
        values.put("ano", ano);
        values.put("modelo", modelo);

        String whereClause = "id = ?";
        String[] whereArgs = { String.valueOf(id) };

        db.update("carro", values, whereClause, whereArgs);

        db.close();

        return true;
    }

    // ----------------------------------- REPOSITORIO CLIENTE

    public void adicionarCliente(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", cliente.getNome());
        contentValues.put("CPF", cliente.getCPF());
        getWritableDatabase().insert("cliente",null,contentValues);
    }

    public List<Cliente> listarCliente() {
        List<Cliente> listaCliente = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente", null);

        while (cursor.moveToNext()) {
            int idColInd = cursor.getColumnIndex("id");
            int id = cursor.getInt(idColInd);

            int nomeColInd = cursor.getColumnIndex("nome");
            String nome = cursor.getString(nomeColInd);

            int cpfColInd = cursor.getColumnIndex("CPF");
            String CPF = cursor.getString(cpfColInd);

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCPF(CPF);
            listaCliente.add(cliente);
        }

        cursor.close();
        return listaCliente;
    }

    public List<Cliente> buscarClientePeloCPF(String cpfBusca){
        List<Cliente> listaCliente = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente WHERE CPF = '" + cpfBusca + "'",null);
        cursor.moveToFirst();

        if(cursor.getCount() == 0){
            return new ArrayList<>();
        }

        int idColInd = cursor.getColumnIndex("id");
        int id = cursor.getInt(idColInd);

        int nomeColInd = cursor.getColumnIndex("nome");
        String nome = cursor.getString(nomeColInd);

        int cpfColInd = cursor.getColumnIndex("CPF");
        String CPF = cursor.getString(cpfColInd);

        for(int i=0; i < cursor.getCount(); i++){
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCPF(CPF);
            listaCliente.add(cliente);
            cursor.moveToNext();
        }
        cursor.close();
        return listaCliente;
    }

    public boolean editarClientePeloId(String id, String nome, String CPF){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("nome", nome);
        values.put("CPF", CPF);

        String whereClause = "id = ?";
        String[] whereArgs = { String.valueOf(id) };

        db.update("cliente", values, whereClause, whereArgs);

        db.close();

        return true;
    }
}


