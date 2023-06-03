package Ejercicios;

import java.util.Random;

public class Password {

	private byte longitud;
	private String pass;

	public Password() {
		this((byte) 8);
	}

	public Password(byte longitud) {
		this.longitud = longitud;
		generaPass();
	}

	private void generaPass() {
		Random r = new Random();
		pass = "";
		int x;
		for (int i = 0; i < longitud; i++) {
			x = r.nextInt(8) + 1;
			switch (x) {
			case 1: // para generar digitos entre 0 y 9
			case 2:
			case 3:
			case 4:
			case 5:
				pass += (char) r.nextInt(10) + 48; // 48-57
				// pass+=r.nextInt(10);
				break;
			case 6: // para generar Mayuscula
			case 7:
				pass += (char) r.nextInt(26) + 65; // 65-90
				break;
			case 8: // para generar minuscula
				pass += (char) r.nextInt(26) + 97; // 97-122
				break;
			}
		}
	}

	public boolean EsFuerte() {
		int contMay = 0, contMin = 0, contNum = 0;
		for (int i = 0; i < longitud; i++) {
			if (Character.isDigit(pass.charAt(i)))
				contNum++;
			if (Character.isLowerCase(pass.charAt(i)))
				contMin++;
			if (Character.isUpperCase(pass.charAt(i)))
				contMin++;
		}
		return contMay > 2 && contMin > 1 && contNum > 5;
	}

	public byte getLongitud() {
		return longitud;
	}

	public void setLongitud(byte longitud) {
		this.longitud = longitud;
	}

	public String getPass() {
		return pass;
	}
}
