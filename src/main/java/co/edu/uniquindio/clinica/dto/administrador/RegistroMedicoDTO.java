package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
        //Codigo no es necesario ya que es autogenerado
    @NotBlank @Length(max = 100)
    String nombre,
    @NotBlank
    @Length(max = 20)
    String cedula,
    @NotNull
    Ciudad ciudad,
    @NotNull
    Especialidad especialidad,
    @NotBlank @Length(max = 10)
    String telefono,
    @NotBlank @Length(max = 50) @Email
    String correo,
    @NotBlank
    String password,
    @NotBlank
    String urlFoto,
    @NotEmpty
    List<HorarioDTO> horarios
) {

}
