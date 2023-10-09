package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
}
