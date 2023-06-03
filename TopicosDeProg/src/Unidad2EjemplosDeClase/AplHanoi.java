package Unidad2EjemplosDeClase;

public class AplHanoi {
	public static void main(String [] a) {
		VistaHanoi vista = new VistaHanoi();
		ModeloHanoi modelo=new ModeloHanoi();
		ControladorHanoi controlador=new ControladorHanoi(vista,modelo,5);
		vista.setCntrolador(controlador);
		
		
	}

}

