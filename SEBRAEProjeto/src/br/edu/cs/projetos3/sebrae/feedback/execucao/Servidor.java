package br.edu.cs.projetos3.sebrae.feedback.execucao;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import br.edu.cs.projetos3.sebrae.feedback.entidades.Usuario;
import br.edu.cs.projetos3.sebrae.feedback.entidades.Servico;
import br.edu.cs.projetos3.sebrae.feedback.mediator.SinaisImplicitos;

public class Servidor {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/dados", (HttpExchange exchange) -> {

            // Libera CORS para o React
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://localhost:5173");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

            // Responde preflight
            if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            // Lógica de negócio
            SinaisImplicitos analisador = new SinaisImplicitos();
            Usuario roberto = new Usuario(4, "Roberto Alves", 155, 0);
            Servico gestao = new Servico(201, "Curso de Gestão Financeira", 500, 280, 45);

            String resultadoUsuario = analisador.analisarEngajamentoUsuario(roberto);
            String resultadoServico = analisador.analisarEficienciaServico(gestao);

            
            String resposta = "{" +
                "\"resultadoUsuario\": \"" + resultadoUsuario + "\"," +
                "\"resultadoServico\": \"" + resultadoServico + "\"" +
            "}";

            byte[] bytes = resposta.getBytes("UTF-8");
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        });

        server.start();
        System.out.println("Servidor rodando em http://localhost:8080");
    }
}