package Proyecto;

import java.io.Serializable;

public class Contraseņa implements Serializable {
    String identificador;
    String correoPrincipal;
    String correoAlternativo;
    String usuario;
    String contraseņa;
    String url;
    String notas;

    public Contraseņa() {
        this(null, null, null, null, null, null, null);
    }

    public Contraseņa(String identificador, String correoPrincipal, String correoAlternativo, String usuario, String contraseņa, String url, String notas) {
        this.identificador = identificador;
        this.correoPrincipal = correoPrincipal;
        this.correoAlternativo = correoAlternativo;
        this.usuario = usuario;
        this.contraseņa = contraseņa;
        this.url = url;
        this.notas = notas;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Contraseņa{" + "identificador='" + identificador + '\'' + ", correoPrincipal='" + correoPrincipal + '\'' + ", correoAlternativo='" + correoAlternativo + '\'' +
                ", usuario='" + usuario + '\'' + ", contraseņa='" + contraseņa + '\'' + ", url='" + url + '\'' + ", notas='" + notas + '\'' + '}';
    }
}
