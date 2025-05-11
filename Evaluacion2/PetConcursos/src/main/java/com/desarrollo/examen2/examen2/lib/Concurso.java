package com.desarrollo.examen2.examen2.lib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "concurso")
public class Concurso 
{
    @Id
    @Positive 
    @NotNull
    private int id;
    private int idMascota;
    private int idPropietario;
    private int precio;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String ubicacion;
    private String estado;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdMascota() {
        return idMascota;
    }
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPropietario() {
        return idPropietario;   
    }
    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
