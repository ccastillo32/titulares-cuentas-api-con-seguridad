package coop.tecso.examen.titularescuentasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.titularescuentasapi.model.Titular;

/**
 * Dao manejador de la tabla TITULAR, TITULAR_JURIDICO y TITULAR_FISICO
 * @author Cristian
 *
 */

@Repository
public interface TitularRepository extends JpaRepository<Titular, String> {

    public List<Titular> findByHabilitado(boolean habilitado);
    public Titular findByCuitAndHabilitado(String cuit, boolean habilitado);
    
}
