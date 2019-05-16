package coop.tecso.examen.titularescuentasapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representación de la tabla TITULAR_JURIDICO
 * @author Cristian
 *
 */

@Entity
@Table(name = "TITULAR_JURIDICO")
@PrimaryKeyJoinColumn(name = "titular_id")
public class TitularJuridico extends Titular {

    private static final long serialVersionUID = 1L;

    @Column(name = "razon_social")
    private String razonSocial;
    
    @Column(name = "anio_fundacion")
    private Integer anioFundacion;
    
    public TitularJuridico() {
        super();
    }

    public TitularJuridico(String razonSocial, Integer anioFundacion) {
        super();
        this.razonSocial = razonSocial;
        this.anioFundacion = anioFundacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(Integer anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

}
