package com.grupo10.app.services;

import com.grupo10.app.models.Especialidad;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEspecialidadService {
    @Transactional(readOnly = true)
    List<Especialidad> listar();
    @Transactional(readOnly = true)
    Especialidad buscarPorId(Long id);
    @Transactional
    Especialidad guardar(Especialidad catalogoServicio);
    @Transactional
    Especialidad modificar(Long id, Especialidad catalogoServicio);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(Especialidad catalogoServicio);

}
