package com.challenge.literatura.biblioteca.model;

import com.challenge.literatura.biblioteca.datos.DatoAutor;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private Integer añoDeNacimiento;
    private Integer añoDeFallecimiento;
    @OneToOne
    private Libro libro;


    public Autor(){}

    public Autor(DatoAutor a) {
        this.nombre = a.nombre();
        this.añoDeNacimiento = a.fechaDeNacimiento();
        this.añoDeFallecimiento = a.fechaDeFallecimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAñoDeNacimiento() {
        return añoDeNacimiento;
    }

    public void setAñoDeNacimiento(Integer añoDeNacimiento) {
        this.añoDeNacimiento = añoDeNacimiento;
    }

    public Integer getAñoDeFallecimiento() {
        return añoDeFallecimiento;
    }

    public void setAñoDeFallecimiento(Integer añoDeFallecimiento) {
        this.añoDeFallecimiento = añoDeFallecimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", añoDeNacimiento=" + añoDeNacimiento +
                ", añoDeFallecimiento=" + añoDeFallecimiento;
    }
}
