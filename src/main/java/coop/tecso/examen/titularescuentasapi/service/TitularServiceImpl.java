package coop.tecso.examen.titularescuentasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.titularescuentasapi.dto.TitularDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;
import coop.tecso.examen.titularescuentasapi.model.TipoTitular;
import coop.tecso.examen.titularescuentasapi.model.Titular;
import coop.tecso.examen.titularescuentasapi.model.TitularFisico;
import coop.tecso.examen.titularescuentasapi.model.TitularJuridico;
import coop.tecso.examen.titularescuentasapi.repository.TipoTitularRepository;
import coop.tecso.examen.titularescuentasapi.repository.TitularRepository;
import coop.tecso.examen.titularescuentasapi.util.Conversor;
import coop.tecso.examen.titularescuentasapi.util.Validador;

@Service
public class TitularServiceImpl implements TitularService {
    
    @Autowired
    private TitularRepository titularDao;
    
    @Autowired
    private TipoTitularRepository tipoTitularDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TitularDto> listarTitularesActivos() {
        List<TitularDto> listadoTitulares = new ArrayList<>();
        try {
            listadoTitulares = titularDao.findByHabilitado(true)
                                         .stream()
                                         .map(titular -> Conversor.convetirADto(titular))
                                         .collect(Collectors.toList());
        } catch(Exception exp) {
            throw new TitularServiceException("Error listando los titulares", exp);
        }
        return listadoTitulares;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitularDto buscarPorCuit(String cuitSinGuiones) {
        TitularDto dto = null;
        try {
            String cuit = Conversor.convertirACuitConGuiones(cuitSinGuiones);
            Titular entity = titularDao.findByCuitAndHabilitado(cuit, true);
            
            if(entity == null || !entity.isHabilitado()) {
                throw new CampoIncorrectoException(String.format("El titular con CUIT %s no existe", cuit));
            }
            
            dto = Conversor.convetirADto(entity);
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error buscando el titular", exp);
        }
        return dto;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean inhabilitarTitular(String cuitSinGuiones) {
        boolean inhabilitado = false;
        try {
            String cuit = Conversor.convertirACuitConGuiones(cuitSinGuiones);
            Titular entity = titularDao.findByCuitAndHabilitado(cuit, true); 
            
            if(entity == null || !entity.isHabilitado()) {
                throw new CampoIncorrectoException(String.format("El titular con CUIT %s no existe", cuit));
            }
            
            entity.setHabilitado(false);
            titularDao.save(entity);
            inhabilitado = true;
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error inhabilitando el titular", exp);
        }
        return inhabilitado;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public void crearTitularFisico(TitularFisicoDto titularFisico) {
        try {
            
            List<String> validaciones = Validador.validarTitularFisico(titularFisico);
            if(!validaciones.isEmpty()) {
                throw new CampoIncorrectoException(validaciones.get(0));
            }
            
            Titular titular = titularDao.findByCuitAndHabilitado(titularFisico.getCuit(), true);
            if(titular != null && titular.isHabilitado()) {
                throw new CampoIncorrectoException("Ya existe un titular registrado con el CUIT " + titular.getCuit());
            } 
            
            Titular entity = titularFisico.toEntity();
            entity.setTipo( getTipoTitularFisico() );
            entity.setHabilitado(true);
            titularDao.save(entity);
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error creando el titular fisico", exp);
        }
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void crearTitularJuridico(TitularJuridicoDto titularJuridico) {
        try {
            List<String> validaciones = Validador.validarTitularJuridico(titularJuridico);
            if(!validaciones.isEmpty()) {
                throw new CampoIncorrectoException(validaciones.get(0));
            }
            
            Titular titular = titularDao.findByCuitAndHabilitado(titularJuridico.getCuit(), true);
            if(titular != null && titular.isHabilitado()) {
                throw new CampoIncorrectoException("Ya existe un titular registrado con el CUIT " + titular.getCuit());
            } 

            TitularJuridico entity = titularJuridico.toEntity();
            entity.setTipo( getTipoTitularJuridico() );
            entity.setHabilitado(true);
            titularDao.save(entity);
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error creando el titular juridico", exp);
        }
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarTitularFisico(TitularFisicoDto titularFisico) {
        try {
            
            List<String> validaciones = Validador.validarTitularFisico(titularFisico);
            if(!validaciones.isEmpty()) {
                throw new CampoIncorrectoException(validaciones.get(0));
            }
            
            Titular titular = titularDao.findByCuitAndHabilitado(titularFisico.getCuit(), true); 
            if(titular == null) {
                throw new CampoIncorrectoException("No existe un titular registrado con el CUIT " + titularFisico.getCuit());
            }
            
            TitularFisico entity = (TitularFisico) titular;
            entity.setNombre(titularFisico.getNombre().toUpperCase());
            entity.setApellido(titularFisico.getApellido().toUpperCase());
            
            titularDao.save(entity);
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error actualizando el titular fisico", exp);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarTitularJuridico(TitularJuridicoDto titularJuridico) {
        try {
            
            List<String> validaciones = Validador.validarTitularJuridico(titularJuridico);
            if(!validaciones.isEmpty()) {
                throw new CampoIncorrectoException(validaciones.get(0));
            }
            
            Titular titular = titularDao.findByCuitAndHabilitado(titularJuridico.getCuit(), true);
            if(titular == null) {
                throw new CampoIncorrectoException("No existe un titular registrado con el CUIT " + titularJuridico.getCuit());
            }
            
            TitularJuridico entity = (TitularJuridico) titular;
            entity.setRazonSocial(titularJuridico.getRazonSocial().toUpperCase());
            entity.setAnioFundacion(titularJuridico.getAnioFundacion());
            
            titularDao.save(entity);
            
        } catch(CampoIncorrectoException exp) {
            throw exp;
        } catch(Exception exp) {
            throw new TitularServiceException("Error actualizando el titular juridico", exp);
        }
    }
    
    private TipoTitular getTipoTitularFisico() {
        return tipoTitularDao.findByNombre("FISICO");
    }
    
    private TipoTitular getTipoTitularJuridico() {
        return tipoTitularDao.findByNombre("JURIDICO");
    }

}
