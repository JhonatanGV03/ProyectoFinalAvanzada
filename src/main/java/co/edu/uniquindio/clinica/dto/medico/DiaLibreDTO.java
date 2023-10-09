package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record DiaLibreDTO(
        @NotNull
        Date fecha
) {
}
