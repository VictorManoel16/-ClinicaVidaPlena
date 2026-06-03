public class GerenciadorClinica {

    public Entrada entrada;
    public Paciente[] pacientes = new Paciente[100];
    public int qtdPacientes = 0;
    public Profissional[] profissionais = new Profissional[50];
    public int qtdProfissionais = 0;
    public Consulta[] consultas = new Consulta[200];
    public int qtdConsultas = 0;
    public Pagamento[] pagamentos = new Pagamento[200];
    public int qtdPagamentos = 0;

    public GerenciadorClinica(Entrada entrada) {
        this.entrada = entrada;
    }

    public void menuPacientes() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- PACIENTES ---");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Complementar cadastro");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Listar pacientes");
            System.out.println("5 - Desativar paciente");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) cadastrarPaciente();
            else if (opcao == 2) complementarPaciente();
            else if (opcao == 3) buscarPacienteMenu();
            else if (opcao == 4) listarPacientes();
            else if (opcao == 5) desativarPaciente();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public void cadastrarPaciente() {
        if (qtdPacientes >= pacientes.length) {
            System.out.println("Limite de pacientes atingido.");
            return;
        }

        System.out.println("\n1 - Cadastro rapido");
        System.out.println("2 - Cadastro intermediario");
        System.out.println("3 - Cadastro completo");
        int tipo = entrada.lerInteiro("Escolha: ");
        String nome = entrada.lerTexto("Nome: ");
        String cpf = entrada.lerTexto("CPF: ");

        if (buscarPacientePorCpf(cpf) != null) {
            System.out.println("Ja existe paciente cadastrado com este CPF.");
            return;
        }

        if (tipo == 1) {
            pacientes[qtdPacientes] = new Paciente(nome, cpf);
        } else if (tipo == 2) {
            int idade = entrada.lerInteiro("Idade: ");
            String telefone = entrada.lerTexto("Telefone: ");
            pacientes[qtdPacientes] = new Paciente(nome, cpf, idade, telefone);
        } else if (tipo == 3) {
            int idade = entrada.lerInteiro("Idade: ");
            String telefone = entrada.lerTexto("Telefone: ");
            String convenio = entrada.lerTexto("Convenio: ");
            pacientes[qtdPacientes] = new Paciente(nome, cpf, idade, telefone, convenio);
        } else {
            System.out.println("Tipo de cadastro invalido.");
            return;
        }

        qtdPacientes++;
        System.out.println("Paciente cadastrado.");
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        for (int i = 0; i < qtdPacientes; i++) {
            if (pacientes[i].cpf.equals(cpf)) {
                return pacientes[i];
            }
        }
        return null;
    }

    public void buscarPacienteMenu() {
        Paciente paciente = buscarPacientePorCpf(entrada.lerTexto("CPF: "));
        if (paciente == null) System.out.println("Paciente nao encontrado.");
        else paciente.mostrar();
    }

    public void listarPacientes() {
        if (qtdPacientes == 0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        for (int i = 0; i < qtdPacientes; i++) {
            pacientes[i].mostrar();
        }
    }

    public void complementarPaciente() {
        Paciente paciente = buscarPacientePorCpf(entrada.lerTexto("CPF do paciente: "));
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
            return;
        }

        System.out.println("1 - Idade e telefone");
        System.out.println("2 - Idade, telefone e convenio");
        int opcao = entrada.lerInteiro("Escolha: ");
        int idade = entrada.lerInteiro("Idade: ");
        String telefone = entrada.lerTexto("Telefone: ");

        if (opcao == 1) {
            paciente.complementarCadastro(idade, telefone);
            System.out.println("Cadastro atualizado.");
        } else if (opcao == 2) {
            String convenio = entrada.lerTexto("Convenio: ");
            paciente.complementarCadastro(idade, telefone, convenio);
            System.out.println("Cadastro atualizado.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    public void desativarPaciente() {
        Paciente paciente = buscarPacientePorCpf(entrada.lerTexto("CPF do paciente: "));
        if (paciente == null) System.out.println("Paciente nao encontrado.");
        else {
            paciente.desativar();
            System.out.println("Paciente desativado.");
        }
    }

    public void menuProfissionais() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- PROFISSIONAIS ---");
            System.out.println("1 - Cadastrar profissional");
            System.out.println("2 - Atualizar profissional");
            System.out.println("3 - Listar profissionais");
            System.out.println("4 - Filtrar por especialidade");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) cadastrarProfissional();
            else if (opcao == 2) atualizarProfissional();
            else if (opcao == 3) listarProfissionais();
            else if (opcao == 4) filtrarProfissionaisPorEspecialidade();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public boolean especialidadeAceita(String especialidade) {
        Profissional teste = new Profissional("teste", "clinica geral");
        return teste.especialidadeValida(especialidade);
    }

    public void cadastrarProfissional() {
        if (qtdProfissionais >= profissionais.length) {
            System.out.println("Limite de profissionais atingido.");
            return;
        }

        System.out.println("Especialidades aceitas: clinica geral, fisioterapia, psicologia, nutricao");
        System.out.println("1 - Cadastro basico");
        System.out.println("2 - Cadastro completo");
        int tipo = entrada.lerInteiro("Escolha: ");
        String nome = entrada.lerTexto("Nome: ");
        String especialidade = entrada.lerTexto("Especialidade: ");

        if (!especialidadeAceita(especialidade)) {
            System.out.println("Especialidade invalida.");
            return;
        }

        if (tipo == 1) {
            profissionais[qtdProfissionais] = new Profissional(nome, especialidade);
        } else if (tipo == 2) {
            String registro = entrada.lerTexto("Registro profissional: ");
            double valor = entrada.lerDouble("Valor da consulta: ");
            String[] dias = lerDias();
            profissionais[qtdProfissionais] = new Profissional(nome, especialidade, registro, valor, dias, contarDias(dias));
        } else {
            System.out.println("Opcao invalida.");
            return;
        }

        qtdProfissionais++;
        System.out.println("Profissional cadastrado.");
    }

    public String[] lerDias() {
        String[] dias = new String[7];
        int qtd = entrada.lerInteiro("Quantos dias de atendimento? ");
        if (qtd > 7) qtd = 7;
        if (qtd < 0) qtd = 0;

        for (int i = 0; i < qtd; i++) {
            dias[i] = entrada.lerTexto("Dia " + (i + 1) + ": ");
        }
        return dias;
    }

    public int contarDias(String[] dias) {
        int qtd = 0;
        for (int i = 0; i < dias.length; i++) {
            if (dias[i] != null && !dias[i].equals("")) qtd++;
        }
        return qtd;
    }

    public Profissional escolherProfissional() {
        if (qtdProfissionais == 0) {
            System.out.println("Nenhum profissional cadastrado.");
            return null;
        }

        for (int i = 0; i < qtdProfissionais; i++) {
            System.out.println((i + 1) + " - " + profissionais[i].nome + " (" + profissionais[i].especialidade + ")");
        }

        int posicao = entrada.lerInteiro("Escolha o profissional: ") - 1;
        if (posicao < 0 || posicao >= qtdProfissionais) {
            System.out.println("Profissional invalido.");
            return null;
        }
        return profissionais[posicao];
    }

    public void atualizarProfissional() {
        Profissional profissional = escolherProfissional();
        if (profissional == null) return;

        System.out.println("1 - Registro e valor da consulta");
        System.out.println("2 - Registro, valor da consulta e dias de atendimento");
        int opcao = entrada.lerInteiro("Escolha: ");
        String registro = entrada.lerTexto("Registro profissional: ");
        double valor = entrada.lerDouble("Valor da consulta: ");

        if (opcao == 1) profissional.atualizarDados(registro, valor);
        else if (opcao == 2) {
            String[] dias = lerDias();
            profissional.atualizarDados(registro, valor, dias, contarDias(dias));
        } else {
            System.out.println("Opcao invalida.");
            return;
        }
        System.out.println("Profissional atualizado.");
    }

    public void listarProfissionais() {
        if (qtdProfissionais == 0) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }
        for (int i = 0; i < qtdProfissionais; i++) profissionais[i].mostrar();
    }

    public void filtrarProfissionaisPorEspecialidade() {
        String especialidade = entrada.lerTexto("Especialidade: ");
        boolean encontrou = false;
        for (int i = 0; i < qtdProfissionais; i++) {
            if (profissionais[i].especialidade.equalsIgnoreCase(especialidade)) {
                profissionais[i].mostrar();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum profissional encontrado nessa especialidade.");
    }

    public void menuConsultas() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- CONSULTAS ---");
            System.out.println("1 - Agendar consulta");
            System.out.println("2 - Agendamento automatico por especialidade");
            System.out.println("3 - Listar consultas");
            System.out.println("4 - Buscar por CPF do paciente");
            System.out.println("5 - Cancelar consulta");
            System.out.println("6 - Remarcar consulta");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) agendarConsulta();
            else if (opcao == 2) agendarAutomatico();
            else if (opcao == 3) listarConsultas();
            else if (opcao == 4) buscarConsultasPorCpf();
            else if (opcao == 5) cancelarConsulta();
            else if (opcao == 6) remarcarConsulta();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public boolean horarioOcupado(Profissional profissional, String data, String horario) {
        for (int i = 0; i < qtdConsultas; i++) {
            if (consultas[i].profissional.nome.equalsIgnoreCase(profissional.nome)
                    && consultas[i].data.equals(data)
                    && consultas[i].horario.equals(horario)
                    && consultas[i].status.equals("agendada")) {
                return true;
            }
        }
        return false;
    }

    public void agendarConsulta() {
        if (qtdConsultas >= consultas.length) {
            System.out.println("Limite de consultas atingido.");
            return;
        }

        Paciente paciente = buscarPacientePorCpf(entrada.lerTexto("CPF do paciente: "));
        if (!pacientePodeAgendar(paciente)) return;

        Profissional profissional = escolherProfissional();
        if (!profissionalPodeAgendar(profissional)) return;

        String data = entrada.lerTexto("Data (DD/MM/AAAA): ");
        String diaSemana = entrada.lerTexto("Dia da semana: ");
        if (!profissional.atendeNoDia(diaSemana)) {
            System.out.println("Profissional nao atende nesse dia.");
            return;
        }

        String horario = entrada.lerTexto("Horario (exemplo 08:00): ");
        String tipo = entrada.lerTexto("Tipo (enter para inicial): ");
        Consulta novaConsulta = criarConsulta(paciente, profissional, data, diaSemana, horario, tipo);
        if (novaConsulta == null) return;

        if (horarioOcupado(profissional, data, horario)) {
            System.out.println("Horario ocupado.");
            System.out.println("Sugestao: " + novaConsulta.sugerirHorarioLivre(consultas, qtdConsultas));
            return;
        }

        consultas[qtdConsultas] = novaConsulta;
        qtdConsultas++;
        System.out.println("Consulta agendada.");
    }

    public boolean pacientePodeAgendar(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
            return false;
        }
        if (!paciente.ativo) {
            System.out.println("Paciente inativo nao pode agendar consulta.");
            return false;
        }
        return true;
    }

    public boolean profissionalPodeAgendar(Profissional profissional) {
        if (profissional == null) return false;
        if (!profissional.temValorConsulta()) {
            System.out.println("Profissional sem valor de consulta definido.");
            return false;
        }
        return true;
    }

    public Consulta criarConsulta(Paciente paciente, Profissional profissional, String data, String dia, String horario, String tipo) {
        Consulta consulta;
        if (tipo.equals("")) consulta = new Consulta(paciente, profissional, data, dia, horario);
        else consulta = new Consulta(paciente, profissional, data, dia, horario, tipo);

        if (!consulta.tipoValido(consulta.tipo)) {
            System.out.println("Tipo invalido. Use inicial, retorno ou avaliacao.");
            return null;
        }
        return consulta;
    }

    public void agendarAutomatico() {
        if (qtdConsultas >= consultas.length) {
            System.out.println("Limite de consultas atingido.");
            return;
        }

        Paciente paciente = buscarPacientePorCpf(entrada.lerTexto("CPF do paciente: "));
        if (!pacientePodeAgendar(paciente)) return;

        String especialidade = entrada.lerTexto("Especialidade: ");
        String data = entrada.lerTexto("Data (DD/MM/AAAA): ");
        String diaSemana = entrada.lerTexto("Dia da semana: ");
        String horario = entrada.lerTexto("Horario: ");
        String tipo = entrada.lerTexto("Tipo (enter para inicial): ");

        for (int i = 0; i < qtdProfissionais; i++) {
            if (profissionais[i].especialidade.equalsIgnoreCase(especialidade)
                    && profissionais[i].temValorConsulta()
                    && profissionais[i].atendeNoDia(diaSemana)
                    && !horarioOcupado(profissionais[i], data, horario)) {
                Consulta consulta = criarConsulta(paciente, profissionais[i], data, diaSemana, horario, tipo);
                if (consulta == null) return;
                consultas[qtdConsultas] = consulta;
                qtdConsultas++;
                System.out.println("Consulta agendada com " + profissionais[i].nome + ".");
                return;
            }
        }
        System.out.println("Nenhum profissional disponivel para esses dados.");
    }

    public void listarConsultas() {
        if (qtdConsultas == 0) {
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        for (int i = 0; i < qtdConsultas; i++) {
            System.out.println("Codigo: " + (i + 1));
            consultas[i].mostrar();
        }
    }

    public void buscarConsultasPorCpf() {
        String cpf = entrada.lerTexto("CPF do paciente: ");
        boolean encontrou = false;
        for (int i = 0; i < qtdConsultas; i++) {
            if (consultas[i].paciente.cpf.equals(cpf)) {
                consultas[i].mostrar();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhuma consulta encontrada.");
    }

    public Consulta escolherConsulta() {
        if (qtdConsultas == 0) {
            System.out.println("Nenhuma consulta cadastrada.");
            return null;
        }
        listarConsultas();
        int posicao = entrada.lerInteiro("Codigo da consulta: ") - 1;
        if (posicao < 0 || posicao >= qtdConsultas) {
            System.out.println("Consulta invalida.");
            return null;
        }
        return consultas[posicao];
    }

    public void cancelarConsulta() {
        Consulta consulta = escolherConsulta();
        if (consulta == null) return;

        if (consulta.status.equals("realizada")) {
            System.out.println("Consulta realizada nao pode ser cancelada.");
            return;
        }
        if (consulta.status.equals("cancelada")) {
            System.out.println("Consulta ja esta cancelada.");
            return;
        }

        String justificativa = entrada.lerTexto("Justificativa (enter para deixar sem): ");
        String menosDuasHoras = entrada.lerTexto("Faltam menos de 2 horas? (s/n): ");
        double multa = 0;
        if (menosDuasHoras.equalsIgnoreCase("s")) multa = 50;

        consulta.cancelar(justificativa, multa);
        System.out.println("Consulta cancelada.");
        if (multa > 0) System.out.println("Multa aplicada: R$ 50.0");
    }

    public void remarcarConsulta() {
        Consulta consulta = escolherConsulta();
        if (consulta == null) return;
        if (!consulta.status.equals("agendada")) {
            System.out.println("Somente consulta agendada pode ser remarcada.");
            return;
        }

        System.out.println("1 - Mudar apenas horario");
        System.out.println("2 - Mudar data e horario");
        int opcao = entrada.lerInteiro("Escolha: ");
        String novaData = consulta.data;
        String novoDia = consulta.diaSemana;

        if (opcao == 2) {
            novaData = entrada.lerTexto("Nova data (DD/MM/AAAA): ");
            novoDia = entrada.lerTexto("Novo dia da semana: ");
        } else if (opcao != 1) {
            System.out.println("Opcao invalida.");
            return;
        }

        String novoHorario = entrada.lerTexto("Novo horario: ");
        if (!consulta.profissional.atendeNoDia(novoDia)) {
            System.out.println("Profissional nao atende nesse dia.");
            return;
        }
        if (horarioOcupado(consulta.profissional, novaData, novoHorario)) {
            System.out.println("Horario ocupado.");
            return;
        }
        if (qtdConsultas >= consultas.length) {
            System.out.println("Limite de consultas atingido.");
            return;
        }

        consulta.status = "remarcada";
        consultas[qtdConsultas] = new Consulta(consulta.paciente, consulta.profissional, novaData, novoDia, novoHorario, consulta.tipo);
        qtdConsultas++;
        System.out.println("Consulta remarcada e nova consulta criada.");
    }

    public void menuAtendimentos() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- ATENDIMENTOS ---");
            System.out.println("1 - Registrar atendimento");
            System.out.println("2 - Adicionar procedimento em consulta realizada");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) registrarAtendimento();
            else if (opcao == 2) adicionarProcedimentoDepois();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public void registrarAtendimento() {
        Consulta consulta = escolherConsulta();
        if (consulta == null) return;
        if (!consulta.status.equals("agendada")) {
            System.out.println("So pode registrar atendimento de consulta agendada.");
            return;
        }

        System.out.println("1 - Apenas observacoes");
        System.out.println("2 - Observacoes e diagnostico");
        System.out.println("3 - Observacoes, diagnostico e procedimentos");
        int tipo = entrada.lerInteiro("Escolha: ");
        String observacoes = entrada.lerTexto("Observacoes: ");

        if (tipo == 1) {
            consulta.registrarAtendimento(observacoes);
        } else if (tipo == 2) {
            String diagnostico = entrada.lerTexto("Diagnostico: ");
            consulta.registrarAtendimento(observacoes, diagnostico);
        } else if (tipo == 3) {
            String diagnostico = entrada.lerTexto("Diagnostico: ");
            String[] procedimentos = lerProcedimentos();
            consulta.registrarAtendimento(observacoes, diagnostico, procedimentos, contarProcedimentos(procedimentos));
        } else {
            System.out.println("Opcao invalida.");
            return;
        }
        consulta.mostrarResumoAtendimento();
    }

    public String[] lerProcedimentos() {
        String[] procedimentos = new String[10];
        int qtd = entrada.lerInteiro("Quantos procedimentos? ");
        if (qtd > 10) qtd = 10;
        if (qtd < 0) qtd = 0;

        for (int i = 0; i < qtd; i++) {
            procedimentos[i] = entrada.lerTexto("Procedimento " + (i + 1) + ": ");
        }
        return procedimentos;
    }

    public int contarProcedimentos(String[] procedimentos) {
        int qtd = 0;
        for (int i = 0; i < procedimentos.length; i++) {
            if (procedimentos[i] != null && !procedimentos[i].equals("")) qtd++;
        }
        return qtd;
    }

    public void adicionarProcedimentoDepois() {
        Consulta consulta = escolherConsulta();
        if (consulta == null) return;
        if (!consulta.status.equals("realizada")) {
            System.out.println("Procedimentos extras so foram liberados para consulta realizada.");
            return;
        }

        System.out.println("1 - Adicionar um procedimento");
        System.out.println("2 - Adicionar varios procedimentos");
        int opcao = entrada.lerInteiro("Escolha: ");

        if (opcao == 1) {
            consulta.adicionarProcedimento(entrada.lerTexto("Procedimento: "));
        } else if (opcao == 2) {
            String[] procedimentos = lerProcedimentos();
            consulta.adicionarProcedimentos(procedimentos, contarProcedimentos(procedimentos));
        } else {
            System.out.println("Opcao invalida.");
            return;
        }
        consulta.mostrarResumoAtendimento();
    }

    public void menuPagamentos() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- PAGAMENTOS ---");
            System.out.println("1 - Registrar pagamento manual");
            System.out.println("2 - Registrar pagamento automatico");
            System.out.println("3 - Listar pagamentos");
            System.out.println("0 - Voltar");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) registrarPagamentoManual();
            else if (opcao == 2) registrarPagamentoAutomatico();
            else if (opcao == 3) listarPagamentos();
            else if (opcao != 0) System.out.println("Opcao invalida.");
        }
    }

    public boolean tipoPagamentoAceito(String tipo) {
        Pagamento teste = new Pagamento(new Consulta(new Paciente("teste", "0"), new Profissional("teste", "clinica geral"), "01/01/2000", "segunda", "08:00"), 0, "dinheiro");
        return teste.tipoValido(tipo);
    }

    public void registrarPagamentoManual() {
        if (qtdPagamentos >= pagamentos.length) {
            System.out.println("Limite de pagamentos atingido.");
            return;
        }

        Consulta consulta = escolherConsulta();
        if (consulta == null) return;
        double valor = entrada.lerDouble("Valor manual: ");
        String tipo = entrada.lerTexto("Tipo (dinheiro, cartao, convenio): ");
        if (!tipoPagamentoAceito(tipo)) {
            System.out.println("Tipo de pagamento invalido.");
            return;
        }

        Pagamento pagamento = new Pagamento(consulta, valor, tipo);
        calcularPagamento(pagamento);
        finalizarPagamento(pagamento);
    }

    public void registrarPagamentoAutomatico() {
        if (qtdPagamentos >= pagamentos.length) {
            System.out.println("Limite de pagamentos atingido.");
            return;
        }

        Consulta consulta = escolherConsulta();
        if (consulta == null) return;
        String tipo = entrada.lerTexto("Tipo (dinheiro, cartao, convenio): ");
        if (!tipoPagamentoAceito(tipo)) {
            System.out.println("Tipo de pagamento invalido.");
            return;
        }

        Pagamento pagamento = new Pagamento(consulta, tipo);
        calcularPagamento(pagamento);
        finalizarPagamento(pagamento);
    }

    public void calcularPagamento(Pagamento pagamento) {
        double desconto = 0;

        if (pagamento.consulta.tipo.equalsIgnoreCase("retorno")) {
            desconto = desconto + (pagamento.valorBase * 0.20);
        }
        if (pagamento.consulta.paciente.temConvenio()) {
            desconto = desconto + (pagamento.valorBase * 0.40);
        }

        if (desconto == 0 && pagamento.consulta.multa == 0) {
            pagamento.calcular(pagamento.valorBase);
        } else if (pagamento.consulta.multa == 0) {
            pagamento.calcular(pagamento.valorBase, desconto);
        } else {
            pagamento.calcular(pagamento.valorBase, desconto, pagamento.consulta.multa);
        }
    }

    public void finalizarPagamento(Pagamento pagamento) {
        if (pagamento.tipo.equalsIgnoreCase("cartao")) {
            pagamento.definirParcelas(entrada.lerInteiro("Parcelas em ate 3 vezes: "));
        }

        pagamentos[qtdPagamentos] = pagamento;
        qtdPagamentos++;
        System.out.println("Pagamento registrado.");
        pagamento.mostrar();
    }

    public void listarPagamentos() {
        if (qtdPagamentos == 0) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        for (int i = 0; i < qtdPagamentos; i++) pagamentos[i].mostrar();
    }
}