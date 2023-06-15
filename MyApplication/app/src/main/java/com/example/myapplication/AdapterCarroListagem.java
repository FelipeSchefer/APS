package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterCarroListagem extends ArrayAdapter<Carro> {

    private List<Carro> lista;

    public AdapterCarroListagem(@NonNull Context context, List<Carro> lista) {
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
            view = layoutInflater.inflate(R.layout.layout_carro_info,null);
        }
        Carro carro = lista.get(position);
        TextView marca = view.findViewById(R.id.textViewMarca);
        TextView ano = view.findViewById(R.id.textViewAno);
        TextView modelo = view.findViewById(R.id.textViewModelo);
        marca.setText(carro.getMarca());
        ano.setText(carro.getAno());
        modelo.setText(carro.getModelo());

        return view;
    }
}

