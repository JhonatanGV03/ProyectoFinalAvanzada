package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.EPS;
import co.edu.uniquindio.clinica.model.enums.TipoSangre;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RegistroPacienteDTO (
        @NotBlank @Length(max = 20)
        String cedula,
        @NotBlank @Email @Length(max = 50)
        String correo,
        @NotBlank
        String password,
        @NotBlank @Length(max = 100)
        String nombre,
        @NotBlank @Length(max = 10)
        String telefono,
        @NotNull
        Ciudad ciudad,
        @NotEmpty @Past
        LocalDate fechaNacimiento,
        @NotBlank @Length(max = 250)
        String alergias,
        @NotNull
        EPS eps,
        @NotNull
        TipoSangre tipoSangre,
        @NotBlank
        String urlFoto

){
}