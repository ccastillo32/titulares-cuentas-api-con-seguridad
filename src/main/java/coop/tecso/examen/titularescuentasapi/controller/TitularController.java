package coop.tecso.examen.titularescuentasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;
import coop.tecso.examen.titularescuentasapi.facade.TitularFacade;

/**
 * Api rest para la gestion de titulares
 * @author Cristian
 *
 */

@RestController
@RequestMapping("/api/titulares-cuentas")
public class TitularController {

    @Autowired
    private TitularFacade facade;
    
    /**
     * Obtiene la lista de titulares.
     * Endpoint: GET /api/titulares-cuentas
     * @return Devuelve un HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<?> listarTitulares() {
        return facade.listarTitulares();
    }

    
    /**
     * Busca un titular fisico o juridico.
     * Endpoint: GET /api/titulares-cuentas/{cuitSinGuiones}
     * @param cuitSinGuiones El Cuit del titular, sin guiones
     * @return Devuelve HTTP 200 OK
     */
    @GetMapping("/{cuitSinGuiones}")
    public ResponseEntity<?> buscarTitular(@PathVariable String cuitSinGuiones) {
        return facade.buscarTitular(cuitSinGuiones);
    }
    
    
    /**
     * Elimina un titular.
     * Endpoint: DELETE /api/titulares-cuentas/{cuitSinGuiones}
     * @param cuitSinGuiones El cuit del titular, sin guiones
     * @return Devuelve un HTTP 204 No content
     */
    @DeleteMapping("/{cuitSinGuiones}")
    public ResponseEntity<?> eliminarTitular(@PathVariable String cuitSinGuiones) {
        return facade.eliminarTitular(cuitSinGuiones);
    }
    
    
    /**
     * Crea un nuevo titular fisico
     * Endpoint: POST /api/titulares-cuentas/fisico
     * @return Devuelve un HTTP 201 Created
     */
    @PostMapping("/fisico")
    public ResponseEntity<?> crearTitularFisico(@RequestBody TitularFisicoDto titularFisico) {
        return facade.crearTitularFisico(titularFisico);
    }
    
    
    /**
     * Crea un nuevo titular juridico
     * Endpoint: POST /api/titulares-cuentas/juridico
     * @return Devuelve un HTTP 201 Created
     */
    @PostMapping("/juridico")
    public ResponseEntity<?> crearTitularJuridico(@RequestBody TitularJuridicoDto titularJuridico) {
        return facade.crearTitularJuridico(titularJuridico);
    }
    
    
    /**
     * Actualiza un titular fisico
     * Endpoint: PUT /api/titulares-cuentas/fisico
     * @return Devuelve un HTTP 204 No content
     */
    @PutMapping("/fisico")
    public ResponseEntity<?> actualizarTitularFisico(@RequestBody TitularFisicoDto titularFisico) {
        return facade.actualizarTitularFisico(titularFisico);
    }
    
    
    /**
     * Actualiza un titular juridico
     * Endpoint: PUT /api/titulares-cuentas/juridico
     * @return Devuelve un HTTP 204 No content
     */
    @PutMapping("/juridico")
    public ResponseEntity<?> actualizarTitularJuridico(@RequestBody TitularJuridicoDto titularJuridico) {
        return facade.actualizarTitularJuridico(titularJuridico);
    }
    
    
}
