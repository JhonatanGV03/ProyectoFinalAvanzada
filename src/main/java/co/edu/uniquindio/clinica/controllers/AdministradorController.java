package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdministradorController {
    private final AdministradorServices administradorService;

    //Autenticacion¿?
    @PostMapping("/crearAdmin")
    void crearAdmin(RegistroAdminDTO admin) throws Exception{
        administradorService.crearAdmin(admin);
    }

    //Autenticacion¿?
    @PostMapping("/crearMedico")
    int crearMedico(RegistroMedicoDTO medico) throws Exception{
        administradorService.crearMedico(medico);
        return 0;
    }

    //Autenticacion¿?
    @PutMapping("/actualizarMedico")
    int actualizarmedico(DetallesMedicoDTO medicoDTO) throws Exception{
        administradorService.actualizarmedico(medicoDTO);
        return 0;
    }
    @DeleteMapping("/eliminarMedico/{codigo}")
    void eliminarmedico(int codigo) throws Exception{
        administradorService.eliminarmedico(codigo);
    }

    @GetMapping("/listarMedicos")
    List<ItemMedicoDTO> listarmedicos() throws Exception{
        administradorService.listarmedicos();
        return null;
    }

    @GetMapping("/verDetallesMedico/{codigo}")
    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception{
        administradorService.obtenerMedico(codigo);
        return null;
    }

    @GetMapping("/listarPQRS")
    List<ItemPQRSDTO> listarPQRS() throws Exception{
        administradorService.listarPQRS();
        return null;
    }
    @GetMapping("/verDetallesPQRS/{codigo}")
    DetallesPQRSAdminDTO verDetallesPQRS(int codigo) throws Exception{
        administradorService.verDetallesPQRS(codigo);
        return null;
    }

    @PostMapping("/responderPQRS")
    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception{
        administradorService.responderPQRS(registroRespuesta);
        return 0;
    }

    @PutMapping("/cambiarEstadoPQRS/{codigoPQRS}")
    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception{
        administradorService.cambiarEstadoPQRS(codigoPQRS,estadoPQRS);
    }

    @GetMapping("/listarCitas")
    List<ItemCitaAdminDTO> listarCitas() throws Exception{
        administradorService.listarCitas();
        return null;
    }
}
