package Proyecto;

import java.io.Serializable;

public class Contrase�a implements Serializable {
    String identificador;
    String correoPrincipal;
    String correoAlternativo;
    String usuario;
    String contrase�a;
    String url;
    String notas;

    public Contrase�a() {
        this(null, null, null, null, null, null, null);
    }

    public Contrase�a(String identificador, String correoPrincipal, String correoAlternativo, String usuario, String contrase�a, String url, String notas) {
        this.identificador = identificador;
        this.correoPrincipal = correoPrincipal;
        this.correoAlternativo = correoAlternativo;
        this.usuario = usuario;
        this.contrase�a = contrase�a;
        this.url = url;
        this.notas = notas;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Contrase�a{" + "identificador='" + identificador + '\'' + ", correoPrincipal='" + correoPrincipal + '\'' + ", correoAlternativo='" + correoAlternativo + '\'' +
                ", usuario='" + usuario + '\'' + ", contrase�a='" + contrase�a + '\'' + ", url='" + url + '\'' + ", notas='" + notas + '\'' + '}';
    }
}
