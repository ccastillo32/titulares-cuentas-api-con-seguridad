package coop.tecso.examen.titularescuentasapi.facade;

import org.springframework.http.ResponseEntity;

import coop.tecso.examen.titularescuentasapi.dto.UsuarioDto;

public interface UsuarioFacade {
    
    public ResponseEntity<?> crearUsuario(UsuarioDto dto);

}
