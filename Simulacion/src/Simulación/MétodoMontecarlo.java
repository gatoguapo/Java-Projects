package Simulación;

	import java.util.Random;
	import java.util.Scanner;
	import javax.swing.JFrame;
	import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartPanel;
	import org.jfree.chart.JFreeChart;
	import org.jfree.data.general.DefaultPieDataset;

	public class MétodoMontecarlo {

	    static String valorGenerado;
	    static int opc; //opción en menú
	    static int repeticiones;
	    static double moneda;
	    static double dado;
	    static int c1 = 0;
	    static int c2 = 0;
	    static int c3 = 0;
	    static int c4 = 0;
	    static int c5 = 0;
	    static int c6 = 0;

	    public static void main(String[] args) {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        Scanner leer = new Scanner(System.in); // se declara objeto para el escáner
	        Random aleatorio = new Random(); // se declara objeto para generar valor random
	        System.out.println("¿Cuántos años desea simular?");
	;
	        opc = leer.nextInt();

	        switch (opc) {
	            case 1:// por teclado
	                System.out.println("Dado");
	                System.out.println("¿Cuántas veces desea lanzar el dado?");
	                repeticiones = leer.nextInt();
	                System.out.println("     N\t     N.alegen\t     Resultado");
	                System.out.println(" ");

	                for (int i = 0; i < repeticiones; i++) {
	                    dado = (aleatorio.nextInt((int) ((1 - 0) * 10 + 1)) + 0 * 10) / 10.0; // genera num aleatorio del 0 al 1
	                    if (dado > 0.0 && dado <= 0.1667) {
	                        c1++;
	                        valorGenerado = "1/6";
	                        dataset.setValue(valorGenerado, c1);
	                    } else if (dado > 0.1667 && dado <= 0.3333) {
	                        c2++;
	                        valorGenerado = "2/6";
	                        dataset.setValue(valorGenerado, c2);
	                    } else if (dado > 0.3333 && dado <= 0.5) {
	                        c3++;
	                        valorGenerado = "3/6";
	                        dataset.setValue(valorGenerado, c3);
	                    } else if (dado > 0.5 && dado <= 0.6667) {
	                        c4++;
	                        valorGenerado = "4/6";
	                        dataset.setValue(valorGenerado, c4);
	                    } else if (dado > 0.6667 && dado <= 0.8333) {
	                        c5++;
	                        valorGenerado = "5/6";
	                        dataset.setValue(valorGenerado, c5);
	                    } else if (dado > 0.8333 && dado <= 1.0) {
	                        c6++;
	                        valorGenerado = "6/6";
	                        dataset.setValue(valorGenerado, c6);
	                    }
	                    System.out.println(String.format("     %d       %s            %s", i, valorGenerado, dado));
	                }
	                JFreeChart chart = ChartFactory.createPieChart(
	                        "Dado",
	                        dataset,
	                        true,
	                        true, false);
	                ChartPanel panel = new ChartPanel(chart);

	                //Creamos la ventana
	                JFrame ventana = new JFrame("Grafica");
	                ventana.setVisible(true);
	                ventana.setSize(800, 600);
	                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	                ventana.add(panel);
	                break;
	            case 2:// por función random
	                System.out.println("Moneda");
	                System.out.println("¿Cuántas veces desea lanzar la moneda?");
	                repeticiones = leer.nextInt();
	                System.out.println("     N\t     N.alegen\t     Resultado");
	                System.out.println(" ");

	                for (int i = 0; i < repeticiones; i++) {
	                    moneda = (aleatorio.nextInt((int) ((1 - 0) * 10 + 1)) + 0 * 10) / 10.0;
	                    if (moneda > 0.0 && moneda <= 0.5) {
	                        c1++;
	                        valorGenerado = "Aguila";
	                        dataset.setValue(valorGenerado, c1);
	                    } else if (moneda > 0.5 && moneda <= 1.0) {
	                        c2++;
	                        valorGenerado = "Sello";
	                        dataset.setValue(valorGenerado, c2);
	                    }
	                    System.out.println(String.format("     %d       %s            %s", i, valorGenerado, moneda));
	                }
	                JFreeChart chartMoneda = ChartFactory.createPieChart(
	                        "Moneda",
	                        dataset,
	                        true,
	                        true, false);
	                ChartPanel panelMoneda = new ChartPanel(chartMoneda);

	                //Creamos la ventana
	                JFrame ventanaMoneda = new JFrame("Grafica");
	                ventanaMoneda.setVisible(true);
	                ventanaMoneda.setSize(800, 600);
	                ventanaMoneda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                ventanaMoneda.add(panelMoneda);
	                break;
	        }

	    }

}
