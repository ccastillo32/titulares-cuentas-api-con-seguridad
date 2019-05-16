package coop.tecso.examen.titularescuentasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.titularescuentasapi.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    public Rol findByNombre(String nombre);
    
}
