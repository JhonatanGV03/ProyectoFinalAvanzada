package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQRSRepository extends JpaRepository<PQRS, Integer>{
}
