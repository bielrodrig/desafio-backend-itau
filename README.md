# Desafio de Estágio Itaú – Sistema de Transferência Bancária

## 📋 Enunciado do Desafio

Desenvolva um algoritmo que execute operações de autenticação e, posteriormente, de uma transferência bancária, obedecendo aos seguintes critérios:

1. A base de dados local deve conter usuários emissores e receptores de uma transferência, seguindo o modelo;
2. A senha de autenticação deve conter 8 dígitos, caracteres especiais, letras maiúsculas e minúsculas;
3. O usuário deverá estar autenticado para realizar uma transferência;
4. Toda transferência deve ser feita entre um emissor e um receptor;
5. Operador e receptor iniciam a operação com um saldo de R$ 0,00;
6. As transferências deverão ser executadas de acordo com o seu tipo, sendo 3 dos seus tipos: PIX, TED e DOC;
7. O limite de valor máximo permitido para uma transferência via PIX é de R$ 5 mil;
8. Transferências via TED só são permitidas para valores acima de R$ 5 mil e até R$ 10 mil;
9. Transferências via DOC só são permitidas para valores acima de R$ 10 mil;
10. Não serão permitidas transferências para a mesma conta, mas um emissor pode transferir para ele mesmo se for para uma conta diferente;
11. As entradas deverão estar sempre com todos os dados ativos.

Desenvolva também um frontend simples (HTML) para que o aplicativo seja testado.

Ao final da operação, uma mensagem deverá ser exibida:

1 - Se a transferência for bem-sucedida, exibir mensagem de sucesso com o saldo do emissor e do receptor após a transferência, de acordo com o modelo:

Sua transferência foi realizada com sucesso!

Saldo do emissor: R$ X,XX

Saldo do receptor: R$X,XX

4. Se a transferência não for concluída, exibir mensagem de erro explicando o motivo, vide exemplo:

Sua transferência não foi concluída pois (escrever o motivo)

Escolha, dentre as opções de linguagens de programação abaixo, que se sinta mais confortável em desenvolver o algoritmo e pense nos casos de teste descritos acima!

1. Java

2. Swift

3. Kotlin

4. Typescript

Será observado o uso de boas práticas de programação, bem como a orientação a objetos e, se possível, a aplicação de padrões de projeto


## Sobre o Projeto

Este projeto foi desenvolvido como solução para um desafio de estágio do Itaú Unibanco afim de estudos referente a lógica de progamação, com o objetivo de implementar um sistema simples de autenticação e transferência bancária usando Java.

O foco principal foi a prática e o estudo de conceitos como:

- Programação orientada a objetos (POO)
- Boas práticas e separação em camadas (Modelo MVC adaptado)
- Interface gráfica com Java Swing
- Validação de regras de negócio (ex: tipos de transferência, limites, autenticação)
- Persistência com banco de dados MySQL via JDBC
- Empacotamento do sistema para distribuição via JAR executável

---

## Requisitos Atendidos

- Base de dados contendo usuários emissores e receptores
- Senha com validação para conter 8 dígitos, caracteres especiais, letras maiúsculas e minúsculas
- Autenticação obrigatória para realizar transferências
- Três tipos de transferência: PIX, TED e DOC, com limites específicos
- Restrição para não permitir transferência para a mesma conta (exceto entre contas diferentes do mesmo usuário)
- Interface gráfica para facilitar a interação e testes do sistema
- Mensagens claras de sucesso e erro para as operações

---

## Tecnologias Utilizadas

- **Java 8**: Linguagem principal de desenvolvimento
- **Swing**: Biblioteca para criação da interface gráfica
- **MySQL**: Banco de dados relacional para armazenamento dos usuários e saldos
- **Maven**: Gerenciamento de dependências e build do projeto

---

## Como Rodar o Projeto

### Pré-requisitos

- Java JDK 8 instalado
- MySQL configurado com banco e tabelas conforme modelo do projeto
- Maven instalado para build (opcional, caso queira compilar)
