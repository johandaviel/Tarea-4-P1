package Tarea4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexiondb {
	
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/registrousuarios";
	private static final String usuario = "root";
	
	//database
	Connection cn = null;
	Statement stm = null;	
	
	static {
		try {
			Class.forName(controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("error en el controlador.");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, "");
			
			System.out.println("conexion ok.");
		} catch (SQLException e) {
			System.out.println("error en la conexion. ");
			e.printStackTrace();
		}
		return conexion;
	}
	
	
	public static void main(String[] args) {
		/*formularioInicio conexion = new formularioInicio();
		conexion.conectar();
		*/
	}

}
