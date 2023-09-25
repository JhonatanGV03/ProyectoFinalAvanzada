package ProyectoFinal.dto.administrador;

import ProyectoFinal.model.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        String tipo,
        LocalDateTime fecha,
        EstadoPQRS estadoPQRS
){
}
