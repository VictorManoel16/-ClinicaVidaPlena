import java.util.Scanner;

public class Entrada {

    public Scanner scanner;

    public Entrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public int lerInteiro(String mensagem) {
        String texto = lerTexto(mensagem);

        if (!inteiroValido(texto)) {
            return -1;
        }

        return Integer.parseInt(texto);
    }

    public double lerDouble(String mensagem) {
        String texto = lerTexto(mensagem);

        if (!doubleValido(texto)) {
            return 0;
        }

        return Double.parseDouble(texto);
    }

    public boolean inteiroValido(String texto) {
        if (texto == null || texto.equals("")) {
            return false;
        }

        int inicio = 0;
        if (texto.charAt(0) == '-') {
            if (texto.length() == 1) {
                return false;
            }
            inicio = 1;
        }

        for (int i = inicio; i < texto.length(); i++) {
            if (texto.charAt(i) < '0' || texto.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean doubleValido(String texto) {
        if (texto == null || texto.equals("")) {
            return false;
        }

        int pontos = 0;
        int inicio = 0;
        if (texto.charAt(0) == '-') {
            if (texto.length() == 1) {
                return false;
            }
            inicio = 1;
        }

        for (int i = inicio; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '.') {
                pontos++;
                if (pontos > 1) {
                    return false;
                }
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}