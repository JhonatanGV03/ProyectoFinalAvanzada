package ProyectoFinal.model.classes;

import ProyectoFinal.model.enums.EstadoPQRS;
import ProyectoFinal.model.enums.TipoPQRS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PQRS implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="x")
    private int codigoPQRS;
    //Atributos
    //@Column(name="x")
    private LocalDateTime fechaCreacion;
    //Enums
    private TipoPQRS tipoPQRS;
    private EstadoPQRS codigoEstado;
    //Relacion Clases
    @ManyToOne
    private Cita codigoCita;
    @OneToMany(mappedBy="codigoMensaje")
    private List<Mensaje> mensajes;


}
