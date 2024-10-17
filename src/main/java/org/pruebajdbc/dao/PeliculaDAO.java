package org.pruebajdbc.dao;

import org.pruebajdbc.model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para la entidad Pelicula, que proporciona métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la tabla "pelicula"
 * en una base de datos. Implementa la interfaz genérica DAO.
 */
public class PeliculaDAO implements DAO<Pelicula> {

    /** Conexión a la base de datos */
    private Connection connection;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param connection La conexión a la base de datos que se utilizará en las operaciones.
     */
    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Obtiene todas las películas de la tabla "pelicula".
     *
     * @return Lista de todas las películas. (Actualmente no implementado, devuelve una lista vacía)
     */
    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    /**
     * Busca una película en la tabla "pelicula" por su ID.
     *
     * @param id El ID de la película que se desea buscar.
     * @return La película encontrada o null si no se encuentra. (No implementado)
     */
    @Override
    public Pelicula findById(Integer id) {
        return null;
    }

    /**
     * Guarda una nueva película en la tabla "pelicula".
     *
     * @param pelicula La película que se desea guardar.
     * @throws RuntimeException Si ocurre un error SQL durante la inserción.
     */
    @Override
    public void save(Pelicula pelicula) {
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO pelicula (titulo, año, genero) VALUES (?,?,?)")){
            ps.setString(1,pelicula.getTitulo());
            ps.setInt(2,pelicula.getAño());
            ps.setString(3,pelicula.getGenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza una película existente en la tabla "pelicula".
     *
     * @param pelicula La película con los datos actualizados. (No implementado)
     */
    @Override
    public void update(Pelicula pelicula) {
        // No implementado
    }

    /**
     * Elimina una película de la tabla "pelicula".
     *
     * @param pelicula La película que se desea eliminar. (No implementado)
     */
    @Override
    public void delete(Pelicula pelicula) {
        // No implementado
    }

    /**
     * Cuenta el número total de películas en la tabla "pelicula".
     *
     * @return El número total de películas.
     * @throws RuntimeException Si ocurre un error SQL durante la consulta.
     */
    public Integer countFilms(){
        var contador = 0;
        try(Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM pelicula");
            if(resultSet.next()) contador=resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }

    /**
     * Filtra las películas por género en la tabla "pelicula".
     *
     * @param genre El género por el cual se filtrarán las películas.
     * @return Lista de películas que coinciden con el género especificado.
     */
    public List<Pelicula> filterByGenre(String genre){
        var output = new ArrayList<Pelicula>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM pelicula WHERE genero = ?")) {
            ps.setString(1, genre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                output.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("año"),
                        rs.getString("genero")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
}
