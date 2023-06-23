package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        TextView id = view.findViewById(R.id.textViewIndex);
        TextView marca = view.findViewById(R.id.textViewMarca);
        TextView ano = view.findViewById(R.id.textViewAno);
        TextView modelo = view.findViewById(R.id.textViewModelo);
        Button editar = view.findViewById(R.id.btnLayoutCarroId);

        id.setText(""+carro.getId());
        marca.setText(carro.getMarca());
        ano.setText(carro.getAno());
        modelo.setText(carro.getModelo());


        editar.setOnClickListener((View v) ->{
            editarRegistroCarro(v,carro);
        });


        return view;
    }

    public void editarRegistroCarro(View view,Carro carro) {
        Intent intent = new Intent(view.getContext(), EditarCarroActivity.class);

        intent.putExtra("id" , carro.getId());
        intent.putExtra("marca" , carro.getMarca());
        intent.putExtra("ano" , carro.getAno());
        intent.putExtra("modelo" , carro.getModelo());
        view.getContext().startActivity(intent);
    }
}

