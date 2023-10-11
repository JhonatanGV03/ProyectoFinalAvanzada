package co.edu.uniquindio.clinica.dto.administrador;

import co.edu.uniquindio.clinica.model.enums.Especialidad;
import jakarta.validation.constraints.NotNull;

public record ItemMedicoDTO(
        @NotNull
        String cedula,
        @NotNull
        String nombre,
        @NotNull
        Especialidad especialidad
){
}
