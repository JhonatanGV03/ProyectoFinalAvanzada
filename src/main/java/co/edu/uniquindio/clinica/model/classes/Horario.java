package co.edu.uniquindio.clinica.model.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
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
    private String dia; //String
    @Column(nullable = false)
    private LocalTime horaInicio; //LocalTime
    @Column(nullable = false)
    private LocalTime horaFin; //LocalTime

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico medico;
}
