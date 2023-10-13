package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record DiaLibreDTO(
        @NotEmpty
        LocalDate fecha
) {
}
