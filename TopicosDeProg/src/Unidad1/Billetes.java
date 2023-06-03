package Unidad1;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Unidad1EjemplosDeClase.Rutinas;

public class Billetes {

	static File f;
	static RandomAccessFile arch;
	static int nombre, nc, monto;
	static int[] cant_bill = new int[10], denominaciones = new int[] { 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
	private int lim_inf = 10, lim_sup = 20;
	ArrayList<Inventario> inventario = new ArrayList<>();

	public void setMonto(int monto) {
		Billetes.monto = monto;
	}

	public void Abrir() throws IOException {
		f = new File("BILLETES.DAT");
		arch = new RandomAccessFile(f, "rw");
	}

	public void Cerrar() throws IOException {
		arch.close();
	}

	public void Cambiador(ArrayList<Denominacion> distraux) {
		// se queda con el numero entero de la division monto/1000 (la
		// cual sera nuestra cantidad de billetes).
		// Multiplicamos la cantidad de billetes por 1000 y se lo restamos al monto.
		for (int i = 0; i < denominaciones.length; i++) {
			cant_bill[i] = monto / denominaciones[i];
			monto = monto - (cant_bill[i] * denominaciones[i]);
			if (cant_bill[i] >= 0) {
				distraux.add(new Denominacion(denominaciones[i], cant_bill[i]));
			}
		}
	}

	public void Cambia(ArrayList<Inventario> inventario) {
		try {
			for (int i = 0; i < denominaciones.length; i++) {
				arch.seek((denominaciones[i] - 1) * 8 + 4);
				nombre = arch.readInt() - cant_bill[i];
				
				arch.seek((denominaciones[i] - 1) * 8 + 4);
				arch.writeInt(nombre);
				arch.writeInt(nc);

				arch.seek((denominaciones[i] - 1) * 8);

				nc = arch.readInt();
				nombre = arch.readInt();

				if (nombre > 0) {
					inventario.add(new Inventario(denominaciones[i], nombre));
				} else if (nombre < 0) {
					JOptionPane.showMessageDialog(null,
							"El importe excede la cantidad de \n billetes en el inventario.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		} catch (IOException e) {
			System.out.println("+++++ fin de contenido ++++++");
			return;
		}
	}

	public void Agrega() throws IOException {
		for (int i = 0; i < denominaciones.length; i++) {

			arch.seek((denominaciones[i] - 1) * 8 + 4);

			nombre = Rutinas.nextInt(lim_inf += 10, lim_sup += 20);

			arch.writeInt(nombre);
			arch.writeInt(nc);

			arch.seek((denominaciones[i] - 1) * 8);

			nc = arch.readInt();
			nombre = arch.readInt();

			inventario.add(new Inventario(nc, nombre));
		}
	}
}

class Inventario {

	private int denominacion, cantidad;

	public Inventario() {

	}

	public Inventario(int denominacion, int cantidad) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
	}

	public int getDenominacion() {
		return denominacion;
	}

	public int getCantidad() {
		return cantidad;
	}

}