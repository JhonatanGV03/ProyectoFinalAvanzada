package ProyectoFinal.dto.medico;

import ProyectoFinal.model.enums.Especialidad;

import java.util.Date;

public record ItemCitaDTO(
        String nombreMedico,
        Date fecha,
        Especialidad especialidad,
        String motivoConsulta,
        String diagnosticoMedico,
        String notasMedico,
        String tratamientoMedico
) {
}
