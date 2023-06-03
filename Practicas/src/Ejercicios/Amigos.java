package Ejercicios;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Amigos {
		static String amigosaux = "";
		static String amigos;
		
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Quieres saber que son tus amigos?");
		amigos = JOptionPane.showInputDialog("Introduce el nombre de tu amigo");
		
		gays();
		
		ImageIcon icon = new ImageIcon("pika");
		JOptionPane.showOptionDialog(null, "Pika!", "Easter Egg", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, icon);

	}
	
	public static void gays () {
		if (amigos.contains("carlio")) {
			JOptionPane.showMessageDialog(null, "tu amigo "+amigos+ " es buchon");
		}
		else {
			JOptionPane.showMessageDialog(null, "tu amigo "+amigos+ " es normal");
		}
	
	}
}

	


