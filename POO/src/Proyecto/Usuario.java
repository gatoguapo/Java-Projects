package Proyecto;

public class Usuario {
	String Usuario;
    String Contrase�a;
    public static final int TAMANIO = 304;

    public Usuario(String usuario, String contrase�a) {
        this.Usuario = usuario;
        this.Contrase�a = contrase�a;
    }

    public Usuario() {
        this("", "");
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getContrase�a() {
        return Contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.Contrase�a = contrase�a;
    }

    public static int getTAMANIO() {
        return TAMANIO;
    }
}
