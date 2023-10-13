package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

public record RegistroCitaDTO(
        @NotNull
        Especialidad especialidad,
        @NotBlank @Length(max = 100)
        String medico,
        @NotEmpty
        LocalDate fecha,
        @NotEmpty
        LocalTime hora,
        @NotBlank @Length(max = 500)
        String motivoConsulta
) {
}
