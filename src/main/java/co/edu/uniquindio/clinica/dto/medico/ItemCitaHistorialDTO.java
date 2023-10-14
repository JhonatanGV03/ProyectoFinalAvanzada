package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record ItemCitaHistorialDTO( //Item cita del historial medico del paciente
        @NotEmpty
        LocalDate fechaAtencion,
        @NotBlank @Length(max = 100)
        String nomMedico,
        @NotNull
        Especialidad especialidad
) {
}
