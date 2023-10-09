package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.administrador.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.model.enums.EstadoUsuario;
import co.edu.uniquindio.clinica.services.implement.AdministradorServicioImpl;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServiceTest {

    @Autowired
    private AdministradorServices administradorServicio;

    @Test
    public void crearMedicoTest() {

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "12345",
                "Paco Perez",
                Ciudad.ARMENIA,
                "12345",
                "78387",
                "pepito@email.com",
                Especialidad.CARDIOLOGIA,
                EstadoUsuario.ACTIVO,
                "url_foto",
                horarios
        );
        try {
            administradorServicio.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
