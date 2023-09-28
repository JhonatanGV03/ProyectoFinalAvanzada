package ProyectoFinal.services;

import ProyectoFinal.dto.NewPasswordDTO;
import ProyectoFinal.dto.RegistroRespuestaDTO;
import ProyectoFinal.dto.paciente.*;
import ProyectoFinal.dto.ItemPQRSDTO;

import java.util.List;

public interface PacienteServices {
    int registrarse(RegistroPacienteDTO paciente) throws Exception;

    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;

    int editarPerfil(int codigo, RegistroPacienteDTO pacienteDTO) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NewPasswordDTO newPassword) throws Exception;

    int agendarCita(RegistroCitaDTO registroCita) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;
    DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception;

    List<ItemCitaDTO> listarCitasPaciente() throws Exception;

    DetallesCitaDTO verDetalleCita(int codigo) throws Exception;

    void filtrarCitasPorFecha();  //??

    void filtrarCitasPorMedico();  //??

}
