package com.grupo10.app.repositories;

import com.grupo10.app.models.CatalogoServ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoServRepository extends JpaRepository<CatalogoServ, Long> {
}
