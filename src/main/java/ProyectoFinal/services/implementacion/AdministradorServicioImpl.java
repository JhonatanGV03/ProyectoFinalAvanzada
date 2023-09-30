package ProyectoFinal.services.implementacion;

import ProyectoFinal.dto.ItemPQRSDTO;
import ProyectoFinal.dto.administrador.DetallesPQRSDTO;
import ProyectoFinal.dto.RegistroRespuestaDTO;
import ProyectoFinal.dto.administrador.*;
import ProyectoFinal.model.classes.Medico;
import ProyectoFinal.model.enums.Ciudad;
import ProyectoFinal.model.enums.Especialidad;
import ProyectoFinal.model.enums.EstadoUsuario;
import ProyectoFinal.repositories.MedicoRepository;
import ProyectoFinal.services.AdministradorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServices {

    private final MedicoRepository medicoRepository;

    @Override
    public int crearMedico(RegistroMedicoDTO medico) throws Exception {

        Medico medicoNuevo = new Medico();
        medicoNuevo.setEstadoCuenta(EstadoUsuario.ACTIVO);
        medicoNuevo.setNombre( medico.nombre());
        medicoNuevo.setCedula(medico.cedula());
        medicoNuevo.setCodigoCiudad(Ciudad.values()[medico.ciudad()]);
        medicoNuevo.setTelefono(medico.telefono());
        medicoNuevo.setUrlFoto(medico.urlFoto());
        medicoNuevo.setCodigoEspecialidad(Especialidad.values()[medico.especialidad()]);
        medicoNuevo.setEstadoCuenta(EstadoUsuario.ACTIVO);

        medicoNuevo.setCorreo(medico.correo());
        medicoNuevo.setPassword(medico.password());

        if(estaRepetidoCorreo(medico.correo())){
            throw new Exception("El correo ya esta registrado");
        }

        if(estaRepetidoCedula(medico.cedula())){
            throw new Exception("La cedula ya esta registrada");
        }

        Medico medicoRegistrado = medicoRepository.save(medicoNuevo);
        return medicoRegistrado.getCodigoCuenta();
    }

    private boolean estaRepetidoCorreo(String correo) {
         medicoRepository.buscarPorCorreo(correo);

    }

    private boolean estaRepetidoCedula(String cedula){
        medicoRepository.buscarPorCedula(cedula);
    }

    @Override
    public int actualizarmedico(int codigo, RegistroMedicoDTO medicoDTO) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe el medico");
        }
        return 0;
    }

    @Override
    public void eliminarmedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe el medico");
        }



    }

    @Override
    public List<ItemMedicoDTO> listarmedicos() {
        List<Medico> medicos = medicoRepository.findAll();

        List<ItemMedicoDTO> respuesta = medicos.stream().map(medico -> new ItemMedicoDTO(
                medico.getCodigoCuenta(),
                medico.getNombre(),
                medico.getCedula(),
                medico.getEspecialidad(),
                medico.getUrlFoto()
        )).toList();

        return medicos;
    }

    @Override
    public DetallesMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);
        if (opcional.isEmpty()){
            throw new Exception("No existe el medico");
        }
        Medico buscado = opcional.get();

        return new DetallesMedicoDTO( //Quedó mal :C
                buscado.getCodigoCuenta(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getTelefono(),
                buscado.getEspecialidad(),
                buscado.getEstadoCuenta(),
                buscado.getCorreo()
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception {
        return 0;
    }

    @Override
    public DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> listarCitas() {
        return null;
    }
}
