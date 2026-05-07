package br.edu.cs.projetos3.sebrae.feedback.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ClientesService {

    public ResponseEntity<String> getClientes() {
        try {
            ClassPathResource resource = new ClassPathResource("data/clients.json");
            String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(content);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("{\"erro\": \"Erro ao carregar clientes.\"}");
        }
    }
}