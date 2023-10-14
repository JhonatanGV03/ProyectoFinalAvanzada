package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;

import java.util.List;

public interface PacienteServices {
    int registrarse(RegistroPacienteDTO paciente) throws Exception;

    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;

    int editarPerfil(int codigo, DetallePacienteDTO pacienteDTO) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NewPasswordDTO newPasswordDTO) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;
    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaDTO> listarCitasPaciente() throws Exception;

    DetallesCitaDTO verDetalleCita(int codigo) throws Exception;

    void filtrarCitasPorFecha();  //??

    void filtrarCitasPorMedico();  //??

}
