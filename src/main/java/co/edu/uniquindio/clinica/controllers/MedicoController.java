package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicos")
public class MedicoController {
    private final MedicoServices medicoService;

    @GetMapping("/citasPendientes/{codigoMedico}/{dia}")
    List<ItemCitaMedicoDTO> listarCitasPendientes(@PathVariable int codigoMedico,@PathVariable LocalDate dia) throws Exception{
        medicoService.listarCitasPendientes(codigoMedico,dia);
        return null;
    }
    @PostMapping("/atencionCita")
    void atenderCita(@Valid @RequestBody RegistroConsultaDTO atencionMedica) throws Exception{
        medicoService.atenderCita(atencionMedica);
    }
    @GetMapping("/carga_Cita/{codigoCita}")
    public RegistroConsultaDTO cargarRegistro(@PathVariable int codigoCita) throws Exception{
        medicoService.cargarRegistro(codigoCita);
        return null;
    }
    @GetMapping("/cargaHistorialPaciente/{codigoPaciente}")
    List<ItemCitaHistorialDTO> listarHistorialPaciente(@PathVariable int codigoPaciente) throws Exception{
        medicoService.listarHistorialPaciente(codigoPaciente);
        return null;
    }
    @PostMapping("/agendarDiaLibre/{codigoMedico}")
    int agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO,@PathVariable int codigoMedico) throws Exception{
        medicoService.agendarDiaLibre(diaLibreDTO,codigoMedico);
        return 0;
    }
    @GetMapping("/citasRealizadas/{codigoMedico}")
    List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(@PathVariable int codigoMedico) throws Exception{
        medicoService.listarCitasRealizadasMedico(codigoMedico);
        return null;
    }
}
