package coop.tecso.examen.titularescuentasapi.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representacion de la tabla TITULAR_FISICO
 * @author Cristian
 *
 */

@Entity
@Table(name = "titular_fisico")
@PrimaryKeyJoinColumn(name = "titular_id")
public class TitularFisico extends Titular {

    private static final long serialVersionUID = 1L;

    private String dni;
    
    private String nombre;
    
    private String apellido;
    
    public TitularFisico() {
        super();
    }

    public TitularFisico(String dni, String nombre, String apellido) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
