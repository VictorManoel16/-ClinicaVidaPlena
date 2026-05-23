# 🏥 Clínica VidaPlena — Sistema de Gerenciamento Clínico

![STATUS](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-blue?style=for-the-badge)

## 1. Visão Geral e a Dor

Clínicas de pequeno e médio porte frequentemente enfrentam problemas relacionados à organização de pacientes, consultas, atendimentos e controle financeiro quando utilizam processos manuais ou sistemas pouco integrados.

A falta de centralização das informações pode gerar:

- conflitos de horários;
- perda de dados importantes;
- lentidão no atendimento;
- dificuldades no controle financeiro;
- falhas operacionais.

O sistema **Clínica VidaPlena** foi desenvolvido para resolver esse problema através de uma aplicação Java executada via terminal, simulando o fluxo operacional de uma clínica multidisciplinar.

### O que está sendo resolvido?

- Organização de pacientes;
- Controle de profissionais;
- Gerenciamento de consultas;
- Registro de atendimentos;
- Controle de pagamentos;
- Relatórios administrativos.

### Quem sofre com esse problema?

- Clínicas médicas;
- Secretarias;
- Recepcionistas;
- Profissionais da saúde;
- Administração da clínica.

### Por que isso importa para o negócio?

Um sistema organizado reduz erros operacionais, melhora o atendimento ao paciente e centraliza as informações da clínica em um único fluxo de gerenciamento.

---

## 2. Arquitetura e Decisões Técnicas

O projeto foi construído utilizando apenas conceitos fundamentais da linguagem Java, respeitando integralmente as restrições acadêmicas propostas.

| Camada | Escolha | Por que escolhi isso? | Alternativa considerada | Nota de impacto |
| --- | --- | --- | --- | --- |
| Linguagem | Java JDK 21 | Linguagem robusta e fortemente tipada | Python / C | Melhor organização do sistema |
| Interface | Terminal (Console) | Foco total na lógica de negócio | JavaFX / Swing | Desenvolvimento mais rápido |
| Persistência | Arrays Fixos | Atender às restrições acadêmicas | ArrayList / Banco de Dados | Exercício de manipulação manual |
| Estrutura | Programação Orientada a Objetos | Organização modular das entidades | Programação procedural | Melhor separação de responsabilidades |
| Versionamento | Git + GitHub | Controle de versão e colaboração | Sem versionamento | Rastreabilidade e histórico |

---

## 3. Demonstração

O sistema possui funcionalidades completas de gerenciamento clínico via terminal.

### Fluxos implementados

- Cadastro de pacientes;
- Cadastro de profissionais;
- Agendamento de consultas;
- Cancelamento e remarcação;
- Registro de atendimentos;
- Controle de pagamentos;
- Relatórios gerais.

### Estrutura principal do projeto

```bash
Main.java
Sistema.java
Paciente.java
Profissional.java
Consulta.java
Pagamento.java
