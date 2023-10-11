package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
    int codigo,
    @NotNull
    //Revisar segun las reglas de negocio que ya ingresamos en la base de datos
    @Length(max = 200)
    String cedula,
    @NotNull
    String nombre,
    @NotNull
    Ciudad ciudad,
    @NotNull
    String telefono,
    @NotNull
    String password,
    @NotNull @Length(max = 30) @Email
    String correo,
    @NotNull
    Especialidad especialidad,
    @NotNull
    EstadoUsuario estadoCuenta,
    @NotNull
    String urlFoto,
    List<HorarioDTO> horario_dto
) {

}
