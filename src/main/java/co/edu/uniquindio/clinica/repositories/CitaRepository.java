package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {


}
