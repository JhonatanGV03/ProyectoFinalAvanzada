package ProyectoFinal.dto.administrador;

import ProyectoFinal.dto.HorarioDTO;

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
