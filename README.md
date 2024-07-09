# Biblioteca Spring App

Esta es una aplicación desarrollada en Spring que permite gestionar una biblioteca de libros obtenidos desde la API de Gutendex. La aplicación utiliza Jackson para mapear el JSON a clases Java y JPA para realizar diversas búsquedas en la base de datos. A continuación se detallan las características y funcionalidades de la aplicación.

## Requisitos Previos

- Java 11 o superior
- Maven
- PostgreSQL

## Instalación

1. Clonar el repositorio:
    ```bash
    git clone https://github.com/tu_usuario/biblioteca-spring-app.git
    ```
2. Navegar al directorio del proyecto:
    ```bash
    cd biblioteca-spring-app
    ```
3. Configurar la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost/nombre_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

## Uso

La aplicación expone los siguientes endpoints:

1. **Registrar un libro**
    - Método: `GET`
    - URL: `gutendex.com/books/?search=nombre_del_libro`
    - Descripción: Registra un libro en la base de datos utilizando los datos obtenidos desde la API de Gutendex.
    - Ejemplo de cuerpo de solicitud:
        ```json
        "id": 2701,
            "title": "Moby Dick; Or, The Whale",
            "authors": [
                {
                    "name": "Melville, Herman",
                    "birth_year": 1819,
                    "death_year": 1891
                }
            ],
            "translators": [],
            "subjects": [
                "Adventure stories",
            ],
            "bookshelves": [
                "Best Books Ever Listings"
            ],
            "languages": [
                "en"
            ],
            "copyright": false,
            "media_type": "Text",
            "formats": {
                "text/html": "https://www.gutenberg.org/ebooks/2701.html.images",
            },
            "download_count": 71888
        }
        ```

2. **Listar libros registrados**

    - Descripción: Lista todos los libros registrados en la base de datos.

3. **Listar autores registrados**
   
    - Descripción: Lista todos los autores registrados en la base de datos.

4. **Listar autores vivos en un determinado año**
   
    - Descripción: Lista los autores que estaban vivos en un año determinado.
    - Parámetro de consulta: `año`
   

5. **Listar libros por idioma**
  
    - Descripción: Lista los libros filtrados por idioma.
    - Parámetro de consulta: `idioma`

## Tecnologías Utilizadas

- Spring Boot
- Spring Data JPA
- Jackson
- PostgreSQL
- Gutendex API




