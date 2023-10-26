package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoServices medicoService;

    List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico, LocalDate dia) throws Exception{
        return null;
    }
    void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception{

    }
    public RegistroConsultaDTO cargarRegistro(int codigoCita) throws Exception{
        return null;
    }
    List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception{
        return null;
    }
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception{
        return 0;
    }
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception{
        return null;
    }
}
