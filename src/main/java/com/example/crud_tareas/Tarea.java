package com.example.crud_tareas;

import java.time.LocalDate;

public class Tarea {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private LocalDate fechaLimite;

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public Tarea(int id, String titulo, String descripcion, String prioridad, LocalDate fechaLimite) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
    }
}
