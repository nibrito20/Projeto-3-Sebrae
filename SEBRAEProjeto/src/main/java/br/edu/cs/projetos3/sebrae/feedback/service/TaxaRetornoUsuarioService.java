package br.edu.cs.projetos3.sebrae.feedback.service;

import br.edu.cs.projetos3.sebrae.feedback.entidades.TaxaRetornoUsuario;
import br.edu.cs.projetos3.sebrae.feedback.repository.TaxaRetornoUsuarioRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TaxaRetornoUsuarioService {

	    private final TaxaRetornoUsuarioRepository repository;

	    public TaxaRetornoUsuarioService(TaxaRetornoUsuarioRepository repository) {
	        this.repository = repository;
	    }

	    public TaxaRetornoUsuario registrarNovoAcesso(Long clienteId) {
	        TaxaRetornoUsuario usuario = repository.findById(clienteId);
	        LocalDate hoje = LocalDate.now();

	        if (usuario.getLastLoginDate() != null) {
	            long diasDiferenca = ChronoUnit.DAYS.between(usuario.getLastLoginDate(), hoje);

	            if (diasDiferenca == 1) {
	                // Acessou no dia seguinte: mantém e aumenta o streak
	                usuario.setCurrentStreak(usuario.getCurrentStreak() + 1);
	            } else if (diasDiferenca > 1) {
	                // Quebrou o streak
	                usuario.setCurrentStreak(1);
	            }
	            // Se for 0 (já acessou hoje), não fazemos nada com o streak
	        } else {
	            // Primeiro acesso de todos
	            usuario.setCurrentStreak(1);
	        }

	        // Atualiza o recorde se necessário
	        if (usuario.getCurrentStreak() > usuario.getLongestStreak()) {
	            usuario.setLongestStreak(usuario.getCurrentStreak());
	        }

	        // Adiciona ao histórico se não tiver acessado hoje ainda
	        if (usuario.getLastLoginDate() == null || !usuario.getLastLoginDate().equals(hoje)) {
	            usuario.getLoginHistory().add(hoje);
	            usuario.setLastLoginDate(hoje);
	        }

	        return repository.save(usuario);
	    }
}
