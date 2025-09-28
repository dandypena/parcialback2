package com.example.parcial2.dto;

public class CineDTO {

    private Long id;
    private String nombre;
    private String nit;
    private String ciudad; // tomado desde DetalleCine

    public CineDTO() {
    }

    public CineDTO(Long id, String nombre, String nit, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.ciudad = ciudad;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
