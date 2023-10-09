package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
