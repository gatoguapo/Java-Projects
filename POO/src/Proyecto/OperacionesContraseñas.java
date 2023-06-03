package Proyecto;

import java.io.*;
import java.util.ArrayList;

public class OperacionesContraseñas {
    private String archivo = "Contrasenias.dat";
    private ConjuntoDeContraseñas contraseñas;

    public OperacionesContraseñas() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            Object aux = ois.readObject();
            if (aux instanceof ConjuntoDeContraseñas)
                contraseñas = (ConjuntoDeContraseñas) aux;
            ois.close();
        } catch (FileNotFoundException e) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
                oos.writeObject(new ConjuntoDeContraseñas());
                contraseñas = new ConjuntoDeContraseñas();
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

    public void AgregarContraseña(Contraseña contraseña) {
        String identificadorActual;
        boolean existe = false;

        for(int i=0; i<contraseñas.getContraseñas().size(); i++) {
            identificadorActual = contraseñas.getContraseñas().get(i).getIdentificador();
            if(identificadorActual.equals(contraseña.identificador))
                existe = true;
        }
        if (existe == false) {
            contraseñas.getContraseñas().add(contraseña);
        } else {
            System.out.println("Ya hay una contraseña con ese identificador");
        }
    }

    public ArrayList<Contraseña> listarContraseñas() {
        return contraseñas.getContraseñas();
    }

    public Contraseña lee(String identificador)  {
        String identificadorActual;

        for(int i=0; i<contraseñas.getContraseñas().size(); i++) {
            identificadorActual = contraseñas.getContraseñas().get(i).getIdentificador();
            if(identificadorActual.equals(identificador))
                return contraseñas.getContraseñas().get(i);
        }
        return null;
    }

    public void Guarda() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(contraseñas);
            oos.close();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void EliminarContraseña(String identificador)  {
        String identificadorActual;

        for(int i=0; i<contraseñas.getContraseñas().size(); i++) {
            identificadorActual = contraseñas.getContraseñas().get(i).getIdentificador();
            if(identificadorActual.equals(identificador)) {
                contraseñas.getContraseñas().remove(i);
                return;
            }
        }

        System.out.println("No se encontro ninguna contraseña");
    }
    public void ActualizaContraseña(Contraseña contraseña, String identificador) {
        String identificadorActual;

        for(int i=0; i<contraseñas.getContraseñas().size(); i++) {
            identificadorActual = contraseñas.getContraseñas().get(i).getIdentificador();
            if(identificadorActual.equals(identificador))
                contraseñas.getContraseñas().set(i, contraseña);
        }
    }

}