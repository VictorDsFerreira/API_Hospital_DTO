package com.sistemahospitalar.sistemahospitalar.repository;

import com.sistemahospitalar.sistemahospitalar.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
