package com.challenge.literatura.biblioteca.repository;

import com.challenge.literatura.biblioteca.model.Autor;
import com.challenge.literatura.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findAll();

    List<Libro> findByIdiomaIs(String idioma);

    @Query("SELECT a FROM Libro l JOIN l.autor a")
    List<Autor> mostrarAutores();

    @Query("SELECT a FROM Libro l JOIN l.autor a WHERE a.añoDeNacimiento < ?1 AND a.añoDeFallecimiento > ?1")
    List<Autor> verAutoresPorAño(Integer año);
}
