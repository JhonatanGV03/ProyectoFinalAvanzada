package co.edu.uniquindio.clinica.dto.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RegistroPacienteDTO (
        @NotNull
        String cedula,
        @NotNull @Email
        String email,
        @NotNull
        String contrasena,
        @NotNull
        String nombre,
        @NotNull
        String telefono,
        @NotNull
        int ciudad,
        @NotNull
        Date fechaNacimiento,
        @NotNull
        String alergias,
        @NotNull
        int eps,
        @NotNull
        int tipoSangre,
        @NotNull
        String urlFoto


){
}
