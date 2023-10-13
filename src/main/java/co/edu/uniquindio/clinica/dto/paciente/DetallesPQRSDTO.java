package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record DetallesPQRSDTO(
        @Positive
        int codigo,
        @NotEmpty
        LocalDateTime fechaPQRS,
        @NotNull
        EstadoPQRS estadoPQRS,
        @NotEmpty
        LocalDateTime fechaCita,  //Revisar si se usa String o LocalDateTime
        @NotBlank @Length(max = 100)
        String nomMedico,
        @NotBlank @Length(max = 500)
        String motivoPQRS,
        @NotEmpty
        List<RespuestaDTO> mensajes

        ) {
}
