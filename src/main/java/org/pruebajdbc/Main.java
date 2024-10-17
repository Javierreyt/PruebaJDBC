package org.pruebajdbc;

import org.pruebajdbc.dao.JdbcUtils;
import org.pruebajdbc.dao.PeliculaDAO;
import org.pruebajdbc.model.Pelicula;

public class Main {
    public static void main(String[] args) {
        /* AÑADIR PELICULA
        Pelicula movie = new Pelicula("El señor de los anillos",2001,"ciencia ficción");
        new PeliculaDAO(JdbcUtils.getConnection()).save(movie);
        */

        /* FILTRAR POR GENERO
        new PeliculaDAO(JdbcUtils.getConnection()).filterByGenre("ciencia ficción").forEach(System.out::println);
        */

        /* CONTAR PELICULAS*/
        Integer contador= new PeliculaDAO(JdbcUtils.getConnection()).countFilms();
        System.out.println(contador);

    }
}