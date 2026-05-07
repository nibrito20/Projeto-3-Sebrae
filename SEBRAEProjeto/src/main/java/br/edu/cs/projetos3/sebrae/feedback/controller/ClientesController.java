package br.edu.cs.projetos3.sebrae.feedback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.cs.projetos3.sebrae.feedback.service.ClientesService;

@RestController
@RequestMapping("/api")
public class ClientesController {

    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<String> getClientes() {
        return clientesService.getClientes();
    }
}