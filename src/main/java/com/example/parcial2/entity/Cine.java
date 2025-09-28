package com.example.parcial2.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cines")
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nit;

    @OneToOne(mappedBy = "cine", cascade = CascadeType.ALL)
    private DetalleCine detalle;

    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
    private List<Sala> salas;

    // Constructor vacío requerido por JPA
    public Cine() {
    }

    // Constructor útil
    public Cine(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public Cine(Object o, String cineNov, String s, int i) {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public DetalleCine getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleCine detalle) {
        this.detalle = detalle;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public String getDireccion() {
        return "";
    }

    public Object getCiudad() {
        return null;
    }

    public void setCiudad(Object ciudad) {
    }

    public void setDireccion(String direccion) {
    }
}
