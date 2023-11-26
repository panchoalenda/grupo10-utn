package com.grupo10.app.services;

import com.grupo10.app.models.Tecnico;
import com.grupo10.app.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TecnicoService implements ITecnicoService{
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Override
    public List<Tecnico> listar() {
        return tecnicoRepository.findAll();
    }

    @Override
    public Tecnico buscarPorId(Long id) {
        return tecnicoRepository.findById(id).orElse(null);
    }

    @Override
    public Tecnico guardar(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public Tecnico modificar(Long id, Tecnico tecnico) {
        Optional<Tecnico> tecnicoBD = tecnicoRepository.findById(id);

        if(tecnicoBD.isPresent()){
            return tecnicoRepository.save(tecnico);
        }

        return null;
    }

    @Override
    public void eliminarPorId(Long id) {
       Optional<Tecnico> tecnicoBD = tecnicoRepository.findById(id);
       if(tecnicoBD.isPresent()){
           tecnicoRepository.deleteById(id);
       }
    }

    @Override
    public void eliminar(Tecnico tecnico) {
        Optional<Tecnico> tecnicoBD = tecnicoRepository.findById(tecnico.getId());
        if(tecnicoBD.isPresent()){
            tecnicoRepository.delete(tecnico);
        }
    }
}
