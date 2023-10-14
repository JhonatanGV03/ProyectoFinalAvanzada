package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.medico.RegistroConsultaDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaMedicoDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaHistorialDTO;
import co.edu.uniquindio.clinica.dto.medico.ItemCitaRealizadaDTO;

import java.util.List;

public interface MedicoServices {

    List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception;
    List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}