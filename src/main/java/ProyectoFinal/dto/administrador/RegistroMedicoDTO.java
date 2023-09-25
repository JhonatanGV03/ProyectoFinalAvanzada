package ProyectoFinal.dto.administrador;

import ProyectoFinal.dto.HorarioDTO;

import java.util.List;

public record RegistroMedicoDTO(
    String cedula,
    String nombre,
    String ciudad,
    String telefono,
    String password,
    String correo,
    String especialidad,
    List<HorarioDTO> horario_dto
) {

}
