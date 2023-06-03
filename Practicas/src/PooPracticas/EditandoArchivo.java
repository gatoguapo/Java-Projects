package PooPracticas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class EditandoArchivo {

	public static void main(String args[]) {
		ArrayList<Productos> productos = new ArrayList<>();

		productos.add(new Productos(1, "producto 1", 10.5, true, 'T'));
		productos.add(new Productos(2, "producto 2", 50.5, true, 'R'));
		productos.add(new Productos(3, "producto 3", 10.5, false, 'T'));
		productos.add(new Productos(4, "producto 4", 30.5, true, 'B'));
		productos.add(new Productos(5, "producto 5", 20.5, true, 'T'));

		try (RandomAccessFile raf = new RandomAccessFile("ejemplo_raft.dat", "rw")) {

			for (Productos p : productos) {
				raf.writeInt(p.getId());

				StringBuffer sb = new StringBuffer(p.getNombre());
				sb.setLength(10);
				raf.writeChars(sb.toString());

				raf.writeDouble(p.getPrecio());
				raf.writeBoolean(p.isDescuento());
				raf.writeChar(p.getTipo());
			}

			// int = 4 + String = 2x(N caracteres) + Double = 8 + Boolean = 1 + Char = 2
			// 35 bytes cada registro
			// Obtener el seek de cada registro
			// pos[1]=0,pos[2]=35,pos[3]=70,pos[4]=105,pos[5]=140.

			int sick = 0;
			do {
				raf.seek(sick);
				System.out.println(raf.readInt());
				String nombre = "";
				for (int i = 0; i < 10; i++) {
					nombre += raf.readChar();
				}
				System.out.println(nombre);
				System.out.println(raf.readDouble());
				System.out.println(raf.readBoolean());
				System.out.println(raf.readChar());
				System.out.println("-----------------------");
				sick = sick + 35;
			} while (sick != 140);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
