package com.grupo10.app.repositories;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
