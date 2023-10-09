package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaHistorialDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaRealizadaDTO;

import java.util.List;

public interface MedicoServices {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    void atenderCita(RegistroAtencionDTO atencionMedica) throws Exception;
    List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}
