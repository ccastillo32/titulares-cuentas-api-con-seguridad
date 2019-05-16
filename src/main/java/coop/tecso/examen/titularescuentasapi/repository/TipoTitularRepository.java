package coop.tecso.examen.titularescuentasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.titularescuentasapi.model.TipoTitular;

/**
 * Dao manejador de la tabla TIPO_TITULAR
 * @author Cristian
 *
 */

@Repository
public interface TipoTitularRepository extends JpaRepository<TipoTitular, Integer>{

    public TipoTitular findByNombre(String nombre);
    
}
