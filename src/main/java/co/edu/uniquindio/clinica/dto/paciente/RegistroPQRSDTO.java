package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RegistroPQRSDTO(
        @NotEmpty
        LocalDateTime fechaCita,
        @NotBlank @Length(max = 100)
        String nomMedico,
        @NotBlank @Length(max = 500)
        String mensaje
) {
}
