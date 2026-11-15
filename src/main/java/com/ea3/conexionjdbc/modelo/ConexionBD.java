
package com.ea3.conexionjdbc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Método para probar la conexión con SQLite
    public void probarConexion(String url)
            throws ClassNotFoundException, SQLException {

        // Cargar el controlador JDBC
        Class.forName("org.sqlite.JDBC");

        // Establecer y cerrar la conexión automáticamente
        try (Connection conexion = DriverManager.getConnection(url)) {

            if (conexion.isValid(2)) {
                System.out.println("Conexión exitosa con SQLite.");
            }

        }
    }
}