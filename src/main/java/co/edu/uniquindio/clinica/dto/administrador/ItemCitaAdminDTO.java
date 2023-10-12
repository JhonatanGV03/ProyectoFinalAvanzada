package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record ItemCitaAdminDTO(
        @NotNull
        int codigo,
        @NotNull
        EstadoCita estadoCita,
        @NotNull
        LocalDateTime fecha
) {
}
