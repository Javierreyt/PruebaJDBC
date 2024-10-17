package org.pruebajdbc.model;

import lombok.*;

/**
 * Clase que representa una entidad Pelicula, con los atributos id, titulo, año y genero.
 * Utiliza Lombok para generar los métodos getter, setter, y otros métodos útiles como
 * toString(), equals() y hashCode().
 */
@Data
@AllArgsConstructor
public class Pelicula {

    /**
     * Identificador único de la película.
     */
    private Integer id;

    /**
     * Título de la película.
     */
    private String titulo;

    /**
     * Año de lanzamiento de la película.
     */
    private Integer año;

    /**
     * Género de la película (por ejemplo, acción, comedia, drama).
     */
    private String genero;

    /**
     * Constructor sin el atributo id, para crear una película nueva antes de asignarle un id.
     *
     * @param titulo El título de la película.
     * @param año El año de lanzamiento de la película.
     * @param genero El género de la película.
     */
    public Pelicula(String titulo, Integer año, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
    }
}
