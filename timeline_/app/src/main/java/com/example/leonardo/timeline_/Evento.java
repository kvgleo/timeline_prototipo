package com.example.leonardo.timeline_;

import java.io.Serializable;

public class Evento {
    private int id;
    private String titulo;
    private String periodo;
    private String descr;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getDescr() {
        return descr;
    }

    public Evento(int id, String titulo, String periodo, String descr) {
        this.id = id;
        this.titulo = titulo;
        this.periodo = periodo;
        this.descr = descr;
    }

    public Evento(String titulo, String periodo, String descr) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.descr = descr;
    }
}
