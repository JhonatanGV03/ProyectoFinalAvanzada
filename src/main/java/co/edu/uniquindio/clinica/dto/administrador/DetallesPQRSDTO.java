package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record DetallesPQRSDTO(
        //Seccion PQRS
        @NotNull
        int codigo,
        @NotNull
        EstadoPQRS estadoPQRS,
        @NotNull
        LocalDateTime fechaPQRS,

        //Seccion mensajes
        @NotNull
        String motivoPQRS,
        List<RespuestaDTO> mensajes,

        //Seccion Paciente
        @NotNull
        String nombrePaciente,
        @NotNull
        String cedulaPaciente,
        @NotNull @Length(max = 50) @Email
        String emailPaciente,


        //Seccion Cita Asociada
        @NotNull
        String nombreMedico,
        @NotNull
        Especialidad especialidad,
        @NotNull
        LocalDateTime fechaCita,
        @NotNull
        EstadoCita estadoCita,
        @NotNull
        String motivoCita,
        @NotNull
        String notasMedico,
        @NotNull
        String diagnostico,
        @NotNull
        String tratamiento
) {
}
