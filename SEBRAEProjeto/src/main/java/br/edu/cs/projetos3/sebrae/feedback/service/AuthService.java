package br.edu.cs.projetos3.sebrae.feedback.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final List<ObjectNode> usuarios = new ArrayList<>();

    public AuthService() {
        carregarUsuarios();
    }

    private void carregarUsuarios() {
        try {
            InputStream is = getClass().getResourceAsStream("/data/usuarios.json");
            if (is != null) {
                JsonNode root = mapper.readTree(is);
                JsonNode lista = root.get("usuarios");
                if (lista != null && lista.isArray()) {
                    for (JsonNode u : lista) {
                        if (u.isObject()) {
                            usuarios.add((ObjectNode) u);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuarios.json: " + e.getMessage());
        }
    }

    public ResponseEntity<Map<String, String>> login(String email, String senha) {
        for (JsonNode usuario : usuarios) {
            if (email.equals(usuario.path("email").asText()) &&
                senha.equals(usuario.path("senha").asText())) {
                String nome = usuario.path("nome").asText();
                return ResponseEntity.ok(Map.of("mensagem", "Login realizado!", "nome", nome));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("erro", "Email ou senha inválidos!"));
    }

    public ResponseEntity<Map<String, String>> cadastro(Map<String, String> body) {
        String email = body.get("email");
        for (JsonNode usuario : usuarios) {
            if (email.equals(usuario.path("email").asText())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("erro", "Email já cadastrado!"));
            }
        }
        ObjectNode novoUsuario = mapper.createObjectNode();
        novoUsuario.put("nome", body.get("nome"));
        novoUsuario.put("email", email);
        novoUsuario.put("senha", body.get("senha"));
        usuarios.add(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cadastro realizado com sucesso!"));
    }
}