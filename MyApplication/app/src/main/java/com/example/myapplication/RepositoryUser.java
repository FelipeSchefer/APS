package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryUser extends SQLiteOpenHelper {
    private static final String NOME_DB = "db_user";
    private static final int VERSION = 1;

    public RepositoryUser(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder strBuiSQL = new StringBuilder();
        strBuiSQL.append("create table user( ")
                 .append("id INTEGER PRIMARY KEY, ")
                 .append("nome TEXT NOT NULL, ")
                 .append("email TEXT NOT NULL, ")
                 .append("senha TEXT NOT NULL )");

        Log.i("user","sql criacao tabela user" + strBuiSQL.toString());

        sqLiteDatabase.execSQL(strBuiSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void adicionarUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",user.getNome());
        contentValues.put("email",user.getEmail());
        contentValues.put("senha",user.getSenha());
        getWritableDatabase().insert("user",null,contentValues);
    }

    public List<User> listarUser() {
        List<User> listaUser = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user", null);

        while (cursor.moveToNext()) {
            int idColInd = cursor.getColumnIndex("id");
            int id = cursor.getInt(idColInd);

            int nomeColInd = cursor.getColumnIndex("nome");
            String nome = cursor.getString(nomeColInd);

            int emailColInd = cursor.getColumnIndex("email");
            String email = cursor.getString(emailColInd);

            int senhaColInd = cursor.getColumnIndex("senha");
            String senha = cursor.getString(senhaColInd);

            User user = new User();
            user.setId(id);
            user.setNome(nome);
            user.setEmail(email);
            user.setSenha(senha);
            listaUser.add(user);
        }

        cursor.close();
        return listaUser;
    }


    public List<User> buscarUserPeloId(String emailLogin, String senhaLogin){
        List<User> listaUser = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = '" + emailLogin + "' AND senha = '" + senhaLogin + "'",null);
        cursor.moveToFirst();

        int idColInd = cursor.getColumnIndex("id");
        int id = cursor.getInt(idColInd);

        int nomeColInd = cursor.getColumnIndex("nome");
        String nome = cursor.getString(nomeColInd);

        int emailColInd = cursor.getColumnIndex("email");
        String email = cursor.getString(emailColInd);

        int senhaColInd = cursor.getColumnIndex("senha");
        String senha = cursor.getString(senhaColInd);

        for(int i=0; i < cursor.getCount(); i++){
            User user = new User();
            user.setId(id);
            user.setNome(nome);
            user.setEmail(email);
            user.setSenha(senha);
            listaUser.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return listaUser;
    }
}


