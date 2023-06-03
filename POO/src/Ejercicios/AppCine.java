package Ejercicios;

import java.util.Random;

public class AppCine {

	public static void main(String[] args) {
		
		Random r = new Random();
		Cine cine = new Cine(new Pelicula("Eso", "No se", 90, Byte.parseByte((r.nextInt(18) + 5) + "")),
				r.nextInt(131) + 20);
		System.out.println(cine);
		int ren, col;
		for (int i = 0; i < 30; i++) {
			ren = r.nextInt(8);
			col = r.nextInt(9);
			if (cine.getButaca(ren, col) == null) {
				Espectador espec = new Espectador("Espectador " + (i + 1), (byte) (r.nextInt(100) + 5),
						r.nextInt(551) + 50);
				if (espec.getEdad() >= cine.getPeli().getEdadMin() && espec.getDinero() >= cine.getPrecio())
					cine.setButaca(ren, col, new Butaca(espec));
				else {
					System.out.println("Espectador rechasado: " + espec);
					i--;
				}
			} else
				i--;
		}
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 9; c++) {
				if (cine.getButaca(f, c) != null && cine.getButaca(f, c).isOcupada())
					System.out.print("O\t");
				else
					System.out.print("X\t");
			}
			System.out.println();
		}

	}

}
