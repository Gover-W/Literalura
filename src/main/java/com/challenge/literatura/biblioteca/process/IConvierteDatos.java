package com.challenge.literatura.biblioteca.process;

public interface IConvierteDatos {
    <T> T convierteDatos(String json, Class<T> clase);
}
