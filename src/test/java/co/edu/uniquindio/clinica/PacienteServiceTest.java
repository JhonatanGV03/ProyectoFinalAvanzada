package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.services.interfaces.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteServices pacienteService;
}
