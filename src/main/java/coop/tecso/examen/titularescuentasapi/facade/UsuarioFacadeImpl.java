package coop.tecso.examen.titularescuentasapi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coop.tecso.examen.titularescuentasapi.dto.UsuarioDto;
import coop.tecso.examen.titularescuentasapi.service.CampoIncorrectoException;
import coop.tecso.examen.titularescuentasapi.service.UsuarioService;

@Service
public class UsuarioFacadeImpl extends CommonFacade implements UsuarioFacade {

    @Autowired
    private UsuarioService service;
    
    @Override
    public ResponseEntity<?> crearUsuario(UsuarioDto dto) {
        ResponseEntity<?> respuesta = null;
        try {
            service.crearUsuario(dto);
            respuesta = respuestaCreadoConExito();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error creando el usuario");
        }
        return respuesta;
    }

}
