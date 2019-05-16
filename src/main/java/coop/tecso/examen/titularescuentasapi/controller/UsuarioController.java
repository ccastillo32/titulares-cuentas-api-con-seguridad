package coop.tecso.examen.titularescuentasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.titularescuentasapi.dto.UsuarioDto;
import coop.tecso.examen.titularescuentasapi.facade.UsuarioFacade;

/**
 * Api rest para la gestion de usuarios
 * @author Cristian
 *
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioFacade facade;
    
    /**
     * Crea un nuevo usuario
     * Endpoint: POST /api/usuarios
     * @return Devuelve un HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDto dto) {
        return facade.crearUsuario(dto);
    }
    
    
}
