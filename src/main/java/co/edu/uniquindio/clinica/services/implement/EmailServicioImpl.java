package co.edu.uniquindio.clinica.services.implement;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.services.interfaces.EmailServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServices {
    @Override
    public String enviarCorreo(EmailDTO emailDTO) throws Exception {
        return null;
    }
}
