package com.grupo10.app.services;

import com.grupo10.app.models.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClienteService {
    @Transactional(readOnly = true)
    List<Cliente> listar();
    @Transactional(readOnly = true)
    Cliente buscarPorId(Long id);
    @Transactional
    Cliente guardar(Cliente cliente);
    @Transactional
    Cliente modificar(Long id, Cliente cliente);
    @Transactional
    void eliminarPorId(Long id);
    @Transactional
    void eliminar(Cliente cliente);

}
