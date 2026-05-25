package br.edu.cs.projetos3.sebrae.feedback.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import br.edu.cs.projetos3.sebrae.feedback.entidades.TaxaRetornoUsuario;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxaRetornoUsuarioRepository {

	    // Caminho para o arquivo dentro do seu projeto
	    private final String PATH_ARQUIVO = "src/main/resources/data/taxa_retorno_usuario.json";
	    private final ObjectMapper objectMapper;

	    public TaxaRetornoUsuarioRepository() {
	        this.objectMapper = new ObjectMapper();
	        // Registra o módulo para o Jackson conseguir ler/escrever LocalDate corretamente
	        this.objectMapper.registerModule(new JavaTimeModule());
	    }

	    // Busca todos os registros do JSON
	    public List<TaxaRetornoUsuario> findAll() {
	        File arquivo = new File(PATH_ARQUIVO);
	        if (!arquivo.exists()) {
	            return new ArrayList<>();
	        }
	        try {
	            return objectMapper.readValue(arquivo, new TypeReference<List<TaxaRetornoUsuario>>() {});
	        } catch (IOException e) {
	            throw new RuntimeException("Erro ao ler o arquivo JSON de taxa de retorno", e);
	        }
	    }

	    // Busca um cliente específico pelo ID. Se não existir, cria um novo objeto zerado.
	    public TaxaRetornoUsuario findById(Long clienteId) {
	        List<TaxaRetornoUsuario> lista = findAll();
	        
	        return lista.stream()
	                .filter(u -> u.getClienteId().equals(clienteId))
	                .findFirst()
	                .orElseGet(() -> {
	                    // Se o cliente não existir no JSON, inicia uma estrutura nova para ele
	                    TaxaRetornoUsuario novo = new TaxaRetornoUsuario();
	                    novo.setClienteId(clienteId);
	                    novo.setCurrentStreak(0);
	                    novo.setLongestStreak(0);
	                    novo.setLoginHistory(new ArrayList<>());
	                    return novo;
	                });
	    }

	    // Salva ou atualiza os dados no arquivo JSON
	    public TaxaRetornoUsuario save(TaxaRetornoUsuario usuarioAtualizado) {
	        List<TaxaRetornoUsuario> lista = findAll();
	        
	        // Remove o registro antigo se ele já existir na lista
	        lista.removeIf(u -> u.getClienteId().equals(usuarioAtualizado.getClienteId()));
	        
	        // Adiciona o registro atualizado
	        lista.add(usuarioAtualizado);

	        try {
	            // Grava a lista atualizada de volta no arquivo JSON de forma organizada (indentado)
	            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(PATH_ARQUIVO), lista);
	            return usuarioAtualizado;
	        } catch (IOException e) {
	            throw new RuntimeException("Erro ao salvar os dados no arquivo JSON", e);
	        }
	    }
}
