package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record DetallesPQRSAdminDTO(
        /*
        En este dto no estoy seguro, osea si necesitamos toda esta info segun el muckup
        pero si ve que se puede hacer de otra forma me dice y lo arreglo mejor
         */

        //Seccion PQRS
        @Positive
        int codigo,
        @NotNull
        EstadoPQRS estadoPQRS,
        @NotEmpty
        LocalDateTime fechaPQRS,

        //Seccion mensajes
        @NotBlank @Length(max = 500)
        String motivoPQRS,
        @NotEmpty
        List<RespuestaDTO> mensajes,

        //Seccion Paciente
        @NotBlank @Length(max = 100)
        String nombrePaciente,
        @NotBlank @Length(max = 20)
        String cedulaPaciente,
        @NotBlank @Length(max = 50) @Email
        String emailPaciente,


        //Seccion Cita Asociada
        @NotBlank @Length(max = 100)
        String nombreMedico,
        @NotNull
        Especialidad especialidad,
        @NotEmpty
        LocalDateTime fechaCita,
        @NotNull
        EstadoCita estadoCita,
        @NotBlank @Length(max = 500)
        String motivoCita,
        @NotBlank @Length(max = 500)
        String notasMedico,
        @NotBlank @Length(max = 500)
        String diagnostico,
        @NotBlank @Length(max = 500)
        String tratamiento
) {
}
