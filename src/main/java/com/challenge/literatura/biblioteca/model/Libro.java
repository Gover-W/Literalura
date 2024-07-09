package com.challenge.literatura.biblioteca.model;

import com.challenge.literatura.biblioteca.datos.DatoLibro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String titulo;

    private String idioma;
    private Double descargas;

    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    public Libro(){}

    public Libro(DatoLibro l) {
        this.titulo = l.nombre();
        this.autor = l.autor().stream().map(a -> new Autor(a)).iterator().next();
        this.idioma = l.idioma().stream().iterator().next().toString();
        this.descargas = l.descargas();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        autor.setLibro(this);
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma=" + idioma +
                ", descargas=" + descargas +
                '}';
    }
}
