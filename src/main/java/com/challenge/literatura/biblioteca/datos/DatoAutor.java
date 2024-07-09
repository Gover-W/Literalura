package com.challenge.literatura.biblioteca.datos;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatoAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year")  Integer fechaDeNacimiento,
        @JsonAlias("death_year")  Integer fechaDeFallecimiento
) {
    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", fechaDeFallecimiento=" + fechaDeFallecimiento;
    }
}
