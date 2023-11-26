package com.grupo10.app.controllers;

import com.grupo10.app.models.Tecnico;
import com.grupo10.app.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {
    @Autowired
    TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<List<Tecnico>> listar() {
        return ResponseEntity.ok(tecnicoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable Long id) {
        Tecnico incidenteBD = tecnicoService.buscarPorId(id);
        if (incidenteBD != null) {
            return ResponseEntity.ok(incidenteBD);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tecnico> guardar(@RequestBody Tecnico tecnico) {
        System.out.println(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.guardar(tecnico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> guardar(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        Tecnico tecnicoBD = tecnicoService.modificar(id, tecnico);

        if(tecnicoBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnico);
    }

    @DeleteMapping
    public ResponseEntity<Tecnico> eliminar(@PathVariable Long id) {
        Tecnico tecnicoBD = tecnicoService.buscarPorId(id);

        if(tecnicoBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
