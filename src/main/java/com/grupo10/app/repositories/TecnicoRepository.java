package com.grupo10.app.repositories;

import com.grupo10.app.models.Incidente;
import com.grupo10.app.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
