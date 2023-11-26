package com.grupo10.app.services;

import com.grupo10.app.models.CatalogoServ;
import com.grupo10.app.repositories.CatalogoServRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoServService implements ICatalogoServService {
    @Autowired
    private CatalogoServRepository catalogoServRepository;

    @Override
    public List<CatalogoServ> listar() {
        return null;
    }

    @Override
    public CatalogoServ buscarPorId(Long id) {
        return null;
    }

    @Override
    public CatalogoServ guardar(CatalogoServ catalogoServicio) {
        return null;
    }

    @Override
    public CatalogoServ modificar(Long id, CatalogoServ catalogoServicio) {
        return null;
    }

    @Override
    public void eliminarPorId(Long id) {

    }

    @Override
    public void eliminar(CatalogoServ catalogoServicio) {

    }
}
