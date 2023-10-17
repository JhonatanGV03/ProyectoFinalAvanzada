package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.services.interfaces.MedicoServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest
public class MedicoServiceTest {

    @Autowired
    private MedicoServices medicoService;

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDisponibildiadTest() throws Exception {

        LocalDate fecha = LocalDate.of(2023, 10, 23);
        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(fecha);
        int medico = medicoService.agendarDiaLibre(diaLibreDTO, 11);
        //System.out.println(medico);
        Assertions.assertEquals(6, medico );
    }
}
