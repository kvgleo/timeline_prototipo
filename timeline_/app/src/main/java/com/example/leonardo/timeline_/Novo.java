package com.example.leonardo.timeline_;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Novo extends AppCompatActivity {

    EditText etTitulo;
    EditText etPeriodo;
    EditText etDescr;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    etTitulo = findViewById(R.id.etTitulo);
                    etPeriodo = findViewById(R.id.etPeriodo);
                    etDescr = findViewById(R.id.etDescr);

                    String titulo = etTitulo.getText().toString();
                    String periodo = etPeriodo.getText().toString();
                    String descr = etDescr.getText().toString();


                    Evento evento = new Evento(titulo, periodo,descr);

                    DaoEvento daoevento = new DaoEvento(getApplicationContext());

                    String msg = daoevento.save(evento).toString();

                    if (msg.equals("0")) {
                        Toast.makeText(getApplicationContext(), getString(R.string.ins), Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), getString(R.string.erro), Toast.LENGTH_LONG).show();
                    }

                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),getString(R.string.erro2), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
