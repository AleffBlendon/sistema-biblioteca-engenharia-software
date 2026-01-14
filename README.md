📚 Sistema de Biblioteca — Processo de Engenharia de Software

Este projeto foi desenvolvido seguindo as boas práticas de Engenharia de Software, aplicando um processo estruturado desde o levantamento de requisitos até a implementação, testes e integração contínua.

A seguir é apresentado um resumo prático e passo a passo de como o processo foi conduzido.

1️⃣ Levantamento de Requisitos

O levantamento de requisitos foi realizado com base na análise das necessidades de um sistema básico de biblioteca.

Requisitos Funcionais

Cadastrar livros

Listar livros cadastrados

Atualizar informações de um livro

Excluir livros

Filtrar livros por autor, título, ano, preço e status

Requisitos Não Funcionais

Utilização de arquitetura em camadas

Persistência de dados em banco relacional

Uso de boas práticas de programação orientada a objetos

Testes automatizados

Integração contínua

Essa etapa foi essencial para definir o escopo do sistema e orientar todas as fases seguintes do desenvolvimento.

2️⃣ Análise do Sistema

Após o levantamento dos requisitos, foi realizada a análise do sistema para identificar:

Principais entidades do domínio

Responsabilidades de cada camada

Fluxo de interação entre usuário e sistema

A entidade central identificada foi Livro, representando o objeto principal do sistema.

3️⃣ Modelagem UML
🔹 Diagrama de Caso de Uso

O diagrama de caso de uso foi utilizado para representar as interações entre o usuário e o sistema, evidenciando as funcionalidades principais:

Cadastrar livro

Listar livros

Atualizar livro

Excluir livro

Filtrar livros

Esse diagrama facilita a compreensão do sistema sob a perspectiva do usuário.

🔹 Diagrama de Classes

O diagrama de classes foi elaborado seguindo a arquitetura em camadas:

Controller: responsável por receber requisições HTTP

Service: responsável pela lógica de negócio

Repository: responsável pelo acesso aos dados

Model: representação das entidades do sistema

Essa separação garante baixo acoplamento, alta coesão e facilidade de manutenção.

4️⃣ Arquitetura do Sistema

O sistema foi desenvolvido seguindo o padrão de arquitetura em camadas, amplamente utilizado na Engenharia de Software:

Controller → Service → Repository → Model

Cada camada possui uma responsabilidade bem definida

Facilita testes, manutenção e evolução do sistema

5️⃣ Implementação

A implementação foi realizada utilizando:

Java

Spring Boot

Spring Data JPA

MySQL

Maven

O código foi organizado de forma modular, seguindo padrões profissionais adotados no mercado de software.

6️⃣ Gerenciamento do Projeto

O gerenciamento do desenvolvimento foi realizado utilizando a metodologia Kanban, através do GitHub Projects.

As funcionalidades foram organizadas em issues

As tarefas passaram pelos estados: A Fazer, Em Andamento e Concluído

Commits foram associados às issues, garantindo rastreabilidade

Essa abordagem proporcionou maior controle e organização do desenvolvimento.

7️⃣ Testes Automatizados

Foram implementados testes automatizados utilizando JUnit, com o objetivo de:

Validar o funcionamento das funcionalidades principais

Garantir maior confiabilidade ao sistema

Reduzir riscos de falhas futuras

Os testes seguem o padrão do Maven, localizados em src/test/java.

8️⃣ Integração Contínua (CI)

Foi configurado um pipeline de Integração Contínua utilizando GitHub Actions.

O pipeline executa automaticamente:

Build do projeto

Execução dos testes automatizados

Sempre que há alterações no repositório principal, garantindo qualidade contínua do código.

9️⃣ Mudança de Escopo

Durante o desenvolvimento, foi realizada uma mudança de escopo no pipeline de CI:

Inicialmente executava apenas os testes

Posteriormente passou a executar mvn clean test, incluindo o build completo

Essa mudança aumentou a confiabilidade do processo de validação do sistema.

🔚 Conclusão

Este projeto demonstrou, de forma prática, a aplicação dos conceitos de Engenharia de Software, integrando:

Levantamento de requisitos

Modelagem UML

Arquitetura em camadas

Implementação orientada a objetos

Testes automatizados

Integração contínua

O resultado é um sistema organizado, confiável e alinhado às boas práticas do desenvolvimento de software.