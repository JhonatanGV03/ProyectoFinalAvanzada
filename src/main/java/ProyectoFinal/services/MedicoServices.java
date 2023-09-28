package ProyectoFinal.services;

import ProyectoFinal.dto.medico.RegistroAtencionDTO;
import ProyectoFinal.dto.medico.ItemCitaDTO;
import ProyectoFinal.dto.medico.DiaLibreDTO;
import ProyectoFinal.dto.medico.ItemCitaHistorialDTO;
import ProyectoFinal.dto.medico.ItemCitaRealizadaDTO;

import java.util.List;

public interface MedicoServices {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    void atenderCita(RegistroAtencionDTO atencionMedica) throws Exception;
    List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}
