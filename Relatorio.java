public class Relatorio {

    public GerenciadorClinica gerenciador;

    public Relatorio(GerenciadorClinica gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void menuRelatorios(Entrada entrada) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- RELATORIOS ---");
            System.out.println("1 - Relatorio geral de consultas");
            System.out.println("2 - Relatorio por profissional");
            System.out.println("3 - Relatorio por periodo");
            System.out.println("4 - Resumo financeiro");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) relatorioGeralConsultas();
            else if (opcao == 2) relatorioPorProfissional(entrada);
            else if (opcao == 3) relatorioPorPeriodo(entrada);
            else if (opcao == 4) resumoFinanceiro();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public void relatorioGeralConsultas() {
        if (gerenciador.qtdConsultas == 0) {
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }

        int agendadas = 0;
        int realizadas = 0;
        int canceladas = 0;
        int remarcadas = 0;
        int iniciais = 0;
        int retornos = 0;
        int avaliacoes = 0;
        double totalMultas = 0;

        for (int i = 0; i < gerenciador.qtdConsultas; i++) {
            Consulta consulta = gerenciador.consultas[i];
            if (consulta.status.equalsIgnoreCase("agendada")) agendadas++;
            else if (consulta.status.equalsIgnoreCase("realizada")) realizadas++;
            else if (consulta.status.equalsIgnoreCase("cancelada")) canceladas++;
            else if (consulta.status.equalsIgnoreCase("remarcada")) remarcadas++;

            if (consulta.tipo.equalsIgnoreCase("inicial")) iniciais++;
            else if (consulta.tipo.equalsIgnoreCase("retorno")) retornos++;
            else if (consulta.tipo.equalsIgnoreCase("avaliacao")) avaliacoes++;

            totalMultas = totalMultas + consulta.multa;
        }

        System.out.println("\n--- RELATORIO GERAL DE CONSULTAS ---");
        System.out.println("Total de consultas: " + gerenciador.qtdConsultas);
        System.out.println("Agendadas: " + agendadas);
        System.out.println("Realizadas: " + realizadas);
        System.out.println("Canceladas: " + canceladas);
        System.out.println("Remarcadas: " + remarcadas);
        System.out.println("Consultas iniciais: " + iniciais);
        System.out.println("Retornos: " + retornos);
        System.out.println("Avaliacoes: " + avaliacoes);
        System.out.println("Total de multas pendentes: R$ " + totalMultas);
    }

    public void relatorioPorProfissional(Entrada entrada) {
        String nome = entrada.lerTexto("Nome do profissional: ");
        int total = 0;
        int realizadas = 0;
        double faturado = 0;

        for (int i = 0; i < gerenciador.qtdConsultas; i++) {
            Consulta consulta = gerenciador.consultas[i];
            if (consulta.profissional.nome.equalsIgnoreCase(nome)) {
                consulta.mostrar();
                total++;
                if (consulta.status.equalsIgnoreCase("realizada")) realizadas++;
            }
        }

        for (int i = 0; i < gerenciador.qtdPagamentos; i++) {
            if (gerenciador.pagamentos[i].consulta.profissional.nome.equalsIgnoreCase(nome)) {
                faturado = faturado + gerenciador.pagamentos[i].valorFinal;
            }
        }

        System.out.println("\n--- RESUMO DO PROFISSIONAL ---");
        System.out.println("Total de consultas: " + total);
        System.out.println("Atendimentos realizados: " + realizadas);
        System.out.println("Valor faturado: R$ " + faturado);
    }

    public void relatorioPorPeriodo(Entrada entrada) {
        String inicio = entrada.lerTexto("Data inicial (DD/MM/AAAA): ");
        String fim = entrada.lerTexto("Data final (DD/MM/AAAA): ");
        boolean encontrou = false;

        System.out.println("\n--- RELATORIO POR PERIODO ---");
        System.out.println("Inicio: " + inicio + " | Fim: " + fim);
        System.out.println("Comparacao simples: mostra consultas iguais a uma das datas informadas.");

        for (int i = 0; i < gerenciador.qtdConsultas; i++) {
            Consulta consulta = gerenciador.consultas[i];
            if (consulta.data.equals(inicio) || consulta.data.equals(fim)) {
                consulta.mostrar();
                encontrou = true;
            }
        }

        if (!encontrou) System.out.println("Nenhuma consulta encontrada nessas datas.");
    }

    public void resumoFinanceiro() {
        int atendimentos = 0;
        int cancelamentos = 0;
        double faturado = 0;
        double multas = 0;

        for (int i = 0; i < gerenciador.qtdConsultas; i++) {
            if (gerenciador.consultas[i].status.equalsIgnoreCase("realizada")) atendimentos++;
            if (gerenciador.consultas[i].status.equalsIgnoreCase("cancelada")) cancelamentos++;
            multas = multas + gerenciador.consultas[i].multa;
        }

        for (int i = 0; i < gerenciador.qtdPagamentos; i++) {
            faturado = faturado + gerenciador.pagamentos[i].valorFinal;
        }

        System.out.println("\n--- RESUMO FINANCEIRO ---");
        System.out.println("Total de atendimentos realizados: " + atendimentos);
        System.out.println("Valor total faturado: R$ " + faturado);
        System.out.println("Quantidade de cancelamentos: " + cancelamentos);
        System.out.println("Total arrecadado em multas: R$ " + multas);
    }
}