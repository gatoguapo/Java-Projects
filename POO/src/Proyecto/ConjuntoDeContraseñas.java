package Proyecto;

import java.io.Serializable;
import java.util.ArrayList;

public class ConjuntoDeContrase�as implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Contrase�a> contrase�as;

    public ConjuntoDeContrase�as (ArrayList<Contrase�a> contrase�as) {
        this.contrase�as = contrase�as;
    }

    public ConjuntoDeContrase�as() {
        this(new ArrayList<>());
    }

    public ArrayList<Contrase�a> getContrase�as() {
        return contrase�as;
    }
}
