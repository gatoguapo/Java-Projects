package Unidad2;

import java.sql.*;
import java.util.Vector;

import javax.swing.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Marcas {

	private Conexion con = new Conexion();;
	private Statement stat = con.getStatement();
	private Vector marcas_busqueda;

	public Vector getBusqueda(String busqueda) {
		marcas_busqueda = new Vector();
		try {
			String consulta = "SELECT Nombre FROM Marcas where Nombre like '" + busqueda + "%' and Vigencia='A' order by Nombre";
			ResultSet resultado = stat.executeQuery(consulta);
			
			while (resultado.next()) {
				if (resultado.getString(1)!=null) {
					marcas_busqueda.add(resultado.getString(1));
				}
			}
			
			return marcas_busqueda;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return null;
		}
	}
}
