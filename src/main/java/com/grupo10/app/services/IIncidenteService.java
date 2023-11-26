package com.grupo10.app.services;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.models.Incidente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IIncidenteService {
    @Transactional(readOnly = true)
    List<Incidente> listar();
    @Transactional(readOnly = true)
    Incidente buscarPorId(Long id);
    @Transactional
    Incidente guardar(Incidente cliente);
    @Transactional
    Incidente modificar(Long id, Incidente cliente);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(Incidente cliente);

}
