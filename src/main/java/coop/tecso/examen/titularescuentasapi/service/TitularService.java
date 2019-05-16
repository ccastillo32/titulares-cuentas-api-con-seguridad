package coop.tecso.examen.titularescuentasapi.service;

import java.util.List;

import coop.tecso.examen.titularescuentasapi.dto.TitularDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;

/**
 * Realiza peticiones a la Base de datos, y hace las transformaciones a DTO correspondientes.
 * @author Cristian
 *
 */

public interface TitularService {
    
    /**
     * @return Obtiene la lista de titulares fisicos y juridicos
     */
    public List<TitularDto> listarTitularesActivos();

    
    /**
     * @return Busca un titular fisico o juridico por el CUIT
     */
    public TitularDto buscarPorCuit(String cuitSinGuiones);
    
    
    /**
     * Inhabilita un titular. Colocandolo en false, para simular su eliminacion.
     * @param cuitSinGuiones El Cuit del titular, sin guiones
     * @return true si lo inhabilita de manera exitosa
     */
    public boolean inhabilitarTitular(String cuitSinGuiones);
    
    
    /**
     * Crea un nuevo titular fisico
     * @param titularFisico
     */
    public void crearTitularFisico(TitularFisicoDto titularFisico);
    
    
    /**
     * Crea un nuevo titular juridico
     * @param titularJuridico
     */
    public void crearTitularJuridico(TitularJuridicoDto titularJuridico);
    
    
    /**
     * Actualiza el titular fisico
     * @param titularFisico
     */
    public void actualizarTitularFisico(TitularFisicoDto titularFisico);
    
    
    /**
     * Actualiza el titular juridico
     * @param titularFisico
     */
    public void actualizarTitularJuridico(TitularJuridicoDto titularJuridico);
    
}
