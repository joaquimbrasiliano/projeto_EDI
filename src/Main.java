void main() {

    // Lista externa
    ListaDupla<Character, ListaDupla<String, Integer>> lista =
            new ListaDupla<>();

    // Armazena os nomes e as idades
    Map<String, Integer> nomes = new LinkedHashMap<>();

    // Relaciona cada caractere à sua lista interna
    Map<Character, ListaDupla<String, Integer>> caracteres =
            new HashMap<>();

    // Dados que serão cadastrados
    nomes.put("Ana", 20);
    nomes.put("Anna", 21);
    nomes.put("Beatriz", 24);
    nomes.put("Bruna", 19);
    nomes.put("Carlos", 30);
    nomes.put("Fábio", 45);
    nomes.put("Fernanda", 12);
    nomes.put("Joana", 33);

    // Permite comparação com caracteres UTF-8 para ordenar
    Collator collator = Collator.getInstance(Locale.of("pt", "BR"));

    // Percorre os nomes e realiza as inserções
    for (Map.Entry<String, Integer> pessoa : nomes.entrySet()) {

        String nome = pessoa.getKey();
        Integer idade = pessoa.getValue();

        char inicial = Character.toUpperCase(nome.charAt(0));

        // Procura a lista interna correspondente à inicial
        ListaDupla<String, Integer> listaInterna =
                caracteres.get(inicial);

        // Caso não exista, cria uma nova lista interna
        if (listaInterna == null) {

            listaInterna = new ListaDupla<>();

            // Armazena a lista interna no Map
            caracteres.put(inicial, listaInterna);

            // Insere o novo grupo na lista externa
            lista.inserirOrdenado(
                    new No<>(inicial, listaInterna),
                    Comparator.naturalOrder()
            );
        }

        // Insere o nome e a idade na lista interna
        listaInterna.inserirOrdenado(
                new No<>(nome, idade),
                collator::compare
        );
    }

    // Exibe toda a estrutura
    System.out.println(lista);

    Scanner scanner = new Scanner(System.in);

    // Lê a letra escolhida pelo usuário
    System.out.print("\nDigite a letra da lista que deseja imprimir: ");
    String entrada = scanner.nextLine().trim();
    // Converte a letra sempre para maiúscula
    char letra = Character.toUpperCase(entrada.charAt(0));

    // Busca o nó da lista externa correspondente à letra escolhida
    No<Character, ListaDupla<String, Integer>> noLetra = lista.buscar(letra);

    // Impressão dos nomes e idades da sub-lista
    if (noLetra == null) {
        System.out.println("Não há nomes cadastrados com a letra " + letra + ".");
    } else {
        System.out.println("\nNomes com a letra " + letra + ":");
        System.out.print(noLetra.getChave().listar());
    }
}