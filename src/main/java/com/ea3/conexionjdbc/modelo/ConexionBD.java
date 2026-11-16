package com.ea3.conexionjdbc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Método para probar la conexión con la base de datos
    public String probarConexion(String url, String usuario, String password)
            throws ClassNotFoundException, SQLException {

        // 1. Cargar el controlador JDBC de SQLite
        Class.forName("org.sqlite.JDBC");

        // 2. Declarar el objeto de conexión
        Connection conexion;

        // 3. Establecer la conexión según las credenciales ingresadas
        if (usuario.isEmpty() && password.isEmpty()) {

            conexion = DriverManager.getConnection(url);

        } else {

            conexion = DriverManager.getConnection(
                    url,
                    usuario,
                    password
            );
        }

        // 4. Utilizar try-with-resources para cerrar la conexión
        try (conexion) {

            // 5. Obtener información de la base de datos
            String nombreBD = conexion.getMetaData()
                    .getDatabaseProductName();

            // 6. Devolver el resultado al controlador
            return "Conexión establecida correctamente.\n\n"
                    + "Motor de base de datos: " + nombreBD + "\n"
                    + "URL utilizada: " + url;
        }
    }
}