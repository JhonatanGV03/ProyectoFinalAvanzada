package ProyectoFinal.model.classes;

import ProyectoFinal.model.enums.Ciudad;
import ProyectoFinal.model.enums.EstadoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Cuenta implements Serializable {
    //Atributos
    //@Column(name="x")
    private String cedula;
    //@Column(name="x")
    private String nombre;
    //@Column(name="x")
    private int telefono;
    //@Column(name="x")
    private String urlFoto;
    //Enums
    private Ciudad codigoCiudad;
    private EstadoUsuario estadoCuenta;

}
