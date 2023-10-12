package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.services.interfaces.AutenticacionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServices {

    @Override
    public void iniciarSesion(LoginDTO loginDTO) throws Exception {

    }
}
