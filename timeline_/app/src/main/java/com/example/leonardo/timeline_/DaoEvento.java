package com.example.leonardo.timeline_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DaoEvento {
    private SQLiteDatabase db;
    private Database banco;


    public DaoEvento(Context context) {
        banco = new Database(context);
    }

    public String save(Evento evento) {
        String msg="";

        ContentValues values;
        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(Database.TITULO,evento.getTitulo());
        values.put(Database.PERIODO,evento.getPeriodo());
        values.put(Database.DESCR,evento.getDescr());


        long result = db.insert(Database.TABELA,null,values);
        if(result==-1){
            msg="1";
        }else{
            msg= "0";
        }

        return msg;
    }

    public String edit(Evento evento) {
        String msg="";

        ContentValues values;
        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(Database.ID,evento.getId());
        values.put(Database.TITULO,evento.getTitulo());
        values.put(Database.PERIODO,evento.getPeriodo());
        values.put(Database.DESCR,evento.getDescr());

        long result = db.update(Database.TABELA,values,Database.ID+"="+evento.getId(),null);
        if(result==-1){
            msg="1";
        }else{
            msg= "0";
        }
        return msg;
    }

    public ArrayList<Evento> getAll(){
        ArrayList<Evento> lista = new ArrayList<>();

        Cursor cursor;
        String[] campos = {banco.ID,banco.TITULO,banco.PERIODO,banco.DESCR};

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos,null,null,null,null,null,null);

        while (cursor.moveToNext()) {
            int id= cursor.getInt(0);
            String titulo = cursor.getString(1);
            String periodo = cursor.getString(2);
            String descr = cursor.getString(3);

            Evento evento = new Evento(id,titulo,periodo,descr);
            lista.add(evento);
        }
        db.close();
        return lista;
    }

    public Evento getById(Evento evento){

        String[] colunas = {"id_evento","titulo","periodo","descr"};
        String sql = "SELECT * FROM eventos WHERE id_evento="+evento.getId()+";";
        Cursor cursor;
        cursor = db.query("tabelas",colunas,null,null,null,null,"DESC","1");

        int id = cursor.getInt(0);
        String titulo = cursor.getString(1);
        String periodo = cursor.getString(2);
        String descr = cursor.getString(3);


        Evento consulta = new Evento(id,titulo,periodo,descr);

        return consulta;
    }

    public String remove(Evento evento){
        String where = banco.ID+"="+evento.getId();
        db = banco.getWritableDatabase();
        db.delete(Database.TABELA,where,null);
        db.close();
        return evento.getTitulo();
    }
}
