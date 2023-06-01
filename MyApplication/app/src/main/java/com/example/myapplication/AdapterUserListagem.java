package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AdapterUserListagem extends ArrayAdapter<User> {

    private List<User> lista;

    public AdapterUserListagem(@NonNull Context context, List<User> lista) {
        super(context, 0, lista);
        this.lista = lista;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            Context ctx = getContext();
            LayoutInflater layoutInflater =
                    (LayoutInflater)ctx.
                            getSystemService(Context.
                                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_pessoa_info,null);
        }
        User user = lista.get(position);
        TextView nome = view.findViewById(R.id.textViewNome);
        TextView email = view.findViewById(R.id.textViewEmail);
        TextView senha = view.findViewById(R.id.textViewSenha);
        nome.setText(user.getNome());
        email.setText(user.getEmail());
        senha.setText(user.getSenha());

        return view;
    }
}

