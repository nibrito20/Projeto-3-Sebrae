package br.edu.cs.projetos3.sebrae.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.edu.cs.projetos3.sebrae.feedback.repository")
@EntityScan(basePackages = "br.edu.cs.projetos3.sebrae.feedback.entidades")
public class SebraeFeedbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SebraeFeedbackApplication.class, args);
    }
}

