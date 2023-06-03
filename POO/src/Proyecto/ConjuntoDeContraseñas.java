package Proyecto;

import java.io.Serializable;
import java.util.ArrayList;

public class ConjuntoDeContraseñas implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Contraseña> contraseñas;

    public ConjuntoDeContraseñas (ArrayList<Contraseña> contraseñas) {
        this.contraseñas = contraseñas;
    }

    public ConjuntoDeContraseñas() {
        this(new ArrayList<>());
    }

    public ArrayList<Contraseña> getContraseñas() {
        return contraseñas;
    }
}
