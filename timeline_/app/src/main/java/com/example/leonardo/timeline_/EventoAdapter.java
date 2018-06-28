package com.example.leonardo.timeline_;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventoAdapter extends ArrayAdapter<Evento> {

    public EventoAdapter(@NonNull Context context, @NonNull List<Evento> objects){
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        }
        Evento atual = getItem(position);

        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvTitulo = view.findViewById(R.id.tvTitulo);
        TextView tvPeriodo = view.findViewById(R.id.tvPeriodo);
        TextView tvDescr = view.findViewById(R.id.tvDescr);

        tvId.setText(String.valueOf(atual.getId()));
        tvTitulo.setText(atual.getTitulo());
        tvPeriodo.setText(atual.getPeriodo());
        tvDescr.setText(atual.getDescr());

        return view;
    }
}
