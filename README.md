Sistema Bancário em Java

Aplicação de console desenvolvida em Java para simular operações bancárias básicas. O projeto utiliza programação orientada a objetos para representar contas, autenticar usuários e realizar movimentações financeiras.

Funcionalidades

Autenticação por agência, número da conta e senha

Consulta de saldo

Realização de depósitos

Realização de saques

Transferência entre contas cadastradas

Busca de conta por agência e número

Menu interativo executado no terminal

Tecnologias e conceitos

Java

Programação orientada a objetos

Encapsulamento

Classes e objetos

Métodos e construtores

List e ArrayList

Estruturas condicionais e de repetição

Entrada de dados com Scanner

Git e GitHub

Estrutura do projeto

Conta.java: representa uma conta bancária e contém os métodos de saque e depósito.

BancoServico.java: mantém a lista de contas cadastradas para utilização no sistema.

SistemaBancario.java: realiza a autenticação, exibe o menu e controla as operações bancárias.

Como executar

É necessário possuir o Java Development Kit (JDK) instalado.

Clone o repositório:

git clone https://github.com/WesleyDuarteS/Sistema-Bancario-java.git

Entre na pasta que contém os arquivos Java:

cd Sistema-Bancario-java/SistemaBancario/src

Compile os arquivos:

javac *.java

Execute o sistema:

java SistemaBancario

Também é possível abrir a pasta SistemaBancario no IntelliJ IDEA e executar a classe SistemaBancario.java.

Objetivo do projeto

Este projeto foi desenvolvido com finalidade acadêmica para praticar lógica de programação, programação orientada a objetos, coleções e organização de um sistema Java em diferentes classes.

Melhorias futuras

Persistência dos dados em banco de dados

Cadastro de novas contas pelo usuário

Histórico de transações

Tratamento de entradas inválidas

Testes automatizados

Interface gráfica ou aplicação web

Autor

Desenvolvido por Wesley Duarte.
