package com.grupo10.app.controllers;

import com.grupo10.app.models.Especialidad;
import com.grupo10.app.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo-servicio")
public class EspecialidadController {
    @Autowired
    EspecialidadService catalogoServicioService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> listar() {
        return ResponseEntity.ok(catalogoServicioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> buscarPorId(@PathVariable Long id) {
        Especialidad incidenteBD = catalogoServicioService.buscarPorId(id);
        if (incidenteBD != null) {
            return ResponseEntity.ok(incidenteBD);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Especialidad> guardar(@RequestBody Especialidad catalogoServicio) {
        System.out.println(catalogoServicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoServicioService.guardar(catalogoServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> guardar(@PathVariable Long id, @RequestBody Especialidad catalogoServicio) {
        Especialidad catalogoServicioBD = catalogoServicioService.modificar(id, catalogoServicio);

        if(catalogoServicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoServicio);
    }

    @DeleteMapping
    public ResponseEntity<Especialidad> eliminar(@PathVariable Long id) {
        Especialidad catalogoServicioBD = catalogoServicioService.buscarPorId(id);

        if(catalogoServicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
