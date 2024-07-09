package com.challenge.literatura.biblioteca.principal;

import com.challenge.literatura.biblioteca.datos.Resultado;
import com.challenge.literatura.biblioteca.model.Autor;
import com.challenge.literatura.biblioteca.model.Libro;
import com.challenge.literatura.biblioteca.process.ConsumoAPI;
import com.challenge.literatura.biblioteca.process.Conversor;
import com.challenge.literatura.biblioteca.repository.LibroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Principal {
    final String URL_BASE = "https://gutendex.com/books/";

    ConsumoAPI consumoAPI = new ConsumoAPI();
    Conversor conversor = new Conversor();
    LibroRepository repositorio;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {

        var option = -1;
        var menu = """
                                
                Ingrese la opcion a travez de su numero:
                                
                1- registrar un libro
                2- listar libros registrados
                3- listar autores registrados
                4- listar autores vivos en un determinado año
                5- listar libros por idioma
                                
                0- salir
                """;

        while (option != 0) {
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registrarUnLibroPorNombre();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    mostrarAutoresPorAño();
                    break;
                case 5:
                    buscarPorIdioma();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    private void registrarUnLibroPorNombre() {
        System.out.println("Digite el titulo del libro que desea registrar:");
        var titulo = sc.nextLine();

        var json = consumoAPI.conection(URL_BASE + "?search=" + titulo.replace(" ", "%20"));

        var libro = conversor.convierteDatos(json, Resultado.class);

        if (libro.numeroLibros().equals(0)) {
            System.out.println("Libro no encontrado");
        } else {
            Libro libroEncontrado = libro.libro().stream().map(l -> new Libro(l)).iterator().next();

            libroEncontrado.setAutor(libroEncontrado.getAutor());
            repositorio.save(libroEncontrado);
            System.out.println("Libro guardado");
        }
    }

    private void listarLibros() {
        List<Libro> libros = new ArrayList<>();
        libros = repositorio.findAll();

        if (libros.size() == 0) {
            System.out.println("No hay libros registrados");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutores() {
        List<Autor> autors = new ArrayList<>();
        autors = repositorio.mostrarAutores();

        if (autors.size() == 0) {
            System.out.println("No hay autores que mostrar");
        } else {
            autors.forEach(System.out::println);
        }
    }

    private void mostrarAutoresPorAño() {
        Integer añoDeBusqueda;
        System.out.println("Digite el año para buscar los autores");
        añoDeBusqueda = sc.nextInt();

        List<Autor> autoresPorAño = new ArrayList<>();
        autoresPorAño = repositorio.verAutoresPorAño(añoDeBusqueda);
        if (autoresPorAño.size()==0){
            System.out.println("No hay autores registrados en ese año");
        }else{
            autoresPorAño.forEach(System.out::println);
        }

    }

    private void buscarPorIdioma() {
        String idioma;
        var mensaje = """
                Que idioma desea seleccionar?
                1- EN - Ingles
                2- ES - Español              
                """;
        System.out.println(mensaje);
        idioma = sc.nextLine();

        List<Libro> librosPorIdioma = new ArrayList<>();

        if (idioma.equals("1")) {

            librosPorIdioma = repositorio.findByIdiomaIs("en");
            librosPorIdioma.forEach(System.out::println);

        } else if (idioma.equals("2")) {

            librosPorIdioma = repositorio.findByIdiomaIs("es");
            librosPorIdioma.forEach(System.out::println);

        } else {
            System.out.println("Selecciona un idioma valido");
        }
    }
}