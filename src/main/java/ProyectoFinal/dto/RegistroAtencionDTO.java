package ProyectoFinal.dto;

import ProyectoFinal.model.enums.EPS;
import ProyectoFinal.model.enums.TipoSangre;

import java.time.LocalDateTime;

public record RegistroAtencionDTO(
        String codigoAtencion,
        LocalDateTime fechaAtencion,
        String motivoConsulta,
        String diagnosticoMedico,
        String notasMedico,
        String tratamientoMedico,
        String cedula,
        String nombre,
        String email,
        EPS eps,
        TipoSangre tipoSangre,
        String Alergias
) {
}
