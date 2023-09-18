package ProyectoFinal.dto;

import ProyectoFinal.model.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record PQRSAdminDTO (
        int codigo,
        String tipo,
        LocalDateTime fecha,
        EstadoPQRS estadoPQRS
){
}
