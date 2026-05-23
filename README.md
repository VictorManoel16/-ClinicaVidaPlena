# -ClinicaVidaPlena

1. Visão Geral e a Dor

O sistema Clínica VidaPlena foi desenvolvido para resolver problemas comuns encontrados em clínicas de pequeno e médio porte que ainda utilizam processos manuais para controle de pacientes, consultas e pagamentos.

A ausência de organização centralizada pode gerar:

perda de informações clínicas;
dificuldade no controle financeiro;
conflitos de horários;
lentidão no atendimento;
falhas operacionais em agendamentos.

O projeto simula o funcionamento de uma clínica multidisciplinar através de uma aplicação Java executada via terminal, permitindo o gerenciamento completo das operações essenciais da clínica.

Problemas resolvidos
Cadastro organizado de pacientes;
Controle de profissionais;
Agendamento de consultas;
Registro de atendimentos;
Controle financeiro básico;
Relatórios operacionais.
Público impactado
Clínicas médicas;
Secretarias;
Recepção;
Profissionais da saúde;
Administração da clínica.
Impacto para o negócio

O sistema reduz falhas humanas, melhora a organização dos atendimentos e centraliza as informações da clínica em um único fluxo operacional.

2. Arquitetura e Decisões Técnicas
Camada	Escolha	Por que escolhi isso?	Alternativa considerada	Nota de impacto
Linguagem	Java JDK 21	Linguagem robusta e fortemente tipada para construção do sistema	C / Python	Melhor organização e escalabilidade
Interface	Terminal (Console)	Atender às restrições acadêmicas e focar na lógica de negócio	JavaFX / Swing	Desenvolvimento rápido e foco na regra de negócio
Persistência	Arrays Fixos	Restrição da disciplina	ArrayList / Banco de Dados	Exercício de manipulação manual de memória
Versionamento	Git + GitHub	Controle de versões e colaboração	Sem versionamento	Melhor rastreabilidade
Arquitetura	Programação Orientada a Objetos básica	Organização modular das entidades	Frameworks avançados	Clareza e simplicidade
3. Demonstração
Fluxos implementados
Cadastro de pacientes;
Cadastro de profissionais;
Agendamento de consultas;
Cancelamento e remarcação;
Registro de atendimentos;
Controle de pagamentos;
Relatórios gerais e financeiros.
Estrutura principal do sistema
Main.java
Sistema.java
Paciente.java
Profissional.java
Consulta.java
Pagamento.java

O sistema foi desenvolvido para execução completa via terminal, simulando operações reais de uma clínica médica.

4. Destaque de Engenharia / “The Hard Part”

Um dos principais desafios do projeto foi implementar o controle de consultas utilizando apenas arrays fixos e lógica manual, sem utilização de collections como ArrayList.

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
Desafios enfrentados
Controle manual de posições nos arrays;
Validação de dados;
Organização do fluxo do sistema;
Controle de limites de armazenamento;
Estruturação modular sem frameworks.
Resultado

Foi possível construir um sistema funcional completo respeitando todas as restrições acadêmicas propostas.

5. Insights e Valor de Negócio
Para operação da clínica
Organização centralizada das informações;
Melhor controle de consultas;
Redução de conflitos de agendamento;
Facilidade na busca de pacientes.
Para gestão
Controle financeiro básico;
Relatórios operacionais;
Visão geral dos atendimentos realizados.
Para evolução futura

A estrutura do projeto permite expansão futura para:

banco de dados;
interface gráfica;
autenticação;
APIs REST;
integração com sistemas hospitalares.
6. Instruções de Instalação e Uso
Clonar o projeto
git clone https://github.com/seu-usuario/ClinicaVidaPlena.git
Acessar a pasta
cd ClinicaVidaPlena
Compilar os arquivos
javac *.java
Executar o sistema
java Main
7. Conceitos Aplicados
Sobrecarga de construtores;
Sobrecarga de métodos;
Estruturas condicionais (if/else);
Estruturas de repetição (for, while);
Arrays de tamanho fixo;
Métodos com e sem retorno;
Variáveis contadoras;
Organização orientada a objetos.
8. Restrições Acadêmicas

O projeto respeita integralmente as restrições propostas pela disciplina:

Não utilização de herança;
Não utilização de interfaces;
Não utilização de classes abstratas;
Não utilização de collections;
Não utilização de bibliotecas externas;
Atributos públicos devido às restrições acadêmicas.
9. Roadmap / Próximos Passos
Melhorias futuras
Interface gráfica com JavaFX;
Integração com banco de dados;
Sistema de login;
Persistência de dados;
Exportação de relatórios em PDF;
Dashboard administrativo;
API REST para integração externa.
10. Desenvolvedores
Victor Manoel da Silva
