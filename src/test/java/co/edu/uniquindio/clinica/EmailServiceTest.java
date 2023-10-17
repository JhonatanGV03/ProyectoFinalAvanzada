package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.services.interfaces.EmailServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@Transactional
public class EmailServiceTest {

    @Autowired
    private EmailServices emailService;

    @Test
    public void enviarCorreoTest() {
        try {
            emailService.enviarCorreo(new EmailDTO(
                    "Querido usuario, La Clinica Aurora Real le informa que su cita ha sido agendada con exito",
                    "alexdj1920@gmail.com",
                    "Primera Notificación de cita",
                    "clinicaaurora@gmail.com"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
