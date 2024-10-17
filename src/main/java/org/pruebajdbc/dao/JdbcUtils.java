package org.pruebajdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para gestionar la conexión con la base de datos mediante JDBC.
 * Proporciona una conexión única (singleton) a la base de datos MySQL.
 */
public class JdbcUtils {

    /**
     * Conexión única a la base de datos.
     */
    private static Connection connection;

    /**
     * Bloque estático que se ejecuta al cargar la clase. Establece la conexión con la base de datos
     * utilizando los parámetros de conexión (URL, usuario, y contraseña). La contraseña se obtiene
     * de una variable de entorno "MYSQL_ROOT_PASSWORD".
     *
     * @throws RuntimeException Si ocurre un error al intentar conectarse a la base de datos.
     */
    static {
        String url = "jdbc:mysql://localhost:3306/PRUEBAJDBC";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método estático para obtener la conexión a la base de datos.
     *
     * @return La conexión única establecida con la base de datos.
     */
    public static Connection getConnection() {
        return connection;
    }
}
