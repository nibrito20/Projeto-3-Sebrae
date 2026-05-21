package br.edu.cs.projetos3.sebrae.feedback.controller;

import br.edu.cs.projetos3.sebrae.feedback.mediator.TaxaRetornoUsuarioMediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/retorno-usuario")

public class TaxaRetornoUsuarioController {

	    private final TaxaRetornoUsuarioMediator mediator;

	    public TaxaRetornoUsuarioController(TaxaRetornoUsuarioMediator mediator) {
	        this.mediator = mediator;
	    }

	    @PostMapping("/{clienteId}/acesso")
	    public ResponseEntity<?> registrarAcesso(@PathVariable Long clienteId) {
	        try {
	            var resultado = mediator.registrarAcessoUsuario(clienteId);
	            return ResponseEntity.ok(resultado);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Erro ao registrar acesso: " + e.getMessage());
	        }
	    }
}
