import java.util.Scanner;

public class Sistema {

    public Scanner scanner;
    public Entrada entrada;
    public GerenciadorClinica gerenciador;
    public Relatorio relatorio;

    public Sistema() {
        scanner = new Scanner(System.in);
        entrada = new Entrada(scanner);
        gerenciador = new GerenciadorClinica(entrada);
        relatorio = new Relatorio(gerenciador);
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== CLINICA VIDAPLENA ===");
            System.out.println("1 - Pacientes");
            System.out.println("2 - Profissionais");
            System.out.println("3 - Consultas");
            System.out.println("4 - Atendimentos");
            System.out.println("5 - Pagamentos");
            System.out.println("6 - Relatorios");
            System.out.println("0 - Sair");
            opcao = entrada.lerInteiro("Escolha: ");

            if (opcao == 1) {
                gerenciador.menuPacientes();
            } else if (opcao == 2) {
                gerenciador.menuProfissionais();
            } else if (opcao == 3) {
                gerenciador.menuConsultas();
            } else if (opcao == 4) {
                gerenciador.menuAtendimentos();
            } else if (opcao == 5) {
                gerenciador.menuPagamentos();
            } else if (opcao == 6) {
                relatorio.menuRelatorios(entrada);
            } else if (opcao == 0) {
                System.out.println("Sistema encerrado.");
            } else {
                System.out.println("Opcao invalida.");
            }
        }
    }
}