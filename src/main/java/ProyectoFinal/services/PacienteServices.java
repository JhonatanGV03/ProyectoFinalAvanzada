package ProyectoFinal.services;

import ProyectoFinal.dto.NewPasswordDTO;
import ProyectoFinal.dto.administrador.ItemPQRSDTO;
import ProyectoFinal.dto.paciente.DetallePacienteDTO;
import ProyectoFinal.dto.paciente.RegistroCitaDTO;
import ProyectoFinal.dto.paciente.RegistroPQRSDTO;

import java.util.List;

public interface PacienteServices {
    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;
    void registrarse();

    void editarPerfil();

    void eliminarCuenta();

    void enviarLinkRecuperacion(String email);

    void cambiarPassword(NewPasswordDTO newPassword) throws Exception;

    int agendarCita(RegistroCitaDTO registroCita) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    void responderPQRS();

    void listarCitasPaciente();

    void filtrarCitasPorFecha();

    void filtrarCitasPorMedico();

    void verDetalleCita();
}
