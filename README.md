# 🧠 Sistema de Análise de Satisfação do Cliente - SEBRAE

> Projeto desenvolvido para o SEBRAE com o objetivo de medir a satisfação do cliente **sem a necessidade de perguntas diretas**, utilizando análise de comportamento dentro de uma plataforma digital.

## 🔗 Repositórios do Projeto

| Repositório | Descrição |
|-------------|-----------|
| [Back-end](https://github.com/nibrito20/Projeto-3-Sebrae) | Você está aqui |
| [Front-end](https://github.com/nibrito20/Projeto-3-Sebrae-Front) | Interface React |

---

## 🎯 Objetivo

Criar um sistema que permita:
- Identificar problemas na experiência do usuário
- Detectar sinais de insatisfação de forma indireta
- Ajudar na tomada de decisão baseada em dados reais de uso
- Reduzir dependência de pesquisas tradicionais (ex: NPS, formulários)

---

## ⚙️ Tecnologias Utilizadas

- Java
- Spring Boot
- APIs externas → coleta de comportamento

---

## 🚀 Principais Funcionalidades

### Mapa de Calor de Interações
- Rastreia cliques, rolagens e áreas ignoradas
- Visualização com cores: 🔴 Alta · 🟡 Média · 🟢 Baixa interação
- Identifica pontos de interesse e desinteresse

### Detector de Abandono Inteligente
- Identifica onde os usuários estão saindo da plataforma
- Dashboard com ranking de páginas mais críticas
- Visualização em funil (entrada → saída)
- Alertas para quedas abruptas de retenção

### Score de Engajamento por Cliente
- Índice baseado em frequência de uso, profundidade de navegação e reuso de funcionalidades
- Classificação: Baixo · Médio · Alto engajamento
- Ranking de usuários

### Alertas de Comportamento Atípico
- Detecta quedas ou mudanças incomuns no uso
- Notificações automáticas
- Histórico de alertas para análise futura
- Baseado em análise estatística (desvio padrão)

### Análise de Conclusão de Serviços
- Acompanha jornadas (ex: inscrição, solicitação)
- Taxa de conclusão e etapas com maior abandono
- Visualização em funil

### Sinais Implícitos de Insatisfação
- Detecta longos períodos sem acesso e demora excessiva em tarefas
- Classificação de risco de churn: Baixo · Médio · Alto
- Timeline do usuário

### Taxa de Retorno do Usuário
- Analisa frequência de uso ao longo do tempo
- Identifica padrões de retenção
- Comparações entre períodos

---

## Diferencial do Projeto

Ao invés de perguntar "Você está satisfeito?", o sistema **observa o comportamento real** e transforma isso em métricas confiáveis: reduzindo viés de resposta, baixa participação e dados inconsistentes.