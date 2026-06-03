public class Atendimento {

    public String observacoes;
    public String diagnostico;
    public String[] procedimentos;
    public int qtdProcedimentos;

    public Atendimento(String observacoes) {
        this.observacoes = observacoes;
        this.diagnostico = "";
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
    }

    public Atendimento(String observacoes, String diagnostico) {
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
    }

    public Atendimento(String observacoes, String diagnostico, String[] procedimentos, int qtd) {
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.procedimentos = new String[10];
        this.qtdProcedimentos = 0;
        adicionarProcedimentos(procedimentos, qtd);
    }

    public void adicionarProcedimento(String procedimento) {
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

    public boolean temDiagnostico() {
        if (diagnostico != null && !diagnostico.equals("")) {
            return true;
        }
        return false;
    }

    public void mostrarResumo(Paciente paciente) {
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