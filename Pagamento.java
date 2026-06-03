public class Pagamento {

    public Consulta consulta;
    public double valorBase;
    public double valorFinal;
    public String tipo;
    public int parcelas;

    // Estrutura inicial para o modulo de pagamentos
    public Pagamento(Consulta consulta, double valorManual, String tipo) {
        this.consulta = consulta;
        this.valorBase = valorManual;
        this.valorFinal = valorManual;
        this.tipo = tipo;
        this.parcelas = 1;
    }

    public Pagamento(Consulta consulta, String tipo) {
        this.consulta = consulta;
        this.valorBase = consulta.profissional.valorConsulta;
        this.valorFinal = consulta.profissional.valorConsulta;
        this.tipo = tipo;
        this.parcelas = 1;
    }

    public boolean tipoValido(String tipo) {
        if (tipo.equalsIgnoreCase("dinheiro")) {
            return true;
        }
        if (tipo.equalsIgnoreCase("cartao")) {
            return true;
        }
        if (tipo.equalsIgnoreCase("convenio")) {
            return true;
        }
        return false;
    }

    public double calcular(double valor) {
        valorFinal = valor;

        if (valorFinal < 0) {
            valorFinal = 0;
        }

        return valorFinal;
    }

    public double calcular(double valor, double desconto) {

        valorFinal = valor - desconto;

        // Nunca deixa valor negativo
        if (valorFinal < 0) {
            valorFinal = 0;
        }

        return valorFinal;
    }

    public double calcular(double valor, double desconto, double multa) {
        valorFinal = valor - desconto + multa;
        
        if (valorFinal < 0) {
            valorFinal = 0;
        }

        return valorFinal;
    }

    public void definirParcelas(int parcelas) {
        if (parcelas < 1) {
            this.parcelas = 1;
        } else if (parcelas > 3) {
            this.parcelas = 3;
        } else {
            this.parcelas = parcelas;
        }
    }

    public void mostrar() {

        System.out.println("Pagamento finalizado.");

        System.out.println("\n===== PAGAMENTO =====");

        System.out.println("Paciente: " + consulta.paciente.nome);

        System.out.println("Profissional: " + consulta.profissional.nome);

        System.out.println("Tipo da consulta: " + consulta.tipo);

        System.out.println("Forma de pagamento: " + tipo);

        System.out.println("Valor base: R$ " + valorBase);

        System.out.println("Valor final: R$ " + valorFinal);

        if (parcelas > 1) {

            double valorParcela = valorFinal / parcelas;

            System.out.println("Parcelas: " + parcelas + "x");

            System.out.println("Valor por parcela: R$ " + valorParcela);
        }

        if (consulta.multa > 0) {

            System.out.println("Multa aplicada: R$ " + consulta.multa);
        }

        System.out.println("=====================\n");
    }
}    