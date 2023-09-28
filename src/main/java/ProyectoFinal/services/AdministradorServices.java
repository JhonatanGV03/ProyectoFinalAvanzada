package ProyectoFinal.services;

import ProyectoFinal.dto.administrador.*;
import ProyectoFinal.dto.RegistroRespuestaDTO;
import ProyectoFinal.dto.administrador.ItemCitaDTO;
import ProyectoFinal.dto.ItemPQRSDTO;

import java.util.List;

public interface AdministradorServices {
    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarmedico(int codigo, RegistroMedicoDTO medicoDTO) throws Exception;

    void eliminarmedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarmedicos() throws Exception;

    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception;

    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

}
