package com.grupo10.app.controllers;

import com.grupo10.app.models.Servicio;
import com.grupo10.app.services.ServicioService;
import com.grupo10.app.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    @Autowired
    ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listar() {
        return ResponseEntity.ok(servicioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarPorId(@PathVariable Long id) {
        Servicio incidenteBD = servicioService.buscarPorId(id);
        if (incidenteBD != null) {
            return ResponseEntity.ok(incidenteBD);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody Servicio servicio) {
        System.out.println(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.guardar(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> guardar(@PathVariable Long id, @RequestBody Servicio servicio) {
        Servicio servicioBD = servicioService.modificar(id, servicio);

        if(servicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio);
    }

    @DeleteMapping
    public ResponseEntity<Servicio> eliminar(@PathVariable Long id) {
        Servicio servicioBD = servicioService.buscarPorId(id);

        if(servicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
