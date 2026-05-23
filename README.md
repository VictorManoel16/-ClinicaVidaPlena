#  Clínica VidaPlena — Sistema de Gerenciamento Clínico

![STATUS](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-blue?style=for-the-badge)
![JAVA](https://img.shields.io/badge/JAVA-JDK%2021-orange?style=for-the-badge&logo=openjdk)
![PROJETO](https://img.shields.io/badge/PROJETO-ACADÊMICO-green?style=for-the-badge)

---

#  Visão Geral

O **Clínica VidaPlena** é um sistema desenvolvido em Java com execução via terminal, criado para simular o funcionamento operacional de uma clínica multidisciplinar.

A aplicação permite gerenciar pacientes, profissionais, consultas, atendimentos, pagamentos e relatórios administrativos, centralizando as principais operações da clínica em um único sistema.

O projeto foi construído utilizando exclusivamente conceitos fundamentais da linguagem Java, respeitando integralmente as restrições acadêmicas da disciplina.

---

# A Dor Resolvida

Clínicas de pequeno e médio porte frequentemente enfrentam problemas relacionados à organização de consultas, controle de pacientes e gerenciamento financeiro quando utilizam processos manuais ou sistemas descentralizados.

Isso pode gerar:

- conflitos de horários;
- perda de informações;
- falhas operacionais;
- lentidão no atendimento;
- dificuldades administrativas.

O sistema Clínica VidaPlena foi desenvolvido para resolver esses problemas através de um fluxo centralizado de gerenciamento clínico.

---

#  Objetivos do Projeto

- Gerenciar pacientes e profissionais;
- Realizar agendamentos de consultas;
- Registrar atendimentos médicos;
- Controlar pagamentos;
- Gerar relatórios operacionais;
- Simular o fluxo completo de uma clínica médica.

---

# Arquitetura e Decisões Técnicas

| Camada | Escolha | Motivo da Escolha | Alternativa Considerada | Impacto |
| --- | --- | --- | --- | --- |
| Linguagem | Java JDK 21 | Linguagem robusta e orientada a objetos | Python / C | Melhor organização do sistema |
| Interface | Terminal (Console) | Foco total na lógica de negócio | JavaFX / Swing | Desenvolvimento mais rápido |
| Persistência | Arrays Fixos | Atender às restrições acadêmicas | ArrayList / Banco de Dados | Exercício de manipulação manual |
| Estrutura | Programação Orientada a Objetos | Separação das entidades do sistema | Programação procedural | Melhor manutenção |
| Versionamento | Git + GitHub | Controle de versão e colaboração | Sem versionamento | Histórico e rastreabilidade |

---

# Tecnologias Utilizadas

- Java JDK 21
- Git
- GitHub
- Terminal / Console

---

# ⚙️ Funcionalidades

##  Pacientes
- Cadastro simples;
- Cadastro completo;
- Atualização de dados;
- Busca por CPF;
- Listagem de pacientes.

##  Profissionais
- Cadastro de profissionais;
- Atualização de informações;
- Controle de especialidades.

##  Consultas
- Agendamento;
- Cancelamento;
- Remarcação;
- Controle de status.

##  Pagamentos
- Registro de pagamentos;
- Controle de convênios;
- Aplicação de descontos.

## Relatórios
- Relatório geral;
- Relatório por profissional;
- Controle operacional.

---

#  Conceitos Aplicados

- Sobrecarga de construtores;
- Sobrecarga de métodos;
- Estruturas condicionais (`if/else`);
- Estruturas de repetição (`for`, `while`);
- Arrays fixos;
- Métodos com e sem retorno;
- Variáveis contadoras;
- Organização orientada a objetos.

---

#  Restrições Acadêmicas

O projeto respeita integralmente as restrições propostas pela disciplina.

| Restrição | Status |
| --- | --- |
| Sem Herança | |
| Sem Interfaces | |
| Sem Classes Abstratas |  |
| Sem Collections |  |
| Sem Bibliotecas Externas | |
| Sem Encapsulamento |  |

> Os atributos foram mantidos públicos devido às restrições acadêmicas exigidas no projeto.

---

#  Estrutura do Projeto

```bash
Main.java
Sistema.java
Paciente.java
Profissional.java
Consulta.java
Pagamento.java
```

---

#  Demonstração

O sistema simula operações reais de uma clínica médica via terminal.

## Fluxos implementados

- Cadastro de pacientes;
- Cadastro de profissionais;
- Agendamento de consultas;
- Registro de atendimentos;
- Controle financeiro;
- Relatórios administrativos.

> O fluxo principal pode ser validado diretamente através do menu principal da aplicação.

---

#  Destaque de Engenharia / The Hard Part

Um dos maiores desafios foi implementar o gerenciamento completo das consultas utilizando apenas arrays fixos, sem uso de collections como `ArrayList`.

```java
public void agendarConsulta(Paciente paciente, Profissional profissional, String data, String hora) {

    if (paciente == null || profissional == null) {
        System.out.println("Paciente ou profissional inválido.");
        return;
    }

    Consulta novaConsulta = new Consulta(
        paciente,
        profissional,
        data,
        hora,
        "Consulta",
        "Agendada"
    );

    consultas[contadorConsultas] = novaConsulta;
    contadorConsultas++;

    System.out.println("Consulta agendada com sucesso!");
}
```

## Desafios Técnicos

- Controle manual dos arrays;
- Organização das entidades;
- Validação de dados;
- Controle de armazenamento;
- Fluxo operacional completo.

---

#  Insights e Valor de Negócio

## Para operação da clínica

- Centralização das informações;
- Melhor organização dos atendimentos;
- Redução de conflitos de horários;
- Facilidade na busca de pacientes.

## Para gestão

- Controle financeiro básico;
- Melhor rastreabilidade operacional;
- Organização administrativa.

## Para evolução futura

A estrutura atual permite futuras implementações como:

- banco de dados;
- autenticação;
- interface gráfica;
- APIs REST;
- relatórios em PDF.

---

# Instalação e Execução

## 1️Clone o repositório

```bash
git clone https://github.com/seu-usuario/ClinicaVidaPlena.git
```

## 2️Entre na pasta do projeto

```bash
cd ClinicaVidaPlena
```

## 3️Compile os arquivos

```bash
javac *.java
```

## 4️Execute o sistema

```bash
java Main
```

---

#  Uso

- Execute a aplicação via terminal;
- Navegue pelos menus;
- Cadastre pacientes e profissionais;
- Agende consultas;
- Gere relatórios administrativos.

---

#  Roadmap / Próximos Passos

## Melhorias Futuras

- Interface gráfica com JavaFX;
- Integração com banco de dados;
- Persistência de dados;
- Sistema de login;
- Exportação de relatórios;
- Dashboard administrativo;
- API REST.

---

#  Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

- Estruturação de sistemas em Java;
- Organização modular;
- Regras de negócio;
- Manipulação de arrays fixos;
- Controle operacional;
- Versionamento com Git e GitHub.

---

# Desenvolvedores

- Victor Manoel da Silva  


---

# Licença

Projeto desenvolvido exclusivamente para fins acadêmicos.
