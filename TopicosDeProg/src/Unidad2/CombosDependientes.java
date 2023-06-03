package Unidad2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CombosDependientes {
	
	private Conexion con = new Conexion();;
	private Statement stat = con.getStatement();
	private String[] estados, municipios, ciudades;
	private static int id_estado = 0, id_municipio = 0;
	
	public String[] getEstados() {
		int i = 0;
		estados = new String[5];
		try {
			String consulta = "SELECT Nombre FROM Estados";
			ResultSet resultado = stat.executeQuery(consulta);
			while (resultado.next()) {
				estados[i] = resultado.getString(1);
				i++;
			}
			
			return estados;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return null;
		}
	}
	
	public String[] getMunicipios(int id_estado) {
		int i = 0;
		municipios = new String[2];
		try {
			String consulta = "SELECT Nombre FROM Municipios where IdEstado="+id_estado;
			ResultSet resultado = stat.executeQuery(consulta);
			while (resultado.next()) {
				municipios[i] = resultado.getString(1);
				i++;
			}	
			return municipios;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return null;
		}
	}
	
	public String[] getCiudades(int id_estado, int id_municipio) {
		int i = 0;
		ciudades = new String[2];
		try {
			String consulta = "SELECT Nombre FROM Ciudades where IdEstado="+id_estado+" and IdMunicipio="+id_municipio;
			ResultSet resultado = stat.executeQuery(consulta);
			while (resultado.next()) {
				ciudades[i] = resultado.getString(1);
				i++;
			}
			
			
			return ciudades;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return null;
		}
	}
	
	public int getEstadosConstructor(String estado) {
		try {
			String consulta = "SELECT IdEstado FROM Estados where Nombre='"+estado+"';";
			ResultSet resultado = stat.executeQuery(consulta);
			
			while (resultado.next()) {
				
				id_estado = Integer.parseInt(resultado.getString(1));
				
			}
			
			return id_estado;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return 0;
		}
	}
	
	public int getMunicipiosConstructor(int id_estado, String municipios) {
		try {
			String consulta = "SELECT IdMunicipio FROM Municipios where IdEstado='"+id_estado+"' and Nombre='"+municipios+"';";
			ResultSet resultado = stat.executeQuery(consulta);
			
			while (resultado.next()) {
				id_municipio = Integer.parseInt(resultado.getString(1));
			}
			
			return id_municipio;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return 0;
		}
	}
}
