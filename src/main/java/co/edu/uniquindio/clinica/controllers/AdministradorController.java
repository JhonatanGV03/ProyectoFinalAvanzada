package co.edu.uniquindio.clinica.controllers;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdministradorController {
    private final AdministradorServices administradorService;

    void crearAdmin(RegistroAdminDTO admin) throws Exception{

    }
    int crearMedico(RegistroMedicoDTO medico) throws Exception{
        return 0;
    }

    int actualizarmedico(DetallesMedicoDTO medicoDTO) throws Exception{
        return 0;
    }

    void eliminarmedico(int codigo) throws Exception{

    }

    List<ItemMedicoDTO> listarmedicos() throws Exception{
        return null;
    }

    DetallesMedicoDTO obtenerMedico(int codigo) throws Exception{
        return null;
    }

    List<ItemPQRSDTO> listarPQRS() throws Exception{
        return null;
    }
    DetallesPQRSAdminDTO verDetallesPQRS(int codigo) throws Exception{
        return null;
    }

    int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception{
        return 0;
    }

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception{

    }
    List<ItemCitaAdminDTO> listarCitas() throws Exception{
        return null;
    }
}
