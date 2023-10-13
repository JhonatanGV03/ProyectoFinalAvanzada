package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.administrador.DetallesMedicoDTO;
import co.edu.uniquindio.clinica.dto.administrador.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.administrador.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.model.enums.Ciudad;
import co.edu.uniquindio.clinica.model.enums.Especialidad;
import co.edu.uniquindio.clinica.services.interfaces.AdministradorServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AdministradorServiceTest {

    @Autowired
    private AdministradorServices administradorServicio;

    @Test
    public void crearMedicoTest() {

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Paco Perez",
                "54321",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGIA,
                "12345",
                "pepito@email.com",
                "78387",
                "url_foto",
                horarios
        );
        try {
            administradorServicio.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void actualizarMedicoTest() {
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));

        DetallesMedicoDTO medicoDTO = new DetallesMedicoDTO(
                2,
                "Alejandro Hernandez",
                "12345",
                Ciudad.ARMENIA,
                Especialidad.MEDICINA_GENERAL,
                "12345",
                "Hernan@email.com",
                "78387/img/imagen.jpg",
                horarios
        );
        try {
            administradorServicio.actualizarmedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void eliminarMedicoTest() {
        try {
            administradorServicio.eliminarmedico(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void listarMedicosTest() {
        try {
            List<ItemMedicoDTO> medicos = administradorServicio.listarmedicos();
            System.out.println(medicos.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void obtenerMedicoTest() {
        try {
            System.out.println(administradorServicio.obtenerMedico(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
