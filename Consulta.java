public class Consulta {

    public Paciente paciente;
    public Profissional profissional;
    public String data;
    public String diaSemana;
    public String horario;
    public String tipo;
    public String status;
    public String observacoes;
    public String diagnostico;
    public String[] procedimentos;
    public int qtdProcedimentos;
    public Atendimento atendimento;
    public double multa;
    public String justificativaCancelamento;

    // Quando o tipo nao for informado, sera inicial
    public Consulta(Paciente paciente, Profissional profissional, String data, String diaSemana, String horario) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.tipo = "inicial";
        this.status = "agendada";
        this.observacoes = "";
        this.diagnostico = "";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
        this.atendimento = null;
        this.multa = 0;
        this.justificativaCancelamento = "";
    }

    public Consulta(Paciente paciente, Profissional profissional, String data, String diaSemana, String horario, String tipo) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.tipo = tipo;
        this.status = "agendada";
        this.observacoes = "";
        this.diagnostico = "";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
        this.atendimento = null;
        this.multa = 0;
        this.justificativaCancelamento = "";
    }

    public boolean tipoValido(String tipo) {
        if (tipo.equalsIgnoreCase("inicial")) {
            return true;
        }
        if (tipo.equalsIgnoreCase("retorno")) {
            return true;
        }
        if (tipo.equalsIgnoreCase("avaliacao")) {
            return true;
        }
        return false;
    }

    public boolean verificarConflito(Consulta outraConsulta) {
        if (profissional.nome.equalsIgnoreCase(outraConsulta.profissional.nome)
                && data.equals(outraConsulta.data)
                && horario.equals(outraConsulta.horario)
                && outraConsulta.status.equals("agendada")) {
            return true;
        }
        return false;
    }

    public String sugerirHorarioLivre(Consulta[] consultas, int contador) {
        String[] horarios = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};

        for (int i = 0; i < 11; i++) {
            boolean ocupado = false;

            for (int j = 0; j < contador; j++) {
                if (consultas[j].profissional.nome.equalsIgnoreCase(profissional.nome)
                        && consultas[j].data.equals(data)
                        && consultas[j].horario.equals(horarios[i])
                        && consultas[j].status.equals("agendada")) {
                    ocupado = true;
                }
            }

            if (!ocupado) {
                return horarios[i];
            }
        }

        return "nenhum horario livre";
    }

    // Sobrecarga de metodos de atendimento
    public void registrarAtendimento(String observacoes) {
        this.atendimento = new Atendimento(observacoes);
        this.observacoes = observacoes;
        this.status = "realizada";
    }

    public void registrarAtendimento(String observacoes, String diagnostico) {
        this.atendimento = new Atendimento(observacoes, diagnostico);
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.status = "realizada";
    }

    public void registrarAtendimento(String observacoes, String diagnostico, String[] procedimentos, int qtd) {
        this.atendimento = new Atendimento(observacoes, diagnostico);
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        adicionarProcedimentos(procedimentos, qtd);
        this.status = "realizada";
    }

    public void adicionarProcedimento(String procedimento) {
        if (atendimento != null) {
            atendimento.adicionarProcedimento(procedimento);
        }

        if (qtdProcedimentos < 10) {
            procedimentos[qtdProcedimentos] = procedimento;
            qtdProcedimentos++;
        } else {
            System.out.println("Limite de 10 procedimentos atingido.");
        }
    }

    public void adicionarProcedimentos(String[] novosProcedimentos, int qtd) {
        for (int i = 0; i < qtd; i++) {
            adicionarProcedimento(novosProcedimentos[i]);
        }
    }

    public void cancelar(String justificativa, double multa) {
        this.status = "cancelada";
        this.justificativaCancelamento = justificativa;
        this.multa = multa;
    }

    public void remarcar(String novaData, String novoDiaSemana, String novoHorario) {
        this.data = novaData;
        this.diaSemana = novoDiaSemana;
        this.horario = novoHorario;
        this.status = "remarcada";
    }

    public void mostrar() {
        System.out.println("--------------------------------");
        System.out.println("Paciente: " + paciente.nome + " | CPF: " + paciente.cpf);
        System.out.println("Profissional: " + profissional.nome + " | " + profissional.especialidade);
        System.out.println("Data: " + data + " | Dia: " + diaSemana + " | Horario: " + horario);
        System.out.println("Tipo: " + tipo);
        System.out.println("Status: " + status);
        if (multa > 0) {
            System.out.println("Multa pendente: R$ " + multa);
        }
    }

    public void mostrarResumoAtendimento() {
        if (atendimento != null) {
            atendimento.mostrarResumo(paciente);
            return;
        }

        System.out.println("--------------------------------");
        System.out.println("Resumo do atendimento");
        System.out.println("Paciente: " + paciente.nome);
        System.out.println("Observacoes: " + observacoes);
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Procedimentos:");
        if (qtdProcedimentos == 0) {
            System.out.println("Nenhum procedimento informado.");
        } else {
            for (int i = 0; i < qtdProcedimentos; i++) {
                System.out.println("- " + procedimentos[i]);
            }
        }
    }
}