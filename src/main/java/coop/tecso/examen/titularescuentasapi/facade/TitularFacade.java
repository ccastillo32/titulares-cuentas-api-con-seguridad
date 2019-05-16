package coop.tecso.examen.titularescuentasapi.facade;

import org.springframework.http.ResponseEntity;

import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;

/**
 * Consume la logica de negocio (Service) y crea los ResponseEntity para el controlador.
 * @author Cristian
 *
 */

public interface TitularFacade {

    /**
     * Obtiene la lista de titulares fisicos y juridicos
     * @return Devuelve HTTP 200 OK
     */
    public ResponseEntity<?> listarTitulares();
    
    
    /**
     * Busca un titular por el CUIT.
     * @param cuitSinGuiones Si el CUIT es 20-12345678-7, se debe ingresar 20123456787
     * @return Devuelve HTTP 200 OK
     */
    public ResponseEntity<?> buscarTitular(String cuitSinGuiones);
    
    
    /**
     * Elimina un titular
     * @param cuitSinGuiones El cuit del titular, sin guiones
     * @return Devuelve HTTP 204 No content.
     */
    public ResponseEntity<?> eliminarTitular(String cuitSinGuiones);
    
    
    /**
     * Crea un nuevo titular fisico.
     * @return Devuelve HTTP 201 Created
     */
    public ResponseEntity<?> crearTitularFisico(TitularFisicoDto titularFisico);
    
    
    /**
     * Crea un nuevo titular juridico.
     * @return Devuelve HTTP 201 Created
     */
    public ResponseEntity<?> crearTitularJuridico(TitularJuridicoDto titularJuridico);
    
    
    /**
     * Actualiza un titular fisico.
     * @return Devuelve HTTP 204 No content
     */
    public ResponseEntity<?> actualizarTitularFisico(TitularFisicoDto titularFisico);
    
    
    /**
     * Actualiza un titular juridico.
     * @return Devuelve HTTP 204 No content
     */
    public ResponseEntity<?> actualizarTitularJuridico(TitularJuridicoDto titularJuridico);
    
}
