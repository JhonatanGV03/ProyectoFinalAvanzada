package ProyectoFinal.dto.administrador;

import ProyectoFinal.model.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigo,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}
