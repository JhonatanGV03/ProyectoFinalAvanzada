package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.classes.Cita;
import co.edu.uniquindio.clinica.model.enums.TipoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RegistroPQRSDTO(
        @Positive
        int codigoCita,
        @Positive
        int codigoPaciente,
        @NotBlank @Length(max = 500)
        String mensaje,
        @NotNull
        TipoPQRS tipoPQRS

) {
}
