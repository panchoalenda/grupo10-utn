package com.grupo10.app.controllers;

import com.grupo10.app.models.CatalogoServ;
import com.grupo10.app.services.CatalogoServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo-servicio")
public class CatalogoServicioController {
    @Autowired
    CatalogoServService catalogoServicioService;

    @GetMapping
    public ResponseEntity<List<CatalogoServ>> listar() {
        return ResponseEntity.ok(catalogoServicioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoServ> buscarPorId(@PathVariable Long id) {
        CatalogoServ incidenteBD = catalogoServicioService.buscarPorId(id);
        if (incidenteBD != null) {
            return ResponseEntity.ok(incidenteBD);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CatalogoServ> guardar(@RequestBody CatalogoServ catalogoServicio) {
        System.out.println(catalogoServicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoServicioService.guardar(catalogoServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoServ> guardar(@PathVariable Long id, @RequestBody CatalogoServ catalogoServicio) {
        CatalogoServ catalogoServicioBD = catalogoServicioService.modificar(id, catalogoServicio);

        if(catalogoServicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoServicio);
    }

    @DeleteMapping
    public ResponseEntity<CatalogoServ> eliminar(@PathVariable Long id) {
        CatalogoServ catalogoServicioBD = catalogoServicioService.buscarPorId(id);

        if(catalogoServicioBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
