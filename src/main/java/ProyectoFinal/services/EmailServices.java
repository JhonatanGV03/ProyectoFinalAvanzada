package ProyectoFinal.services;

import ProyectoFinal.dto.EmailDTO;

public interface EmailServices {
    String enviarCorreo(EmailDTO emailDTO) throws Exception;
}
