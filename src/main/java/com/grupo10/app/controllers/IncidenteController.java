package com.grupo10.app.controllers;

import com.grupo10.app.models.Incidente;
import com.grupo10.app.services.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidente")
public class IncidenteController {
    @Autowired
    IncidenteService incidenteService;

    @GetMapping
    public ResponseEntity<List<Incidente>> listar() {
        return ResponseEntity.ok(incidenteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidente> buscarPorId(@PathVariable Long id) {
        Incidente incidenteBD = incidenteService.buscarPorId(id);
        if (incidenteBD != null) {
            return ResponseEntity.ok(incidenteBD);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Incidente> guardar(@RequestBody Incidente incidente) {
        System.out.println(incidente);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenteService.guardar(incidente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidente> guardar(@PathVariable Long id, @RequestBody Incidente incidente) {
        Incidente clienteBD = incidenteService.modificar(id, incidente);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(incidente);
    }

    @DeleteMapping
    public ResponseEntity<Incidente> eliminar(@PathVariable Long id) {
        Incidente clienteBD = incidenteService.buscarPorId(id);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
