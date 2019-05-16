package coop.tecso.examen.titularescuentasapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Representación de la tabla TITULAR
 * @author Cristian
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Titular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cuit;
    
    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoTitular tipo;
    
    private boolean habilitado;
    
    public Titular() {
        super();
        tipo = new TipoTitular();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public TipoTitular getTipo() {
        return tipo;
    }

    public void setTipo(TipoTitular tipo) {
        this.tipo = tipo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
