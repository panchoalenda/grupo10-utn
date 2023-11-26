package com.grupo10.app.services;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.models.Tecnico;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITecnicoService {
    @Transactional(readOnly = true)
    List<Tecnico> listar();
    @Transactional(readOnly = true)
    Tecnico buscarPorId(Long id);
    @Transactional
    Tecnico guardar(Tecnico cliente);
    @Transactional
    Tecnico modificar(Long id, Tecnico cliente);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(Tecnico cliente);

}
