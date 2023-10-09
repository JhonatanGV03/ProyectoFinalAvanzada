package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.EmailDTO;

public interface EmailServices {
    String enviarCorreo(EmailDTO emailDTO) throws Exception;
}
