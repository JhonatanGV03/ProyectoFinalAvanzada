package co.edu.uniquindio.clinica.services.interfaces;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

public interface EmailServices {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
