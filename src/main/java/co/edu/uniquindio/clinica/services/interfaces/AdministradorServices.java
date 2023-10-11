package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.administrador.ItemCitaDTO;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;

import java.util.List;

public interface AdministradorServices {
    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarmedico(RegistroMedicoDTO medicoDTO) throws Exception;

    void eliminarmedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarmedicos() throws Exception;

    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception;

    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

}
