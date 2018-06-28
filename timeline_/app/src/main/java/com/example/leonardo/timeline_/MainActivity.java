package com.example.leonardo.timeline_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Button btnAdd;
    EventoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.timeline);
        btnAdd = findViewById(R.id.btnAdd);


        refresh();
        list = findViewById(R.id.timeline);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) { // EDITA WORKS
                Evento evento = (Evento) parent.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(), Editar.class);
                intent.putExtra("id_evento",evento.getId());
                startActivity(intent);
                refresh();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // DELETA
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Evento evento = (Evento) parent.getItemAtPosition(i);

                DaoEvento daoevento = new DaoEvento(getApplicationContext());
                String msg = daoevento.remove(evento);
                refresh();
                Toast.makeText(getApplicationContext(),msg+ getString(R.string.rmv), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Novo.class);
                startActivity(intent);
            }
        });


    }

    private void refresh(){
        DaoEvento daoevento = new DaoEvento(getApplicationContext());
        ArrayList<Evento> lista = daoevento.getAll();
        adapter = new EventoAdapter(getApplicationContext(),lista);
        ListView list =  findViewById(R.id.timeline);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    protected void onRestart(){
        final DaoEvento daoevento = new DaoEvento(getApplicationContext());
        refresh();
        super.onRestart();
    }
}
