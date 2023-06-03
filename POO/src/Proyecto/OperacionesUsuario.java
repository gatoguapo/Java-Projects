package Proyecto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Unidad4.RAFException;

public class OperacionesUsuario {
    public RandomAccessFile Archivo;

    private String leerCadena(RandomAccessFile archivo) throws IOException {
        char nombre[] = new char[50], temp;
        for (int cuenta = 0; cuenta < nombre.length; cuenta++) {
            temp = archivo.readChar();
            nombre[cuenta] = temp;
        }
        return new String(nombre).replace('\0', ' ');
    }

    public void nuevoRegistro(int posicion, Usuario usuario) throws IllegalArgumentException, IOException {
        // buscar registro apropiado en el archivo
        Archivo.seek((posicion) * Usuario.TAMANIO);
        escribirCadena(Archivo, usuario.getUsuario());
        escribirCadena(Archivo, usuario.getContraseña());
    }

    public Usuario obtenerRegistro(int posicion) throws IllegalArgumentException, NumberFormatException, IOException {
        Usuario usuario = new Usuario();
        if (posicion < 0 || posicion > 100)
            throw new IllegalArgumentException("Fuera de rango");
        // buscar registro apropiado en el archivo
        Archivo.seek((posicion) * Usuario.TAMANIO);
        if (Archivo.getFilePointer() < Archivo.length()) {
            usuario.setUsuario(leerCadena(Archivo));
            usuario.setContraseña(leerCadena(Archivo));
            return usuario;
        } else
            return null;
    }

    public void abrirArchivo(String nombreArchivo) throws IOException {
        Archivo = new RandomAccessFile(nombreArchivo, "rw");
    }

    public void cerrarArchivo() throws IOException {
        if (Archivo != null)
            Archivo.close();
    }

    public int RegresaPos(String nombre) throws IOException, RAFException {
        char nom[];
        int reg = 0;
        Archivo.seek(0);
        while (Archivo.getFilePointer() <Archivo.length()) {
            nom = new char[50];
            for (int cuenta = 0; cuenta < nom.length; cuenta++) {
                nom[cuenta] = Archivo.readChar();
            }
            if (new String(nom).replace('\0', ' ').trim().equals(nombre.trim())) {
                return reg;
            }
            reg++;
            Archivo.seek(reg * Usuario.TAMANIO);
        }
        throw new RAFException("Nombre no encontrado");
    }

    public int SigDisponible() throws IOException {
        char nom[];
        int reg = 0;
        Archivo.seek(0);
        while (Archivo.getFilePointer() <Archivo.length()) {
            nom = new char[50];
            for (int cuenta = 0; cuenta < nom.length; cuenta++) {
                nom[cuenta] = Archivo.readChar();
            }
            if (new String(nom).replace('\0', ' ').trim().isEmpty()) {
                return reg;
            }
            reg++;
            Archivo.seek(reg * Usuario.TAMANIO);
        }
        return reg;
    }

    private void escribirCadena(RandomAccessFile archivo, String cadena) throws IOException {
        StringBuffer bufer = null;
        if (cadena != null)
            bufer = new StringBuffer(cadena);
        else
            bufer = new StringBuffer(50);
        bufer.setLength(50);
        Archivo.writeChars(bufer.toString());
    }

    public ArrayList<Usuario> listado() throws IllegalArgumentException, NumberFormatException, IOException {
        Usuario usuario;
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        // buscar registro apropiado en el archivo
        Archivo.seek(0);

        while (Archivo.getFilePointer() < Archivo.length()) {
            usuario = new Usuario();
            usuario.setUsuario(leerCadena(Archivo).trim());
            usuario.setContraseña(leerCadena(Archivo).trim());
            if(!usuario.getUsuario().trim().isEmpty()) {
                Usuarios.add(usuario);
            }
        }
        return Usuarios;
    }
}
