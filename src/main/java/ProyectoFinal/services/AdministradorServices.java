package ProyectoFinal.services;

import ProyectoFinal.dto.*;
import ProyectoFinal.dto.administrador.ItemCitaDTO;
import ProyectoFinal.dto.administrador.ItemMedicoDTO;
import ProyectoFinal.dto.administrador.ItemPQRSDTO;
import ProyectoFinal.dto.RegistroRespuestaDTO;
import ProyectoFinal.dto.administrador.DetallesMedicoDTO;
import ProyectoFinal.dto.administrador.RegistroMedicoDTO;

import java.util.List;

public interface AdministradorServices {
    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarmedico(int codigo, RegistroMedicoDTO medicoDTO) throws Exception;

    void eliminarmedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarmedicos();

    DetallesMedicoDTO obtenerMedico(int codigo);

    List<ItemPQRSDTO> listarPQRS();

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception;

    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    List<ItemCitaDTO> listarCitas();

}
