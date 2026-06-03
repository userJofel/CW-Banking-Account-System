# CW Banking Account System (Desafio da Semana)

Sistema bancário feito em **Java**, usando **Programação Orientada a Objetos** e execução pelo terminal.

## Sobre

O projeto simula um sistema simples de conta bancária, onde o usuário pode criar uma conta, fazer login e realizar operações básicas.

## Funcionalidades

- Criar conta
- Fazer login
- Consultar saldo
- Depositar dinheiro
- Sacar dinheiro
- Ver histórico de movimentações
- Encerrar sessão
- Bloquear login após muitas tentativas erradas

## Estrutura

```txt
src/Banking
├── app
│   └── Main.java
├── model
│   ├── Conta.java
│   └── Movimentacao.java
└── service
    └── ContaService.java