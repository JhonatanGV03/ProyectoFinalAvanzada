package ProyectoFinal.dto;

import java.util.List;

public record DetallesMedicoDTO(
        String cedula,
        String nombre,
        String ciudad,
        String telefono,
        String correo,
        String especialidad,
        List<HorarioDTO> horario_dto
) {
}
