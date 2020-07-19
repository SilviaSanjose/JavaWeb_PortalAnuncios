package daosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ConstantsSQL;

public class MasterDAO {
	private final static String url = "jdbc:mysql://localhost:3306/db_anuncios_java";
	private final static String user = "root";
	private final static String pass = "";
	
	//protected es para usarlo en la clase y en las clases que hereden 
	protected Connection conexion = null; 
	protected ConstantsSQL sql = new ConstantsSQL();
	
	public MasterDAO() {
		// Constructor con la carga del driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Fallo en Driver");
			//e.printStackTrace();
		}
	}//end ItemDAOImpl
	
	protected void connectDb() {  //conexion con BD
		try {
			conexion = DriverManager.getConnection(url,user, pass);
		} catch (SQLException e) {
			System.out.println("fallo conexión a base de datos");
			//e.printStackTrace();
		} 
	}
	
	protected void disconnectDb(){  //desconexion con BD
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se puede deconectar de DB");
			//e.printStackTrace();
		}
	}
}
