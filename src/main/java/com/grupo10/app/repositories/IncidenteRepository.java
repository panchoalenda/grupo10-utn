package com.grupo10.app.repositories;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.models.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
}
