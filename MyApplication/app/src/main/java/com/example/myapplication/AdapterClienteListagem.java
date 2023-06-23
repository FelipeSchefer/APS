package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterClienteListagem extends ArrayAdapter<Cliente> {

    private List<Cliente> lista;

    public AdapterClienteListagem(@NonNull Context context, List<Cliente> lista) {
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
            view = layoutInflater.inflate(R.layout.layout_cliente_info,null);
        }
        Cliente cliente = lista.get(position);
        TextView id = view.findViewById(R.id.textViewClienteIndex);
        TextView nome = view.findViewById(R.id.textViewClienteNome);
        TextView CPF = view.findViewById(R.id.textViewClienteCpf);
        Button editar = view.findViewById(R.id.btnLayoutClienteId);
        id.setText(""+cliente.getId());
        nome.setText(cliente.getNome());
        CPF.setText(cliente.getCPF());
        editar.hasOnClickListeners();

        editar.setOnClickListener((View v) ->{
            editarRegistroCliente(v, cliente);
        });

        return view;
    }

    public void editarRegistroCliente(View view, Cliente cliente ) {
        Intent intent = new Intent(view.getContext(), EditarClienteActivity.class);

        intent.putExtra("id" , cliente.getId());
        intent.putExtra("Nome" , cliente.getNome());
        intent.putExtra("CPF" , cliente.getCPF());
        view.getContext().startActivity(intent);
    }
}

