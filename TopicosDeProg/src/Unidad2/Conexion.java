package Unidad2;

import java.sql.*;

import javax.swing.*;

public class Conexion {
	Connection con;
	Statement stat;
	String url,user,password;
	
	public Conexion() {
	
	}
	
	public Connection Connection() {
		url = "jdbc:sqlserver://DESKTOP-72TPBNU:1433;databaseName=Empresa;TrustServerCertificate=True";
		user = "sa";
		password = "123456123";
		try {	
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Conexion exitosa!");
			return con;
		} catch(SQLException ex) {
			System.out.println(ex.toString());
			return null;
		}
		
	}

	public Statement getStatement() {
		try {
			return stat = Connection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
