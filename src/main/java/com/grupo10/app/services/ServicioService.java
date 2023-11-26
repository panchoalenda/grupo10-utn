package com.grupo10.app.services;

import com.grupo10.app.models.Servicio;
import com.grupo10.app.repositories.ServicioRepository;
import com.grupo10.app.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService{
    @Autowired
    private ServicioRepository servicioRepository;
    @Override
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio modificar(Long id, Servicio servicio) {
        Optional<Servicio> servicioBD = servicioRepository.findById(id);

        if(servicioBD.isPresent()){
            return servicioRepository.save(servicio);
        }

        return null;
    }

    @Override
    public void eliminarPorId(Long id) {
       Optional<Servicio> servicioBD = servicioRepository.findById(id);
       if(servicioBD.isPresent()){
           servicioRepository.deleteById(id);
       }
    }

    @Override
    public void eliminar(Servicio servicio) {
        Optional<Servicio> servicioBD = servicioRepository.findById(servicio.getId());
        if(servicioBD.isPresent()){
            servicioRepository.delete(servicio);
        }
    }
}
