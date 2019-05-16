package coop.tecso.examen.titularescuentasapi.dto;

public abstract class TitularDto {

    public static final String FISICO = "FISICO";
    public static final String JURIDICO = "JURIDICO";
    
    private String cuit;
    private String tipo;

    public TitularDto() {
        super();
    }

    public TitularDto(String cuit) {
        super();
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
