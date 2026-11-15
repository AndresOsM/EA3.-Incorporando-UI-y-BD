package com.ea3.conexionjdbc;

import com.ea3.conexionjdbc.modelo.ConexionBD;
import com.ea3.conexionjdbc.vista.ConexionView;
import com.ea3.conexionjdbc.controlador.ConexionController;

import javax.swing.SwingUtilities;

public class ConexionTester {

    public static void main(String[] args) {

        // Iniciar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            // Crear el Modelo
            ConexionBD modelo = new ConexionBD();

            // Crear la Vista
            ConexionView vista = new ConexionView();

            // Crear el Controlador
            new ConexionController(modelo, vista);

            // Mostrar la ventana
            vista.setVisible(true);
        });
    }
}