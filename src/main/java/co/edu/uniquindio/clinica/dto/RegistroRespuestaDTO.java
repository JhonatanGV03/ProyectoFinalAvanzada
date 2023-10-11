package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;


public record RegistroRespuestaDTO(
        @NotNull
        int codRadicado, //Redicado ¿?
        @NotNull
        int codUsuario,
        @NotNull
        int codMensaje
){
}
