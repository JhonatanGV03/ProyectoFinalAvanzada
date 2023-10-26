package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteServices pacienteService;

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO paciente) throws Exception{
        pacienteService.registrarse(paciente);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }

    @GetMapping("/detalles/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.verDetallePaciente(codigoPaciente)));
    }

    @PutMapping("/editar")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteService.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Perfil modificado correctamente"));
    }

    @DeleteMapping("/eliminar/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigoPaciente) throws Exception{
        pacienteService.eliminarCuenta(codigoPaciente);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cuenta eliminada correctamente"));
    }

    @GetMapping("/listar-pacientes")
    public ResponseEntity<MensajeDTO<List<ItemPacienteDTO>>> listarPacientes() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteService.listarPacientes()));
    }

    @PutMapping("/cambiar-password")
    public void cambiarPassword(@Valid @RequestBody NewPasswordDTO newPasswordDTO) throws Exception{
        pacienteService.cambiarPassword(newPasswordDTO);
    }

    @PostMapping("/crear-pqrs")
    public int crearPQRS(@Valid @RequestBody PQRSPacienteDTO PQRSPacienteDTO) throws Exception{
        return pacienteService.crearPQRS(PQRSPacienteDTO);
    }

    @GetMapping("/listar-pqrs/{codigoPaciente}")
    public List<ItemPQRSDTO> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception{
        return pacienteService.listarPQRSPaciente(codigoPaciente);
    }

    @GetMapping("/detalles-pqrs/{codigo}")
    public DetallesPQRSDTO verDetallesPQRS(@PathVariable int codigo) throws Exception{
        return pacienteService.verDetallesPQRS(codigo);
    }

    @PostMapping("/responder-pqrs") //Puede ser put
    public int responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        return pacienteService.responderPQRS(registroRespuestaDTO);
    }

    @PostMapping("/agendar-cita")
    public int agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        return pacienteService.agendarCita(registroCitaDTO);
    }

    @GetMapping("/detalles-cita/{codigo}")
    public DetallesCitaDTO verDetallesCita(@PathVariable int codigo) throws Exception{
        return pacienteService.verDetallesCita(codigo);
    }

    @GetMapping("/listar-citas/{codigoPaciente}")
    public List<ItemCitaDTO> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        return pacienteService.listarCitasPaciente(codigoPaciente);
    }

    @GetMapping("detalles-consulta/{codigo}")
    public DetallesConsultaDTO verDetalleConsulta(@PathVariable int codigo) throws Exception{
        return pacienteService.verDetalleConsulta(codigo);
    }

    @GetMapping("/listar-cita/{codigoPaciente}/{fecha}")  //No me convencen los nombres
    public List<ItemCitaDTO> filtrarCitasPacientePorFecha(@PathVariable LocalDate fecha,@PathVariable int codigoPaciente) throws Exception{
        return pacienteService.filtrarCitasPacientePorFecha(fecha,codigoPaciente);
    }

    @GetMapping("/listar-cita-medico/{codigoPaciente}/{codigoMedico}")
    public List<ItemCitaDTO> filtrarCitasPacientePorMedico(@PathVariable int codigoMedico,@PathVariable int codigoPaciente) throws Exception{
        return pacienteService.filtrarCitasPacientePorMedico(codigoMedico,codigoPaciente);
    }
}
