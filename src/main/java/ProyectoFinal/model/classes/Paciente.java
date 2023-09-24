package ProyectoFinal.model.classes;

import ProyectoFinal.model.enums.EPS;
import ProyectoFinal.model.enums.TipoSangre;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente extends Usuario implements Serializable {
    //Atributos
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false, length = 150)
    private String alegias;

    //Enums
    private EPS codigoEPS;
    private TipoSangre codigoTipoSangre;

    //Relaciones
    @OneToMany(mappedBy="codigoPaciente")
    private List<Cita> cita;
}
