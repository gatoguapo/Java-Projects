package Proyecto;

import java.io.*;
import java.util.ArrayList;

public class OperacionesContrase�as {
    private String archivo = "Contrasenias.dat";
    private ConjuntoDeContrase�as contrase�as;

    public OperacionesContrase�as() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            Object aux = ois.readObject();
            if (aux instanceof ConjuntoDeContrase�as)
                contrase�as = (ConjuntoDeContrase�as) aux;
            ois.close();
        } catch (FileNotFoundException e) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
                oos.writeObject(new ConjuntoDeContrase�as());
                contrase�as = new ConjuntoDeContrase�as();
                oos.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void AgregarContrase�a(Contrase�a contrase�a) {
        String identificadorActual;
        boolean existe = false;

        for(int i=0; i<contrase�as.getContrase�as().size(); i++) {
            identificadorActual = contrase�as.getContrase�as().get(i).getIdentificador();
            if(identificadorActual.equals(contrase�a.identificador))
                existe = true;
        }
        if (existe == false) {
            contrase�as.getContrase�as().add(contrase�a);
        } else {
            System.out.println("Ya hay una contrase�a con ese identificador");
        }
    }

    public ArrayList<Contrase�a> listarContrase�as() {
        return contrase�as.getContrase�as();
    }

    public Contrase�a lee(String identificador)  {
        String identificadorActual;

        for(int i=0; i<contrase�as.getContrase�as().size(); i++) {
            identificadorActual = contrase�as.getContrase�as().get(i).getIdentificador();
            if(identificadorActual.equals(identificador))
                return contrase�as.getContrase�as().get(i);
        }
        return null;
    }

    public void Guarda() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(contrase�as);
            oos.close();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void EliminarContrase�a(String identificador)  {
        String identificadorActual;

        for(int i=0; i<contrase�as.getContrase�as().size(); i++) {
            identificadorActual = contrase�as.getContrase�as().get(i).getIdentificador();
            if(identificadorActual.equals(identificador)) {
                contrase�as.getContrase�as().remove(i);
                return;
            }
        }

        System.out.println("No se encontro ninguna contrase�a");
    }
    public void ActualizaContrase�a(Contrase�a contrase�a, String identificador) {
        String identificadorActual;

        for(int i=0; i<contrase�as.getContrase�as().size(); i++) {
            identificadorActual = contrase�as.getContrase�as().get(i).getIdentificador();
            if(identificadorActual.equals(identificador))
                contrase�as.getContrase�as().set(i, contrase�a);
        }
    }

}