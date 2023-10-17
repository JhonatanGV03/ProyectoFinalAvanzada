package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.services.interfaces.AutenticacionServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class AutenticacionServiceTest {

    @Autowired
    private AutenticacionServices autenticacionService;
}
