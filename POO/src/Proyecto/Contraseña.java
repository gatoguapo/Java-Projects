package Proyecto;

import java.io.Serializable;

public class Contraseña implements Serializable {
    String identificador;
    String correoPrincipal;
    String correoAlternativo;
    String usuario;
    String contraseña;
    String url;
    String notas;

    public Contraseña() {
        this(null, null, null, null, null, null, null);
    }

    public Contraseña(String identificador, String correoPrincipal, String correoAlternativo, String usuario, String contraseña, String url, String notas) {
        this.identificador = identificador;
        this.correoPrincipal = correoPrincipal;
        this.correoAlternativo = correoAlternativo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.url = url;
        this.notas = notas;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Contraseña{" + "identificador='" + identificador + '\'' + ", correoPrincipal='" + correoPrincipal + '\'' + ", correoAlternativo='" + correoAlternativo + '\'' +
                ", usuario='" + usuario + '\'' + ", contraseña='" + contraseña + '\'' + ", url='" + url + '\'' + ", notas='" + notas + '\'' + '}';
    }
}
