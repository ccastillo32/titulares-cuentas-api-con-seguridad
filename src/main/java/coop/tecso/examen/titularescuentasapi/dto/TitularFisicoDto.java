package coop.tecso.examen.titularescuentasapi.dto;

import coop.tecso.examen.titularescuentasapi.model.Titular;
import coop.tecso.examen.titularescuentasapi.model.TitularFisico;

public class TitularFisicoDto extends TitularDto {
    
    private String dni;
    
    private String nombre;
    
    private String apellido;
    
    public TitularFisicoDto() {
        super();
    }

    public TitularFisicoDto(String cuit, String dni, String nombre, String apellido) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public TitularFisicoDto(Titular titular) {
        TitularFisico entity = (TitularFisico) titular;
        setCuit(entity.getCuit());
        dni = entity.getDni();
        nombre = entity.getNombre();
        apellido = entity.getApellido();
        setTipo(TitularDto.FISICO);
    }
    
    public TitularFisico toEntity() {
        TitularFisico entity = new TitularFisico();
        entity.setCuit(getCuit());
        entity.setDni(dni);
        entity.setNombre(nombre.toUpperCase());
        entity.setApellido(apellido.toUpperCase());
        return entity;
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
