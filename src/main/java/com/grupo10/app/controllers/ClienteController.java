package com.grupo10.app.controllers;

import com.grupo10.app.models.Cliente;
import com.grupo10.app.models.ClienteDTO;
import com.grupo10.app.models.Servicio;
import com.grupo10.app.services.ClienteService;
import com.grupo10.app.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService  clienteService;
    @Autowired
    ServicioService servicioService;

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
    public ResponseEntity<Cliente> guardar(@RequestBody ClienteDTO cliente) {
        Cliente cliente1 = new Cliente();
        cliente1.setCuil(cliente.getCuil());
        cliente1.setRazonSocial(cliente.getRazonSocial());
        Servicio servicioBD = servicioService.buscarPorId(cliente.getServicioContratado().getId());

        List<Servicio> servicios = new ArrayList<>();
        servicios.add(servicioBD);

        cliente1.setServiciosContratados(servicios);

        cliente1.getServiciosContratados().forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardar(cliente1));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> guardar(@PathVariable Long id, @RequestBody Cliente cliente) {
        System.out.println("El cliente es : " + id);
        Cliente clienteBD = clienteService.modificar(id, cliente);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable Long id) {
        Cliente clienteBD = clienteService.buscarPorId(id);

        if(clienteBD == null){
            return ResponseEntity.notFound().build();
        }
        clienteService.eliminarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
