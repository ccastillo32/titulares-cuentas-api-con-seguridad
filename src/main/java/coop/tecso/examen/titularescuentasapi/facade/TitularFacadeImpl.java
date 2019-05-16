package coop.tecso.examen.titularescuentasapi.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coop.tecso.examen.titularescuentasapi.dto.TitularDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;
import coop.tecso.examen.titularescuentasapi.service.CampoIncorrectoException;
import coop.tecso.examen.titularescuentasapi.service.TitularService;

@Service
public class TitularFacadeImpl extends CommonFacade implements TitularFacade {

    @Autowired
    private TitularService service;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> listarTitulares() {
        ResponseEntity<?> respuesta = null;
        try {
            List<TitularDto> titulares = service.listarTitularesActivos();
            respuesta = titulares.isEmpty() ? respuestaVacia() : respuestaOK(titulares);
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error consultando los titulares");
        }
        return respuesta;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> buscarTitular(String cuitSinGuiones) {
        ResponseEntity<?> respuesta = null;
        try {
            TitularDto titular = service.buscarPorCuit(cuitSinGuiones);
            respuesta = titular != null ? respuestaOK(titular) : respuestaVacia();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error buscando el titular");
        }
        return respuesta;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> eliminarTitular(String cuitSinGuiones) {
        ResponseEntity<?> respuesta = null;
        try {
            service.inhabilitarTitular(cuitSinGuiones);
            respuesta = respuestaVacia();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error eliminando el titular");
        }
        return respuesta;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> crearTitularFisico(TitularFisicoDto titularFisico) {
        ResponseEntity<?> respuesta = null;
        try {
            service.crearTitularFisico(titularFisico);
            respuesta = respuestaCreadoConExito();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error creando el titular");
        }
        return respuesta;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> crearTitularJuridico(TitularJuridicoDto titularJuridico) {
        ResponseEntity<?> respuesta = null;
        try {
            service.crearTitularJuridico(titularJuridico);
            respuesta = respuestaCreadoConExito();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error creando el titular");
        }
        return respuesta;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> actualizarTitularFisico(TitularFisicoDto titularFisico) {
        ResponseEntity<?> respuesta = null;
        try {
            service.actualizarTitularFisico(titularFisico);
            respuesta = respuestaVacia();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error actualizando el titular");
        }
        return respuesta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<?> actualizarTitularJuridico(TitularJuridicoDto titularJuridico) {
        ResponseEntity<?> respuesta = null;
        try {
            service.actualizarTitularJuridico(titularJuridico);
            respuesta = respuestaVacia();
        } catch(CampoIncorrectoException exp) {
            respuesta = unprocessableEntity(exp.getMessage());
        } catch(Exception exp) {
            log(exp);
            respuesta = internalServerError("Se presentó un error actualizando el titular");
        }
        return respuesta;
    }
    
}
