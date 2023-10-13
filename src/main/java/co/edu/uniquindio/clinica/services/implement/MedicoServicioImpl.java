package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServices {
    @Override
    public List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception {

    }

    @Override
    public List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        return null;
    }
}
