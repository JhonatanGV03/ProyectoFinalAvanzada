package ProyectoFinal.services;

import ProyectoFinal.dto.LoginDTO;

public interface AutenticacionServices {
    void iniciarSesion(LoginDTO loginDTO) throws Exception;
}
