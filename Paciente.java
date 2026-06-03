public class Paciente {

    public String nome;
    public String cpf;
    public int idade;
    public String telefone;
    public String convenio;
    public boolean ativo;

    // Cadastro rapido
    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = 0;
        this.telefone = "";
        this.convenio = "";
        this.ativo = true;
    }

    // Cadastro intermediario
    public Paciente(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.convenio = "";
        this.ativo = true;
    }

    // Cadastro completo
    public Paciente(String nome, String cpf, int idade, String telefone, String convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.convenio = convenio;
        this.ativo = true;
    }

    // Sobrecarga de metodo para completar dados depois
    public void complementarCadastro(int idade, String telefone) {
        this.idade = idade;
        this.telefone = telefone;
    }

    public void complementarCadastro(int idade, String telefone, String convenio) {
        this.idade = idade;
        this.telefone = telefone;
        this.convenio = convenio;
    }

    public boolean temConvenio() {
        if (convenio != null && !convenio.equals("")) {
            return true;
        }
        return false;
    }

    public void desativar() {
        ativo = false;
    }

    public void mostrar() {
        System.out.println("--------------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Convenio: " + convenio);
        if (ativo) {
            System.out.println("Situacao: ativo");
        } else {
            System.out.println("Situacao: inativo");
        }
    }
}