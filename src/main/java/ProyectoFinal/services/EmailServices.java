package ProyectoFinal.services;

import ProyectoFinal.dto.EmailDTO;

public interface EmailServices {
    void enviarCorreo(EmailDTO emailDto);
}
