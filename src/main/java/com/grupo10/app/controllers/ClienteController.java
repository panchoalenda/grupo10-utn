package com.grupo10.app.controllers;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente clienteBd = clienteService.buscarPorId(id);
        if (clienteBd != null) {
            return ResponseEntity.ok(clienteBd);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        System.out.println(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> guardar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteBD = clienteService.modificar(id, cliente);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping
    public ResponseEntity<Cliente> eliminar(@PathVariable Long id) {
        Cliente clienteBD = clienteService.buscarPorId(id);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
