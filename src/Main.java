import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

private static final int QUANTIDADE_ELEMENTOS = 20;

Integer lerPosicao(Scanner scanner, int numero) {
    while (true) {
        System.out.printf(
            "Onde inserir o número %d? [1-Início, 2-Meio, 3-Fim]: ", numero
        );
        if (!scanner.hasNext()) {
            return null;
        }
        if (scanner.hasNextInt()) {
            int opcao = scanner.nextInt();
            if (opcao >= 1 && opcao <= 3) {
                return opcao;
            }
        } else {
            scanner.next();
        }
        System.out.println("Opção inválida. Digite 1, 2 ou 3.");
    }
}

void inserirNaPosicaoEscolhida(ListaSimples lista, int numero, int opcao) {
    switch (opcao) {
        case 1 -> lista.inserirNoInicio(numero);
        case 2 -> lista.inserirNoMeio(numero, lista.tamanho() / 2);
        case 3 -> lista.inserirNoFim(numero);
        default -> throw new IllegalArgumentException("Opção inválida");
    }
}

void copiar(ListaSimples origem, ListaSimples destino) {
    for (No atual = origem.getCabeca(); atual != null; atual = atual.getProximo()) {
        destino.inserirNoFim(atual.getDado());
    }
}

void moverParesParaPilha(ListaSimples lista, Pilha pilha) {
    No atual = lista.getCabeca();
    int posicao = 0;
    while (atual != null) {
        No proximo = atual.getProximo();
        if (atual.getDado() % 2 == 0) {
            pilha.push(lista.removerNoMeio(posicao));
        } else {
            posicao++;
        }
        atual = proximo;
    }
}

void ordenarBubbleSort(ListaSimples lista) {
    for (int limite = lista.tamanho() - 1; limite > 0; limite--) {
        boolean houveTroca = false;
        No atual = lista.getCabeca();
        for (int i = 0; i < limite; i++) {
            No proximo = atual.getProximo();
            if (atual.getDado() > proximo.getDado()) {
                int auxiliar = atual.getDado();
                atual.setDado(proximo.getDado());
                proximo.setDado(auxiliar);
                houveTroca = true;
            }
            atual = proximo;
        }
        if (!houveTroca) {
            break;
        }
    }
}

String consultarMultiplosDeTres(ListaSimples lista) {
    StringJoiner resultado = new StringJoiner(", ", "[", "]");
    for (No atual = lista.getCabeca(); atual != null; atual = atual.getProximo()) {
        if (atual.getDado() % 3 == 0) {
            resultado.add(Integer.toString(atual.getDado()));
        }
    }
    return resultado.toString();
}

void inverterComPilha(ListaSimples lista) {
    Pilha auxiliar = new Pilha();
    Integer valor;
    while ((valor = lista.removerNoInicio()) != null) {
        auxiliar.push(valor);
    }
    while ((valor = auxiliar.pop()) != null) {
        lista.inserirNoFim(valor);
    }
}

void transferirPilhaParaFila(Pilha pilha, Fila fila) {
    Integer valor;
    while ((valor = pilha.pop()) != null) {
        fila.inserir(valor);
    }
}

void preencherDeque(ListaSimples lista, Deque deque) {
    boolean inserirNoInicio = true;
    for (No atual = lista.getCabeca(); atual != null; atual = atual.getProximo()) {
        if (inserirNoInicio) {
            deque.inserirInicio(atual.getDado());
        } else {
            deque.inserirFim(atual.getDado());
        }
        inserirNoInicio = !inserirNoInicio;
    }
}

void trocarPrimeiroComUltimo(ListaSimples lista) {
    No primeiro = lista.getCabeca();
    if (primeiro == null || primeiro.getProximo() == null) {
        return;
    }
    No ultimo = primeiro;
    while (ultimo.getProximo() != null) {
        ultimo = ultimo.getProximo();
    }

    int auxiliar = primeiro.getDado();
    primeiro.setDado(ultimo.getDado());
    ultimo.setDado(auxiliar);
}

void main() {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    ListaSimples l1 = new ListaSimples();
    ListaSimples l2 = new ListaSimples();
    Pilha pilha = new Pilha();
    Fila fila = new Fila();
    Deque deque = new Deque();

    System.out.println("1. Inserção de 20 inteiros aleatórios de 0 a 100 em L1");
    for (int i = 0; i < QUANTIDADE_ELEMENTOS; i++) {
        int numero = random.nextInt(101);
        Integer opcao = lerPosicao(scanner, numero);
        if (opcao == null) {
            System.out.println("\nEntrada encerrada antes de completar os 20 elementos.");
            System.out.println("L1 parcial: " + l1.exibir());
            return;
        }
        inserirNaPosicaoEscolhida(l1, numero, opcao);
    }
    System.out.println("\nL1 original: " + l1.exibir());

    copiar(l1, l2);
    System.out.println("2. L2: " + l2.exibir());

    moverParesParaPilha(l1, pilha);
    System.out.println("3. L1 sem os pares: " + l1.exibir());
    System.out.println("Pilha: " + pilha.exibir());

    ordenarBubbleSort(l2);
    System.out.println("4. L2 crescente: " + l2.exibir());

    System.out.println("5. Múltiplos de 3 em L1: " + consultarMultiplosDeTres(l1));

    inverterComPilha(l2);
    System.out.println("6. L2 invertida com pilha auxiliar: " + l2.exibir());

    transferirPilhaParaFila(pilha, fila);
    System.out.println("7. F após retirar os elementos de P: " + fila.exibir());

    preencherDeque(l2, deque);
    System.out.println("8. D preenchido: " + deque.exibir());

    trocarPrimeiroComUltimo(l1);
    System.out.println("9. L1 com os valores trocados: " + l1.exibir());

    System.out.println("\n10. Estado final das estruturas");
    System.out.println("L1: " + l1.exibir());
    System.out.println("L2: " + l2.exibir());
    System.out.println("P: " + pilha.exibir());
    System.out.println("F: " + fila.exibir());
    System.out.println("D: " + deque.exibir());
}
