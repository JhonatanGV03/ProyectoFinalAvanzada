package ProyectoFinal.dto.administrador;

import ProyectoFinal.dto.HorarioDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record DetallesMedicoDTO(
        @NotNull @Length(max = 50)
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        int ciudad,
        @NotNull
        String telefono,
        @NotNull @Length(max = 40) @Email
        String correo,
        @NotNull
        int especialidad,
        List<HorarioDTO> horario_dto
) {
}
