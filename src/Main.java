import java.util.LinkedList;
import java.util.List;

private String linha(int qtde){
    return "-".repeat(qtde);
}

void main() throws Exception {
    Scanner sc = new Scanner(System.in);

    ListaSimples L1 = new ListaSimples();

    linha(20);
    System.out.println("Digite a quantidade de numeros a serem gerados: ");
    int qtde = sc.nextInt();
    linha(20);
    for (int i = 0; i < qtde ; i++) {
        Random random = new Random();
        int gen = random.nextInt(101);

        System.out.println("Onde deseja inserir o numero '" + gen + "': [1- Inicio, 2-Meio, 3-Fim]");
        int pos = sc.nextInt();
        switch (pos) {
            case 1:
                L1.inserirNoInicio(gen);
                break;
            case 2:
                // L1.inserirNoMeio(gen, );
                break;
            case 3:
                L1.inserirNoFim(gen);
                break;
            default:
                throw new Exception("Opção inválida");
        }

    }

    System.out.println("Lista 1: " + L1.exibir());
}
