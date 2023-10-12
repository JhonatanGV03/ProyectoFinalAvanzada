package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.services.interfaces.AutenticacionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutenticacionServiceTest {

    @Autowired
    private AutenticacionServices autenticacionService;
}
