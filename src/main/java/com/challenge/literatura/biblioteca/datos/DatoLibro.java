package com.challenge.literatura.biblioteca.datos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoLibro(
        @JsonAlias("title") String nombre,
        @JsonAlias("authors") List<DatoAutor> autor,
        @JsonAlias("download_count") Double descargas,
        @JsonAlias("languages") List idioma
) {
    @Override
    public String toString() {

        return "nombre='" + nombre + '\'' +
                ", autor=" + autor +
                ", idioma=" + idioma +
                ", descargas=" + descargas +"\n";
    }
}
