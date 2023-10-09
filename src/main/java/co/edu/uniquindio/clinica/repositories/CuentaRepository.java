package co.edu.uniquindio.clinica.repositories;

import co.edu.uniquindio.clinica.model.classes.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
