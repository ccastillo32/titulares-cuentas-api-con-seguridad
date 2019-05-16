package coop.tecso.examen.titularescuentasapi.service;

public class CampoIncorrectoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CampoIncorrectoException(String mensaje) {
        super(mensaje);
    }
    
    public CampoIncorrectoException(Throwable exp) {
        super(exp);
    }
    
    public CampoIncorrectoException(String mensaje, Throwable exp) {
        super(mensaje, exp);
    }
    
}
