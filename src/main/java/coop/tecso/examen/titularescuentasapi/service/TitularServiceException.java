package coop.tecso.examen.titularescuentasapi.service;

/**
 * Excepcion lanzada por la capa de Servicio
 * @author Cristian
 *
 */

public class TitularServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TitularServiceException(String mensaje) {
        super(mensaje);
    }
    
    public TitularServiceException(Throwable exp) {
        super(exp);
    }
    
    public TitularServiceException(String mensaje, Throwable exp) {
        super(mensaje, exp);
    }
    
}
