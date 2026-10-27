import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

private static final int QUANTIDADE_ELEMENTOS = 20;

void combinacaoMesclar(ListaDupla[] listas){

    ListaDupla listaParaMesclar = new ListaDupla();

    Random random = new Random();
    int n = random.nextInt(5) + 1;

    for (int i = 0; i < n; i++) {
        int numeroAleatorio = random.nextInt(100) + 1;
        listaParaMesclar.inserirNoFim(numeroAleatorio);
    }
    System.out.printf("Lista Que Sera Mesclada: %s%n", listaParaMesclar);

    random = new Random();
    int numeroLista = 1;
    for (ListaDupla lista : listas) {
        n = random.nextInt(5) + 1;
        for (int i = 0; i < n; i++) {
            int numeroAleatorio = random.nextInt(100) + 1;
            lista.inserirNoFim(numeroAleatorio);
        }
        System.out.printf("Lista %d: %s%n", numeroLista, lista);
        numeroLista += 1;
    }

    listaParaMesclar.mesclarListas(listas);
    System.out.printf("Lista Final Mesclada: %s%n", listaParaMesclar);

}

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
ListaDupla gerarListaOrdenada(int quantidade, Random random) {
    ListaDupla lista = new ListaDupla();
    int valor = 0;
    for (int i = 0; i < quantidade; i++) {
        valor += random.nextInt(3) + 1;
        lista.inserirNoFim(valor);
    }
    return lista;
}

void combinacaoIntersecao() {
    Random random = new Random();
    ListaDupla listaA = new ListaDupla();
    ListaDupla listaB = new ListaDupla();

    for (int i = 0; i < 6; i++) {
        listaA.inserirNoFim(random.nextInt(15) + 1);
        listaB.inserirNoFim(random.nextInt(15) + 1);
    }

    System.out.printf("Lista A: %s%n", listaA);
    System.out.printf("Lista B: %s%n", listaB);
    System.out.printf("Interseção: %s%n", listaA.intersecao(listaB));
}

void combinacaoBalanceLine() {
    Random random = new Random();
    ListaDupla listaA = gerarListaOrdenada(random.nextInt(5) + 4, random);
    ListaDupla listaB = gerarListaOrdenada(random.nextInt(5) + 4, random);

    System.out.printf("Lista A (ordenada): %s%n", listaA);
    System.out.printf("Lista B (ordenada): %s%n", listaB);
    System.out.println("Balance-line:");
    System.out.print(listaA.balanceLine(listaB));
}

void combinacaoInsercaoOrdenada() {
    Random random = new Random();
    ListaDupla lista = new ListaDupla();

    for (int i = 0; i < 8; i++) {
        int valor = random.nextInt(100) + 1;
        int chave = random.nextInt(100) + 1;

        lista.inserirOrdenado(valor, chave);
        System.out.printf(
                "Inserindo valor %d com chave %d%n", valor, chave
        );
    }

    System.out.println("Lista ordenada por chave:");

    for (NoDuplo atual = lista.getCabeca();
         atual != null;
         atual = atual.getProx()) {
        System.out.printf(
                "[Valor: %d, Chave: %d] ",
                atual.getDado(), atual.getChave()
        );
    }
    System.out.println();
}

void combinacaoParticao() {
    Random random = new Random();
    ListaDupla lista = new ListaDupla();

    for (int i = 0; i < 9; i++) {
        lista.inserirNoFim(random.nextInt(100) + 1);
    }

    System.out.println("Lista original: " + lista);

    ListaDupla[] partes = lista.particionar();

    System.out.println("Primeira lista: " + partes[0]);
    System.out.println("Segunda lista: " + partes[1]);
}

void combinacaoInversao() {
    Random random = new Random();
    ListaDupla lista = new ListaDupla();

    for (int i = 0; i < 8; i++) {
        lista.inserirNoFim(random.nextInt(100) + 1);
    }

    System.out.println("Lista original: " + lista);
    lista.inverterComPilha();
    System.out.println("Lista invertida: " + lista);
}

boolean estaBalanceada(String expressao) {
    Pilha pilha = new Pilha();

    for (char c : expressao.toCharArray()) {
        if (c == '(') {
            pilha.push(c);
        } else if (c == ')') {
            if (pilha.pop() == null) {
                return false;
            }
        }
    }
    return pilha.pop() == null;
}

void combinacaoParenteses() {
    String[] expressoes = {
            "(a + b) * (c - d)",
            "((a + b) * c) - d",
            "((a + b)",
            "(a + b))",
            ")a + b("
    };

    for (String expressao : expressoes) {
        System.out.printf("%-22s -> %s%n", expressao,
                estaBalanceada(expressao) ? "balanceada" : "não balanceada");
    }
}

void main() {

    System.out.println("\n--- Inserção Ordenada ---");
    combinacaoInsercaoOrdenada();

    System.out.println("\n--- Partição de Lista ---");
    combinacaoParticao();

    ListaDupla[] listasParaMesclar = {new ListaDupla(), new ListaDupla(), new ListaDupla()};
    combinacaoMesclar(listasParaMesclar);

    System.out.println("\n--- Interseção ---");
    combinacaoIntersecao();

    System.out.println("\n--- Balance-line ---");
    combinacaoBalanceLine();

    System.out.println("\n--- Inversão com Pilha ---");
    combinacaoInversao();

    System.out.println("\n--- Balanceamento de Parênteses ---");
    combinacaoParenteses();
}
