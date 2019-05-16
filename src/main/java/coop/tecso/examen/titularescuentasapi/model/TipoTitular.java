package coop.tecso.examen.titularescuentasapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representación de la tabla TIPO_TITULAR
 * @author Cristian
 *
 */

@Entity
@Table(name = "TIPO_TITULAR")
public class TipoTitular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    
    private String nombre;
    
    private boolean habilitado;
    
    public TipoTitular() {
        
    }

    public TipoTitular(Integer id, String nombre, boolean habilitado) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
}
