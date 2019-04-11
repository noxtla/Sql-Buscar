package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conn {

	private static String URL ="jdbc:mysql://localhost/db?use unicode=true&usejdbccomplianttimezoneshift=true&uselegacydatetimecode=false server timezone=utc";
	private static String user ="root";
	private static String pass ="root";
	
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	
	

			//Boton conectar
	 private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {                                              
	       Connection conexion = getConnection();
	        }
	       

	 	///Funcion para conectar
	public Connection getConnection () {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.driver");
			conn = DriverManager.getConnection(URL,user,pass);
			///Mesanje de exito;

		} catch (Exception e) {
			///Mensaje de error
			
		}
		return conn;
	}
	
	
	public void botonBuscar() {
		///Conectamos
		conn = getConnection();
		try {
		///Preparamos
			ps = conn.prepareStatement("select * from usuarios where codigo=? ");
			ps.setString(1, cajaClave.getText());
		///Ejecutamos
			rs = ps.executeQuery();
			
			if (rs.next()) {
				///Devolvemos los resultados a las cajas
				
			} else {
				///No hay nadie 
				cajaClave.setText(rs.getString("clave"));
				cajaNombre.setText(rs.getString("nombre"));
			}
			
		} catch (Exception e) {
			// TODO se derrumbo
		}
		
		
	}
}
