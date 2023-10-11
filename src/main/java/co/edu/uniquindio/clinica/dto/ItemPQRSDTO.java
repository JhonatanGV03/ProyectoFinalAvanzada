package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/*
REVISAR LOS ATRIBUTOS QUE VA A TENER ESTE ITEM
 */
public record ItemPQRSDTO(
        @NotNull
        int codigo,  //Radicado
        //String tipo,
        @NotNull
        Date fecha,
        @NotNull
        EstadoPQRS estadoPQRS
){
}
