package ProyectoFinal.dto;

import java.util.List;

public record MedicoDTO (
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
