package ProyectoFinal.dto;

import ProyectoFinal.model.enums.Especialidad;
import ProyectoFinal.model.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallesPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes


) {
}
