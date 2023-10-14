package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @NotBlank @Length(max = 500)
        String mensaje,
        @NotEmpty
        LocalDateTime fechaMensaje
) {

}
