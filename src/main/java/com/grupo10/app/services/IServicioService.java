package com.grupo10.app.services;

import com.grupo10.app.models.Servicio;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServicioService {
    @Transactional(readOnly = true)
    List<Servicio> listar();
    @Transactional(readOnly = true)
    Servicio buscarPorId(Long id);
    @Transactional
    Servicio guardar(Servicio servicio);
    @Transactional
    Servicio modificar(Long id, Servicio servicio);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(Servicio servicio);

}
