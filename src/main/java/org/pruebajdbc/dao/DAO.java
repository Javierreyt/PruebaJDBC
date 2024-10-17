package org.pruebajdbc.dao;

import java.util.List;

/**
 * Interfaz genérica DAO (Data Access Object) que define las operaciones básicas
 * de persistencia para una entidad de tipo genérico T. Proporciona métodos
 * para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 *
 * @param <T> El tipo de la entidad sobre la que se realizarán las operaciones.
 */
public interface DAO<T> {

    /**
     * Obtiene una lista de todas las entidades del tipo T.
     *
     * @return Una lista con todas las entidades de tipo T.
     */
    public List<T> findAll();

    /**
     * Busca una entidad de tipo T por su ID.
     *
     * @param id El identificador de la entidad que se quiere buscar.
     * @return La entidad encontrada, o null si no existe.
     */
    public T findById(Integer id);

    /**
     * Guarda una nueva entidad de tipo T en la base de datos.
     *
     * @param t La entidad que se desea guardar.
     */
    public void save(T t);

    /**
     * Actualiza una entidad existente de tipo T en la base de datos.
     *
     * @param t La entidad que se desea actualizar.
     */
    public void update(T t);

    /**
     * Elimina una entidad de tipo T de la base de datos.
     *
     * @param t La entidad que se desea eliminar.
     */
    public void delete(T t);
}
