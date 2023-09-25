package ProyectoFinal.services;

import ProyectoFinal.dto.RegistroAtencionDTO;
import ProyectoFinal.dto.medico.ItemCitaDTO;
import ProyectoFinal.dto.medico.DiaLibreDTO;

import java.util.List;

public interface MedicoServices {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    void atenderCita(RegistroAtencionDTO atencionMedica) throws Exception;
    List<ItemCitaDTO> listarHistorialPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}
