package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {



}
