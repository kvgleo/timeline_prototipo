package com.example.leonardo.timeline_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    EditText etTitulo;
    EditText etPeriodo;
    EditText etDescr;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        etTitulo = findViewById(R.id.etTitulo);
        etPeriodo = findViewById(R.id.etPeriodo);
        etDescr = findViewById(R.id.etDescr);

        btnSalvar = findViewById(R.id.btnSalvar);

        final int id_evento = (Integer) getIntent().getSerializableExtra("id_evento");

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    String titulo = etTitulo.getText().toString();
                    String periodo = etPeriodo.getText().toString();
                    String descr = etDescr.getText().toString();


                    Evento evento = new Evento(id_evento,titulo, periodo,descr);

                    DaoEvento daoevento = new DaoEvento(getApplicationContext());

                    String msg = daoevento.edit(evento).toString();

                    if (msg.equals("0")) {
                        Toast.makeText(getApplicationContext(), getString(R.string.suc), Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), getString(R.string.erro), Toast.LENGTH_LONG).show();
                    }

                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),getString(R.string.erro2), Toast.LENGTH_LONG).show();
                    System.out.println(e);
                }
            }
        });

    }
}
