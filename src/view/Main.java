package view;

import controller.PilhaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilhaController calculadora = new PilhaController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão em Notação Polonesa Reversa (NPR)");

        while (true) {
            String input = scanner.next();

            try {
                int numero = Integer.parseInt(input);
                calculadora.empilhaNumero(numero);
            } catch (NumberFormatException e) {
                if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                    calculadora.realizaOperacao(input.charAt(0));
                } else if (input.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando...");
                    break;
                } else {
                    System.out.println("Entrada inválida.");
                }
            }
        }

        scanner.close();
    }
}
