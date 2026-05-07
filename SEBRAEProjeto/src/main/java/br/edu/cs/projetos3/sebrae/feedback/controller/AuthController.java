package br.edu.cs.projetos3.sebrae.feedback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.cs.projetos3.sebrae.feedback.service.AuthService;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        return authService.login(body.get("email"), body.get("senha"));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, String>> cadastro(@RequestBody Map<String, String> body) {
        return authService.cadastro(body);
    }
}