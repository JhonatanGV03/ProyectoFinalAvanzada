package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServices {
    @Override
    public int registrarse(RegistroPacienteDTO paciente) throws Exception {
        return 0;
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int editarPerfil(int codigo, DetallePacienteDTO pacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public void eliminarCuenta(int codigoPaciente) throws Exception {

    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NewPasswordDTO newPassword) throws Exception {

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCita) throws Exception {
        return 0;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente() throws Exception {
        return null;
    }

    @Override
    public DetallesCitaDTO verDetalleCita(int codigo) throws Exception {
        return null;
    }

    @Override
    public void filtrarCitasPorFecha() {

    }

    @Override
    public void filtrarCitasPorMedico() {

    }
}
