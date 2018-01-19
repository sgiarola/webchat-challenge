# Webchat Challenge

# Overview

Back-end do desafio que permite bate-papo em tempo real entre amigos, assim como mensagens offline para aqueles amigos que não estã logados.
Essa estrurura consiste basicamente em uma "base" com Spring Boot, envolvendo:

- Spring Boot Web
- Spring Boot Websocket
- Sptring Boot Data MongoDB
- Spring Security
- Spring Boot Jetty
- Spring Security Messaging

Outras tecnologias auxiliares também foram utilizadas como Embedded MongoDB, Swagger, Gson, entre outras.

O desenho do projeto consiste em módulos do Maven separados por layer que evidenciam o nível de dependência entre cada um deles.
A camada não periférica de Business está coberta com testes unitários e a camada que integra com Banco de Dados (Repository) possui testes integrados com este para validar sua estrutura/consumo.

# Configuração

Para configurar este ambiente basta fazer um clone do projeto e na pasta raíz rodar o comando: mvn install.
Após realizar o install basta entrar na pasta webchat-app/target e rodar o comando: java -jar webchat-app-1.0-SNAPSHOT-spring-boot.

Outra forma de fazer a instalação do ambiente é entrar na pasta webchat-app e rodar o comando: mvn spring-boot:run.

# Utilização

O servidor sobe na porta 8080 sendo localhost mesmo e base resource /webchat.
O Swagger pode ser acessado via: http://localhost:8080/webchat/swagger-ui.html

A aplicação disponibiliza as funcionalidades de Login, Criação de Usuário (com auto-login), Logout, recuperação do usuário pelo username, adicionar amigo a este usuário, além de gerenciar suas mensagens (quando online ou offline) pelo canal do websocket.

Outra forma de utilização é pelo front-end, o qual foi criado em outro repositório (sgiarola/webchat-front-challenge) com instalação própria.
