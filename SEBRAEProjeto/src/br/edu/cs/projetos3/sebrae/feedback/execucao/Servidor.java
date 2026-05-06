package br.edu.cs.projetos3.sebrae.feedback.execucao;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;

public class Servidor {
	
	static String usuariosPath = Paths.get(
	        System.getProperty("user.dir"), "src", "resources", "usuarios.json"
	    ).toString();

	    static String clientesPath = Paths.get(
	        System.getProperty("user.dir"), "src", "resources", "clients.json"
	    ).toString();

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        server.createContext("/api/clientes", (HttpExchange exchange) -> {
            addCors(exchange);
            if (isPreflight(exchange)) return;

            String resposta = new String(Files.readAllBytes(Paths.get(clientesPath)), "UTF-8");
            enviarResposta(exchange, 200, resposta);
        });
        
        server.createContext("/api/cadastro", (HttpExchange exchange) -> {
            addCors(exchange);
            if (isPreflight(exchange)) return;

            String body = new String(exchange.getRequestBody().readAllBytes(), "UTF-8");

            String conteudo = new String(Files.readAllBytes(Paths.get(usuariosPath)), "UTF-8");

            String email = extrairCampo(body, "email");
            if (conteudo.contains("\"" + email + "\"")) {
                enviarResposta(exchange, 409, "{\"erro\": \"Email já cadastrado!\"}");
                return;
            }

            String novoUsuario = body;
            String atualizado = conteudo.replace(
                "\"usuarios\": [",
                "\"usuarios\": [" + novoUsuario + ","
            );

            Files.write(Paths.get(usuariosPath), atualizado.getBytes("UTF-8"));
            enviarResposta(exchange, 201, "{\"mensagem\": \"Cadastro realizado com sucesso!\"}");
        });
        
        server.createContext("/api/login", (HttpExchange exchange) -> {
            addCors(exchange);
            if (isPreflight(exchange)) return;

            String body = new String(exchange.getRequestBody().readAllBytes(), "UTF-8");
            String email = extrairCampo(body, "email");
            String senha = extrairCampo(body, "senha");

            String conteudo = new String(Files.readAllBytes(Paths.get(usuariosPath)), "UTF-8");

            if (conteudo.contains("\"" + email + "\"") && conteudo.contains("\"" + senha + "\"")) {
                String nome = extrairNomeDoUsuario(conteudo, email);
                enviarResposta(exchange, 200, "{\"mensagem\": \"Login realizado!\", \"nome\": \"" + nome + "\"}");
            } else {
                enviarResposta(exchange, 401, "{\"erro\": \"Email ou senha inválidos!\"}");
            }
        });

        server.start();
        System.out.println("Servidor rodando em http://localhost:8080");
    }
    
    static void addCors(HttpExchange exchange) {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://localhost:5173");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
    }

    static boolean isPreflight(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1);
            return true;
        }
        return false;
    }

    static void enviarResposta(HttpExchange exchange, int status, String resposta) throws IOException {
        byte[] bytes = resposta.getBytes("UTF-8");
        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(status, bytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
    
    static String extrairCampo(String json, String campo) {
        String chave = "\"" + campo + "\"";
        int idx = json.indexOf(chave);
        if (idx == -1) return "";
        int inicio = json.indexOf("\"", idx + chave.length() + 1) + 1;
        int fim = json.indexOf("\"", inicio);
        return json.substring(inicio, fim);
    }

    static String extrairNomeDoUsuario(String json, String email) {
        int idxEmail = json.indexOf("\"" + email + "\"");
        if (idxEmail == -1) return "";
        
        int blocoInicio = json.lastIndexOf("{", idxEmail);
        String bloco = json.substring(blocoInicio);
        return extrairCampo(bloco, "nome");
    }
}