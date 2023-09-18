package ProyectoFinal.dto;

import ProyectoFinal.model.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitasAdminDTO(
        int codigo,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}
