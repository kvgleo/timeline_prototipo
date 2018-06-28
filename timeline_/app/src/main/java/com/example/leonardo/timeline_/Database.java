package com.example.leonardo.timeline_;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "time__line.db";

    public static final String TABELA = "eventos";
    public static final String ID = "id_evento";
    public static final String TITULO = "titulo";
    public static final String PERIODO = "periodo";
    public static final String DESCR = "descr";

    public static final int VERSAO = 1;

    public  Database(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + PERIODO + " text,"
                + DESCR + " text"
                +")";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "  + TABELA);
        onCreate(db);
    }
}