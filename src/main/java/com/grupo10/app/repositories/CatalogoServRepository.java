package com.grupo10.app.repositories;

import com.grupo10.app.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoServRepository extends JpaRepository<Especialidad, Long> {
}
