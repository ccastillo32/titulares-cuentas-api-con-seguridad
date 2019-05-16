package coop.tecso.examen.titularescuentasapi.util;

import coop.tecso.examen.titularescuentasapi.dto.TitularDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularFisicoDto;
import coop.tecso.examen.titularescuentasapi.dto.TitularJuridicoDto;
import coop.tecso.examen.titularescuentasapi.model.Titular;
import coop.tecso.examen.titularescuentasapi.service.TitularServiceException;

public class Conversor {
    
    public static TitularDto convetirADto(Titular entity) {
        TitularDto dto = null;
        switch(entity.getTipo().getNombre()) {
            case "FISICO": 
                dto = new TitularFisicoDto(entity);
                break;
            case "JURIDICO": 
                dto = new TitularJuridicoDto(entity);
                break;
            default: 
                throw new TitularServiceException("El tipo del titular no es reconocido");
        }
        return dto;
    }
    
    /**
     * Si la entrada es 20123456789 devuelve 20-12345678-9
     * @param cuitSinGuiones
     */
    public static String convertirACuitConGuiones(String cuitSinGuiones) {
        return new StringBuilder(cuitSinGuiones)
                .insert(2, "-")
                .insert(cuitSinGuiones.length(), "-")
                .toString();
    }

}
