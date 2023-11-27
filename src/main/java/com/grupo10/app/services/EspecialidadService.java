package com.grupo10.app.services;

import com.grupo10.app.models.Especialidad;
import com.grupo10.app.repositories.CatalogoServRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService implements IEspecialidadService {
    @Autowired
    private CatalogoServRepository catalogoServRepository;

    @Override
    public List<Especialidad> listar() {
        return null;
    }

    @Override
    public Especialidad buscarPorId(Long id) {
        return null;
    }

    @Override
    public Especialidad guardar(Especialidad catalogoServicio) {
        return null;
    }

    @Override
    public Especialidad modificar(Long id, Especialidad catalogoServicio) {
        return null;
    }

    @Override
    public void eliminarPorId(Long id) {

    }

    @Override
    public void eliminar(Especialidad catalogoServicio) {

    }
}
