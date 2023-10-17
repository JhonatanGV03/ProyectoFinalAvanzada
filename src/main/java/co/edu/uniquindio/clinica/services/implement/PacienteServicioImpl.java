package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.NewPasswordDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.model.classes.*;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.model.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServices {

    private final PacienteRepository pacienteRepo;
    private final CuentaRepository cuentaRepo;
    private final CitaRepository citaRepo;
    private final MedicoRepository medicoRepo;
    private final PQRSRepository pqrsRepo;
    private final MensajeRepository mensajeRepo;

    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        if (estaRepetidaCedula(pacienteDTO.cedula())) {
            throw new Exception("La cédula " + pacienteDTO.cedula() + " ya está en uso");
        }
        if( estaRepetidoCorreo(pacienteDTO.correo()) ){
            throw new Exception("El correo "+pacienteDTO.correo()+" ya está en uso");
        }

        Paciente paciente = new Paciente();


        paciente.setCedula(pacienteDTO.cedula());
        paciente.setCorreo(pacienteDTO.correo());
        paciente.setPassword(pacienteDTO.password());
        paciente.setNombre(pacienteDTO.nombre());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCiudad(pacienteDTO.ciudad());
        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setEPS(pacienteDTO.eps());
        paciente.setTipoSangre(pacienteDTO.tipoSangre());
        paciente.setUrlFoto(pacienteDTO.urlFoto());

        //Parte de encriptado
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( pacienteDTO.password() );
        paciente.setPassword( passwordEncriptada );

        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception {
        Optional<Paciente> opcional =pacienteRepo.findById(codigoPaciente);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigoPaciente);
        }

        Paciente buscado = opcional.get();


        return new DetallePacienteDTO(
                buscado.getCodigo(),
                buscado.getCedula(),
                buscado.getCorreo(),
                buscado.getNombre(),
                buscado.getPassword(),
                buscado.getTelefono(),
                buscado.getCiudad(),
                buscado.getFechaNacimiento(),
                buscado.getAlergias(),
                buscado.getEPS(),
                buscado.getTipoSangre(),
                buscado.getUrlFoto()
        );
    }

    @Override
    public int editarPerfil(int codigo, DetallePacienteDTO pacienteDTO) throws Exception {
        Optional<Paciente> opcional =pacienteRepo.findById(pacienteDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+pacienteDTO.codigo());
        }

        Paciente buscado = opcional.get();
        buscado.setCedula(pacienteDTO.cedula());
        buscado.setCorreo(pacienteDTO.correo());
        //buscado.setPassword(pacienteDTO.password());
        buscado.setNombre(pacienteDTO.nombre());
        buscado.setTelefono(pacienteDTO.telefono());
        buscado.setCiudad(pacienteDTO.ciudad());
        buscado.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        buscado.setAlergias(pacienteDTO.alergias());
        buscado.setEPS(pacienteDTO.eps());
        buscado.setTipoSangre(pacienteDTO.tipoSangre());
        buscado.setUrlFoto(pacienteDTO.urlFoto());

        //Parte de encriptado
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( pacienteDTO.password() );
        buscado.setPassword( passwordEncriptada );

        pacienteRepo.save( buscado );

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigoPaciente) throws Exception {
        Optional<Paciente> opcional =pacienteRepo.findById(codigoPaciente);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigoPaciente);
        }

        Paciente buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);
        pacienteRepo.save( buscado );
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NewPasswordDTO newPasswordDTO) throws Exception {
        Optional<Cuenta> opcionalCuenta = cuentaRepo.findByCorreo(newPasswordDTO.correo());

        if(opcionalCuenta.isEmpty()) {
            throw new Exception("No existe una cuenta con el correo " + newPasswordDTO.correo());
        }

        Cuenta cuenta = opcionalCuenta.get();
        if (newPasswordDTO.newPassword().equals(newPasswordDTO.confirmPassword())){
            cuenta.setPassword(newPasswordDTO.newPassword());
            cuentaRepo.save(cuenta);
        }else{
            throw new Exception("Las contraseñas no coinciden");
        }

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {

        List<Cita> citasPaciente = pacienteRepo.findById(registroCitaDTO.codigoPaciente()).get().getCita();
        Optional<Medico> medico = medicoRepo.findByNombre(registroCitaDTO.medico());
        Optional<Paciente> paciente = pacienteRepo.findById(registroCitaDTO.codigoPaciente());

        if (citasPaciente != null){
            for (Cita cita : citasPaciente) {
                if (cita.getFechaCita().equals(registroCitaDTO.fecha())){
                    throw new Exception("Ya existe una cita para el paciente " + paciente.get().getNombre() + " en la fecha " + registroCitaDTO.fecha());
                }
                if (cita.getMedico().equals(registroCitaDTO.medico())){
                    throw new Exception("Ya existe una cita con el médico " + registroCitaDTO.medico() + " en la fecha " + cita.getFechaCita());
                }
            }
        }
        Cita cita = new Cita();

        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(registroCitaDTO.fecha());
        cita.setHoraCita(registroCitaDTO.hora());
        cita.setMotivo(registroCitaDTO.motivoConsulta());
        cita.setEstado(EstadoCita.PROGRAMADA);
        cita.setPaciente(paciente.get());
        cita.setMedico(medico.get());

        Cita citaCreada = citaRepo.save(cita);
        return citaCreada.getCodigoCita();

    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {


        PQRS pqrs = new PQRS();
        pqrs.setFechaCreacion(LocalDateTime.now());
        pqrs.setTipoPQRS(registroPQRSDTO.tipoPQRS());
        pqrs.setEstado(EstadoPQRS.NUEVO);
        //Como puedo agregar el primer mensaje a la lista
        pqrs.setCita(citaRepo.findById(registroPQRSDTO.codigoCita()).get());

        PQRS pqrsCreada = pqrsRepo.save(pqrs);
        return pqrsCreada.getCodigo();
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for( PQRS p: listaPqrs ){

            respuesta.add( new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getFechaCreacion(),
                    p.getEstado(),
                    p.getCita().getPaciente().getNombre()
            ) );
        }
        return respuesta;
    }

    @Override
    public DetallesPQRSDTO verDetallesPQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigo);
        }

        PQRS buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByCodigo(codigo);

        return new DetallesPQRSDTO(
                buscado.getCodigo(),
                buscado.getFechaCreacion(),
                buscado.getEstado(),
                buscado.getCita().getFechaCita(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getMotivo(),
                new ArrayList<>()
                //Aun no se como traer la lista de mensajes
        );
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

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPQRS(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion( LocalDateTime.now() );
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuesta.mensaje());

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        Paciente paciente = pacienteRepo.findById(codigoPaciente).orElseThrow( () -> new Exception("No existe el paciente") );
        Optional<Paciente> opcional = pacienteRepo.findById(codigoPaciente);
        List<Cita> citasPaciente = citaRepo.findAllByPaciente(paciente);
        List<ItemCitaDTO> citas = new ArrayList<>();

        if (citasPaciente == null){
            throw new Exception("No existen citas para el paciente con código "+codigoPaciente);
        }

        for (Cita cita : citasPaciente){
            citas.add(new ItemCitaDTO(
                    cita.getCodigoCita(),
                    cita.getFechaCita(),
                    cita.getHoraCita(),
                    cita.getMedico().getEspecialidad(),
                    cita.getMedico().getNombre()
            ));
        }
        return citas;
    }

    @Override
    public DetallesCitaDTO verDetalleCita(int codigo) throws Exception {
        Optional<Cita> citaEncontrada = citaRepo.findById(codigo);

        if(citaEncontrada.isEmpty()){
            throw new Exception("No existe una cita con el código "+codigo);
        }

        Cita cita = citaEncontrada.get();

        return new DetallesCitaDTO(
                cita.getCodigoCita(),
                cita.getPaciente().getNombre(),
                cita.getFechaCreacion(),
                cita.getFechaCita(),
                cita.getHoraCita(),
                cita.getEstado(),
                cita.getMotivo(),
                cita.getMedico().getNombre(),
                cita.getMedico().getEspecialidad(),
                cita.getConsulta().getNotasMedicas(),
                cita.getConsulta().getDiagnostico(),
                cita.getConsulta().getTratamiento()
        );
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPorFecha(LocalDate fecha) throws Exception {
        List<Cita> citasFecha = citaRepo.findAllByFechaCita(fecha);

        if(citasFecha.isEmpty()){
            throw new Exception("No hay citas por la fecha introducida");
        }

        List<ItemCitaDTO> citas = new ArrayList<>();

        for(Cita c : citasFecha){
            citas.add(new ItemCitaDTO(
                    c.getCodigoCita(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getEspecialidad(),
                    c.getMedico().getNombre()
            ));
        }

        return citas;
    }

    @Override
    public List<ItemCitaDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception {
        Medico medico = medicoRepo.findById(codigoMedico).orElseThrow( () -> new Exception("No existe el medico") );
        //ptional<Medico> opcional = medicoRepo.findById(codigoMedico);
        List<Cita> citasMedico = citaRepo.findAllByMedico(medico);

        if(citasMedico.isEmpty()){
            throw new Exception("No hay citas por el medico introducido");
        }

        List<ItemCitaDTO> citas = new ArrayList<>();

        for(Cita c : citasMedico){
            citas.add(new ItemCitaDTO(
                    c.getCodigoCita(),
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getMedico().getEspecialidad(),
                    c.getMedico().getNombre()
            ));
        }

        return citas;
    }


    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

}
