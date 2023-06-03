package ProyectoProcesos;

import java.util.Comparator;

public class Procesos {
    private int numero;
    private int tiempoDeInicio;
    private int prioridad;
    private int duracion;
    private int tiempoDeSalida;

    public int getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public void setTiempoDeSalida(int tiempoDeSalida) {
        this.tiempoDeSalida = tiempoDeSalida;
    }

    // 	public Procesos(int nProceso, int tAparicion, int duracion, int prioridad) {

    public Procesos(int numero, int tiempoDeInicio, int duracion, int prioridad) {
        this.numero = numero;
        this.tiempoDeInicio = tiempoDeInicio;
        this.prioridad = prioridad;
        this.duracion = duracion;
       // this.tiempoDeSalida = 0;
    }

    public static Comparator<Procesos> PrioridadComparador = new Comparator<Procesos>() {

        public int compare(Procesos p1, Procesos p2) {
            int prioridad1 = p1.getPrioridad();
            int prioridad2 = p2.getPrioridad();

            return prioridad2 - prioridad1;
        }
    };
    public static Comparator<Procesos> DuracionComparador = new Comparator<Procesos>() {

        public int compare(Procesos p1, Procesos p2) {
            int duracion1 = p1.getDuracion();
            int duracion2 = p2.getDuracion();

            return duracion1 - duracion2;
        }
    };
    public static Comparator<Procesos> ordenar = new Comparator<Procesos>() {

        public int compare(Procesos p1, Procesos p2) {
            int numero1 = p1.getNumero();
            int numero2 = p2.getNumero();

            return numero1 - numero2;
        }
    };

    public static Comparator<Procesos> TAparicionComparador = new Comparator<Procesos>() {

        public int compare(Procesos p1, Procesos p2) {
            int tAparicion1 = p1.getTiempoDeInicio();
            int tAparicion2 = p2.getTiempoDeInicio();

            return tAparicion1 - tAparicion2;
        }
    };



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTiempoDeInicio() {
        return tiempoDeInicio;
    }

    public void setTiempoDeInicio(int tiempoDeInicio) {
        this.tiempoDeInicio = tiempoDeInicio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
