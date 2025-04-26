package com.inventory.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySqlConexion {
	//Conexion de la bd
		public static Connection getConexion() {
			Connection cn=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//variables
				String url,user,pass;

				url="jdbc:mysql://localhost:3306/bd_oxigInventory?serverTimezone=UTC";
				user="root";
				pass="mysql";
			
		//crear objeto cn
			cn=DriverManager.getConnection(url, user, pass);			
		}catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
			return cn;
		}

}
