package coop.tecso.examen.titularescuentasapi.service;

/**
 * Excepcion lanzada por la capa de Servicio
 * @author Cristian
 *
 */

public class UsuarioServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioServiceException(String mensaje) {
        super(mensaje);
    }
    
    public UsuarioServiceException(Throwable exp) {
        super(exp);
    }
    
    public UsuarioServiceException(String mensaje, Throwable exp) {
        super(mensaje, exp);
    }
    
}
