package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.administrador.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.model.classes.Cita;
import co.edu.uniquindio.clinica.model.classes.Medico;
import co.edu.uniquindio.clinica.model.classes.Paciente;
import co.edu.uniquindio.clinica.model.enums.EstadoCita;
import co.edu.uniquindio.clinica.repositories.*;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServices {

    private final MedicoRepository medicoRepo;
    private final CitaRepository citaRepo;
    private final DisponibilidadRepository disponibilidadRepo;
    private final HorarioRepository horarioRepo;
    private final PacienteRepository pacienteRepo;


    @Override
    public List<ItemCitaMedicoDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        Medico medico = medicoRepo.findById(codigoMedico).orElseThrow( () -> new Exception("No existe el medico") );
        List<Cita> citas = citaRepo.findAllByMedico(medico);
        List<ItemCitaMedicoDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            if(c.getEstado().equals(EstadoCita.PROGRAMADA) ){
                respuesta.add( new ItemCitaMedicoDTO(
                        c.getPaciente().getNombre(),
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getEstado()
                )  );
            }
        }

        return respuesta;

    }
/*

 */
    @Override
    public void atenderCita(RegistroConsultaDTO atencionMedica) throws Exception {

    }

    @Override
    public List<ItemCitaHistorialDTO> listarHistorialPaciente(int codigoPaciente) throws Exception {

        Paciente paciente = pacienteRepo.findById(codigoPaciente).orElseThrow( () -> new Exception("No existe el paciente") );
        List<Cita> citas = citaRepo.findAllByPaciente(paciente);
        List<ItemCitaHistorialDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
                respuesta.add( new ItemCitaHistorialDTO(
                        c.getFechaCita().atTime(c.getHoraCita()),
                        c.getMedico().getNombre(),
                        c.getMedico().getEspecialidad()
                )  );

        }

        return respuesta;

    }
/*

 */
    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaRealizadaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        Medico medico = medicoRepo.findById(codigoMedico).orElseThrow( () -> new Exception("No existe el medico") );
        List<Cita> citas = citaRepo.findAllByMedico(medico);
        List<ItemCitaRealizadaDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            if(c.getEstado().equals(EstadoCita.COMPLETADA) ){
                respuesta.add( new ItemCitaRealizadaDTO(
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getPaciente().getNombre(),
                        c.getPaciente().getCedula()
                )  );
            }
        }

        return respuesta;
    }
}
