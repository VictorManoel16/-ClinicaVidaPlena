public class Profissional {

    public String nome;
    public String especialidade;
    public String registroProfissional;
    public double valorConsulta;
    public String[] diasAtendimento;
    public int qtdDias;

    // Cadastro basico
    public Profissional(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = "";
        this.valorConsulta = 0;
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;
    }

    // Cadastro completo
    public Profissional(String nome, String especialidade, String registroProfissional, double valorConsulta, String[] dias, int qtdDiasInformados) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasAtendimento = new String[7];
        this.qtdDias = 0;

        for (int i = 0; i < qtdDiasInformados && i < 7; i++) {
            this.diasAtendimento[this.qtdDias] = dias[i];
            this.qtdDias++;
        }
    }

    public boolean especialidadeValida(String texto) {
        if (texto.equalsIgnoreCase("clinica geral")) {
            return true;
        }
        if (texto.equalsIgnoreCase("fisioterapia")) {
            return true;
        }
        if (texto.equalsIgnoreCase("psicologia")) {
            return true;
        }
        if (texto.equalsIgnoreCase("nutricao")) {
            return true;
        }
        return false;
    }

    // Sobrecarga de metodo para atualizar dados
    public void atualizarDados(String registroProfissional, double valorConsulta) {
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
    }

    public void atualizarDados(String registroProfissional, double valorConsulta, String[] dias, int qtdDiasInformados) {
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.qtdDias = 0;

        for (int i = 0; i < qtdDiasInformados && i < 7; i++) {
            this.diasAtendimento[this.qtdDias] = dias[i];
            this.qtdDias++;
        }
    }

    public boolean temValorConsulta() {
        if (valorConsulta > 0) {
            return true;
        }
        return false;
    }

    public boolean atendeNoDia(String dia) {
        for (int i = 0; i < qtdDias; i++) {
            if (diasAtendimento[i].equalsIgnoreCase(dia)) {
                return true;
            }
        }
        return false;
    }

    public void mostrar() {
        System.out.println("--------------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro profissional: " + registroProfissional);
        System.out.println("Valor da consulta: R$ " + valorConsulta);
        System.out.print("Dias de atendimento: ");
        if (qtdDias == 0) {
            System.out.println("nao informado");
        } else {
            for (int i = 0; i < qtdDias; i++) {
                System.out.print(diasAtendimento[i]);
                if (i < qtdDias - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}