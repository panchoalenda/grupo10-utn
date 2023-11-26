package com.grupo10.app.services;

import com.grupo10.app.models.Incidente;
import com.grupo10.app.repositories.IncidenteRepository;
import com.grupo10.app.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IncidenteService implements IIncidenteService{
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Override
    public List<Incidente> listar() {
        return incidenteRepository.findAll();
    }

    @Override
    public Incidente buscarPorId(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    @Override
    public Incidente guardar(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    @Override
    public Incidente modificar(Long id, Incidente incidente) {
        Optional<Incidente> incidenteBD = incidenteRepository.findById(id);

        if(incidenteBD.isPresent()){
            return incidenteRepository.save(incidente);
        }

        return null;
    }

    @Override
    public void eliminarPorId(Long id) {
       Optional<Incidente> incidenteBD = incidenteRepository.findById(id);
       if(incidenteBD.isPresent()){
           incidenteRepository.deleteById(id);
       }
    }

    @Override
    public void eliminar(Incidente incidente) {
        Optional<Incidente> incidenteBD = incidenteRepository.findById(incidente.getId());
        if(incidenteBD.isPresent()){
            incidenteRepository.delete(incidente);
        }
    }
}
