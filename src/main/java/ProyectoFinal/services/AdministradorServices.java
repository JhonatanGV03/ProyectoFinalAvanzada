package ProyectoFinal.services;

import ProyectoFinal.dto.*;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

import java.util.List;

public interface AdministradorServices {
    int crearMedico(MedicoDTO medico) throws Exception;

    int actualizarmedico(int codigo, MedicoDTO medicoDTO) throws Exception;

    String eliminarmedico(int codigo) throws Exception;

    List<InfoMedicoAdminDTO> listarmedicos();

    DetallesMedicoDTO obtenerMedico(int codigo);

    List<PQRSAdminDTO> listarPQRS();

    String responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;

    DetallesPQRSDTO verDetallesPQRS();

    List<CitasAdminDTO> listarCitas();

}
