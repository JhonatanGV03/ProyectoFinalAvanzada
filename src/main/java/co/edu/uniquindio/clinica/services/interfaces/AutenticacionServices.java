package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.LoginDTO;

public interface AutenticacionServices {
    void iniciarSesion(LoginDTO loginDTO) throws Exception;
}
