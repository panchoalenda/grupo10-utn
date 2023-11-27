package com.grupo10.app.services;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificar(Long id, Cliente cliente) {
        System.out.println("El cliente es : " + id);

        Optional<Cliente> clienteBD = clienteRepository.findById(id);
        System.out.println();
        if(clienteBD.isPresent()){
            Cliente cliente1 = clienteBD.get();
            cliente1.setCuil(cliente.getCuil());
            cliente1.setRazonSocial(cliente.getRazonSocial());
            if (cliente1.getServiciosContratados() != null) {
                cliente1.setServiciosContratados(cliente.getServiciosContratados());
            }
            return clienteRepository.save(cliente1);
        }

        return null;
    }

    @Override
    public void eliminarPorId(Long id) {
       Optional<Cliente> clienteBD = clienteRepository.findById(id);
       if(clienteBD.isPresent()){
           clienteRepository.deleteById(id);
       }
    }

    @Override
    public void eliminar(Cliente cliente) {
        Optional<Cliente> clienteBD = clienteRepository.findById(cliente.getId());
        if(clienteBD.isPresent()){
            clienteRepository.delete(cliente);
        }
    }
}
