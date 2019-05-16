package coop.tecso.examen.titularescuentasapi.facade;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class CommonFacade {
    
    /**
     * @return Devuelve un ResponseEntity con el estado 500
     */
    protected ResponseEntity<Map<String, String>> internalServerError(String mensaje) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("error", mensaje);
        return new ResponseEntity<Map<String, String>>(mapa, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * @return Devuelve un ResponseEntity con el estado 422
     */
    protected ResponseEntity<Map<String, String>> unprocessableEntity(String mensaje) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("error", mensaje);
        return new ResponseEntity<Map<String, String>>(mapa, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    /**
     * @return Devuelve una respuesta con el restado 200
     */
    protected ResponseEntity<Object>  respuestaOK(Object object) {
        return ResponseEntity.ok(object);
    }
    
    protected ResponseEntity<?> respuestaVacia() {
        return ResponseEntity.noContent().build();
    }
    
    protected ResponseEntity<Object> respuestaCreadoConExito() {
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }
    
    /**
     * Imprime error
     */
    protected void log(Exception exp) { // TODO: Esto deberia imprimir en un log real
        System.err.println("Excepcion capturada");
        exp.printStackTrace(System.err);
    }

}
