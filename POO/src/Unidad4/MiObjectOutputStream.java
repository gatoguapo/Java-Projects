package Unidad4;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
 
/**
 * Redefinición de la clase ObjectOuputStream para que no escriba una cabecera
 * al inicio del Stream.
 * 
 * @author Javier Abellán.
 *
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    /** Constructor que recibe OutputStream */
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
 
    /** Constructor sin parámetros */
    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }
 
    /**
     * Redefinición del método de escribir la cabecera para que no haga nada.
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }
 
}
