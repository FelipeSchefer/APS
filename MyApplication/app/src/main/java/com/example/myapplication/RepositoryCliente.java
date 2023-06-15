package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCliente extends SQLiteOpenHelper {
    private static final String NOME_DB = "db_carro";
    private static final int VERSION = 1;

    public RepositoryCliente(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder strBuiSQL = new StringBuilder();
        strBuiSQL.append("create table cliente( ")
                .append("id INTEGER PRIMARY KEY, ")
                .append("nome TEXT NOT NULL, ")
                .append("CPF TEXT NOT NULL )");

        Log.i("cliente","sql criacao tabela cliente" + strBuiSQL.toString());

        sqLiteDatabase.execSQL(strBuiSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

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
}


