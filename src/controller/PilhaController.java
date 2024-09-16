package controller;

import java.util.EmptyStackException;
import br.edu.fateczl.pilha.PilhaInt;

public class PilhaController {
    private PilhaInt pilha;

    public PilhaController() {
        pilha = new PilhaInt();
    }

    public void empilhaNumero(int numero) {
        pilha.push(numero);
    }

    public void realizaOperacao(char operador) {
        try {
            if (pilha.size() < 2) {
                throw new IllegalStateException("A pilha deve ter pelo menos 2 valores para realizar a operação.");
            }

            int valor2 = pilha.pop();
            int valor1 = pilha.pop();
            int resultado = switch (operador) {
                case '+' -> valor1 + valor2;
                case '-' -> valor1 - valor2;
                case '*' -> valor1 * valor2;
                case '/' -> {
                    if (valor2 == 0) {
                        throw new ArithmeticException("Divisão por zero não permitida.");
                    }
                    yield valor1 / valor2;
                }
                default -> throw new IllegalArgumentException("Operador inválido.");
            };

            pilha.push(resultado);
            System.out.println("Resultado da operação: " + resultado);
        } catch (EmptyStackException e) {
            System.out.println("Erro: Pilha vazia.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int resultado() throws Exception {
        return pilha.top();
    }
}