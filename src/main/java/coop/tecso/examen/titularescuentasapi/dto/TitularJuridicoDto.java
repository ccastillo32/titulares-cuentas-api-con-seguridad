package coop.tecso.examen.titularescuentasapi.dto;

import coop.tecso.examen.titularescuentasapi.model.Titular;
import coop.tecso.examen.titularescuentasapi.model.TitularJuridico;

public class TitularJuridicoDto extends TitularDto {
    
    private String razonSocial;
    
    private Integer anioFundacion;
    
    public TitularJuridicoDto() {
        super();
    }

    public TitularJuridicoDto(String cuit, String razonSocial, Integer anioFundacion) {
        super();
        this.razonSocial = razonSocial;
        this.anioFundacion = anioFundacion;
    }
    
    /**
     * Constructor para pasar de entidad a DTO.
     * @param titular
     */
    public TitularJuridicoDto(Titular titular) {
        TitularJuridico entity = (TitularJuridico) titular;
        setCuit(entity.getCuit());
        razonSocial = entity.getRazonSocial();
        anioFundacion = entity.getAnioFundacion();
        setTipo(TitularDto.JURIDICO);
    }

    public TitularJuridico toEntity() {
        TitularJuridico entity = new TitularJuridico();
        entity.setCuit(getCuit());
        entity.setRazonSocial(razonSocial.toUpperCase());
        entity.setAnioFundacion(anioFundacion);
        return entity;
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
