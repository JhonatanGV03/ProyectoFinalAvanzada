package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.administrador.*;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;

import co.edu.uniquindio.clinica.model.classes.*;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServices {

    private final MedicoRepository medicoRepo;
    private final PQRSRepository pqrsRepo;
    private final CuentaRepository cuentaRepo;
    private final MensajeRepository mensajeRepo;
    private final CitaRepository citaRepo;
    private final HorarioRepository horarioRepo;


    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if( estaRepetidaCedula(medicoDTO.cedula()) ){
            throw new Exception("La cédula "+medicoDTO.cedula()+" ya está en uso");
        }

        if( estaRepetidoCorreo(medicoDTO.correo()) ){
            throw new Exception("El correo "+medicoDTO.cedula()+" ya está en uso");
        }

        Medico medico = new Medico();

        medico.setNombre(medicoDTO.nombre() );
        medico.setCedula(medicoDTO.cedula() );
        medico.setCiudad(medicoDTO.ciudad());
        medico.setEspecialidad( medicoDTO.especialidad() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setCorreo(medicoDTO.correo() );
        medico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setEstado(EstadoUsuario.ACTIVO);

        Medico medicoNuevo = medicoRepo.save(medico);

        asignarHorariosMedico(medico, medicoDTO.horarios());

        return medicoNuevo.getCodigo();

    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios) {

        for( HorarioDTO h : horarios ){

            Horario hm = new Horario();
            hm.setDia( h.dia() );
            hm.setHoraInicio( h.horaInicio() );
            hm.setHoraFin( h.horaFin() );
            hm.setMedico( medicoNuevo );

            horarioRepo.save(hm);

        }

    }


    @Override
    public int actualizarmedico(DetallesMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setNombre(medicoDTO.nombre() );
        buscado.setCedula(medicoDTO.cedula() );
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setEspecialidad( medicoDTO.especialidad() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setCorreo(medicoDTO.correo() );
        buscado.setUrlFoto(medicoDTO.urlFoto());

        medicoRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarmedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        medicoRepo.save( buscado );


    }

    @Override
    public List<ItemMedicoDTO> listarmedicos() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        List<ItemMedicoDTO> respuesta = medicos.stream().map( m -> new ItemMedicoDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getEspecialidad()
        ) ).toList();

        return respuesta;
    }
    /*
    -----    Buscar como retornar los horarios del medico tambien   ------
     */
    @Override
    public DetallesMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional =medicoRepo.findById(codigo);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigo);
        }
        List<Horario> horarios = horarioRepo.findAllByMedicoCodigo(codigo);
        List<HorarioDTO> horariosDTO = new ArrayList<>();

        for( Horario h : horarios ){
            horariosDTO.add( new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicio(),
                    h.getHoraFin()
            ) );
        }

        Medico buscado = opcional.get();

        return new DetallesMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrlFoto(),
                horariosDTO
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( PQRS p: listaPqrs ){

            /*respuesta.add( new ItemPQRSDTO(
                    p.getCodigoPQRS(),
                    p.getEstado(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
            ) );*/

        }

        return respuesta;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuesta) throws Exception {
        Optional<PQRS> opcionalPQRS = pqrsRepo.findById(registroRespuesta.codPqrs());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuesta.codPqrs());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuesta.codCuenta());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuesta.codCuenta());
        }

        Mensaje referenciaMensaje = null;

        if(registroRespuesta.codMensaje() != -1) {

            Optional<Mensaje> opcionalMensaje = mensajeRepo.findById(registroRespuesta.codMensaje());

            if (opcionalMensaje.isEmpty()) {
                throw new Exception("No existe un mensaje con el código " + registroRespuesta.codMensaje());
            }

            referenciaMensaje = opcionalMensaje.get();

        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPQRS(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion( LocalDateTime.now() );
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setCodigo(registroRespuesta.codMensaje() );
        mensajeNuevo.setMensajeInt( referenciaMensaje );

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public DetallesPQRSAdminDTO verDetallesPQRS(int codigo) throws Exception {

        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        PQRS buscado = opcional.get();

        /*return new DetallesPQRSAdminDTO(
                buscado.getCodigo(),
                buscado.getEstado(),
                //new ArrayList<>()
        );*/
        return null;
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitas() throws Exception {
        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            respuesta.add( new ItemCitaAdminDTO(
                    c.getCodigoCita(),
                    c.getEstado(),
                    c.getFechaCreacion(),
                    c.getPaciente().getNombre()
            ) );
        }

        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {

        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un PQRS con el código "+codigoPQRS);
        }

        PQRS pqrs = opcional.get();
        pqrs.setEstado( estadoPQRS );

        pqrsRepo.save( pqrs );
    }
    /*
    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( Pqrs p: listaPqrs ){

            respuesta.add( new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
            ) );

        }

        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        Pqrs buscado = opcional.get();

        return new DetallePQRSDTO(
                buscado.getCodigo(),
                buscado.getEstado(),
                buscado.getMotivo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getFechaCreacion(),
                new ArrayList<>()
        );
    }


    */
}