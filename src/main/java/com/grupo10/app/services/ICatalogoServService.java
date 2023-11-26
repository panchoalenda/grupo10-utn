package com.grupo10.app.services;

import com.grupo10.app.models.CatalogoServ;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICatalogoServService {
    @Transactional(readOnly = true)
    List<CatalogoServ> listar();
    @Transactional(readOnly = true)
    CatalogoServ buscarPorId(Long id);
    @Transactional
    CatalogoServ guardar(CatalogoServ catalogoServicio);
    @Transactional
    CatalogoServ modificar(Long id, CatalogoServ catalogoServicio);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(CatalogoServ catalogoServicio);

}
