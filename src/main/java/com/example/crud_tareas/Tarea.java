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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Tarea(int id, String titulo, String descripcion, String prioridad, LocalDate fechaLimite) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
    }
}
