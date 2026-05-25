package br.edu.cs.projetos3.sebrae.feedback.mediator;

import br.edu.cs.projetos3.sebrae.feedback.service.TaxaRetornoUsuarioService;
import br.edu.cs.projetos3.sebrae.feedback.entidades.TaxaRetornoUsuario;
import org.springframework.stereotype.Service;

@Service
public class TaxaRetornoUsuarioMediator {

	    private final TaxaRetornoUsuarioService service;

	    public TaxaRetornoUsuarioMediator(TaxaRetornoUsuarioService service) {
	        this.service = service;
	    }

	    public TaxaRetornoUsuario registrarAcessoUsuario(Long clienteId) {
	        // Aqui você poderia mapear a entidade para um DTO de resposta, se usar DTOs no projeto
	        return service.registrarNovoAcesso(clienteId);
	    }
	    
	    // Outros métodos como analisarComparacaoPeriodos(Long clienteId, String mesAno) etc.
}
