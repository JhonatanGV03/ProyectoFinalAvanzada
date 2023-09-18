package ProyectoFinal.services;

import ProyectoFinal.dto.AtencionMedicaDTO;
import ProyectoFinal.dto.CitaMedicoDTO;
import ProyectoFinal.dto.DiaLibreDTO;
import org.hibernate.jdbc.Expectation;

import java.util.List;

public interface MedicoServices {

    List<CitaMedicoDTO> listarCitasPendientes(int codigo) throws Exception;
    void atenderCita(AtencionMedicaDTO atencionMedica) throws Exception;
    List<CitaMedicoDTO> listarCitasPaciente(int codigoPaciente) throws Exception;
    void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    List<CitaMedicoDTO> listarCitasRealizadasMedico() throws Exception;
}
