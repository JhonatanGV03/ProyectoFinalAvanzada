package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MedicoServiceTest {

    @Autowired
    private MedicoServices medicoService;
}
