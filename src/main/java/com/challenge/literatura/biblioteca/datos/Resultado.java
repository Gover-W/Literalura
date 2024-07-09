package com.challenge.literatura.biblioteca.datos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultado(
        @JsonAlias("count") Integer numeroLibros,
        @JsonAlias("results") List<DatoLibro> libro
        )
{
        @Override
        public String toString() {
                return
                        "libro=" + libro;
        }
}
