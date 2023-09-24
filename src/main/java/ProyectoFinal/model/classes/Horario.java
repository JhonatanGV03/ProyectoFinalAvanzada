package ProyectoFinal.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int codigoHorario;

    //Atributos
    @Column(nullable = false)
    private Date dia;
    @Column(nullable = false)
    private Time horaInicio;
    @Column(nullable = false)
    private Time horaFin;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico codigoMedico;
}
