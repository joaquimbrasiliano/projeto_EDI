public class ListaSimples {

    protected No cabeca;

    public ListaSimples() {
        cabeca = null;
    }

    public String exibir() {
        StringBuilder mensagem = new StringBuilder("[");
        No atual = cabeca;
        while (atual != null) {
            mensagem.append(atual.getDado());
            if (atual.getProximo() != null) {
                mensagem.append(", ");
            }
            atual = atual.getProximo();
        }
        return mensagem.append("]").toString();
    }

    public No getCabeca() {
        return cabeca;
    }

    public int tamanho() {
        int quantidade = 0;
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            quantidade++;
        }
        return quantidade;
    }

    public void inserirNoInicio(int dado) {
        No novo = new No(dado);

        novo.setProximo(cabeca);
        cabeca = novo;
    }
    
    public void inserirNoFim(int dado) {
        No novo = new No(dado);

        if (cabeca == null) {
            cabeca = novo;
            return;
        }

        No atual = cabeca;

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        atual.setProximo(novo);
    }

    public void inserirNoMeio(int dado, int posicao) {
        if (posicao <= 0 || cabeca == null) {
            inserirNoInicio(dado);
            return;
        }

        No atual = cabeca;
        int contador = 0;

        while (atual.getProximo() != null &&
               contador < posicao - 1) {

            atual = atual.getProximo();
            contador++;
        }

        No novo = new No(dado);

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
    }


    public Integer removerNoInicio() {
        if (cabeca == null) {
            return null;
        }
        No removido = cabeca;
        cabeca = removido.getProximo();
        removido.setProximo(null);
        return removido.getDado();
    }

    public Integer removerNoFim() {
        if (cabeca == null) {
            return null;
        }

        if (cabeca.getProximo() == null) {
            return removerNoInicio();
        }

        No atual = cabeca;

        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }

        int removido = atual.getProximo().getDado();
        atual.setProximo(null);
        return removido;
    }

    public Integer removerNoMeio(int posicao) {
        if (cabeca == null) {
            return null;
        }

        if (posicao <= 0) {
            return removerNoInicio();
        }

        No atual = cabeca;
        int contador = 0;

        while (atual.getProximo() != null &&
               contador < posicao - 1) {

            atual = atual.getProximo();
            contador++;
        }

        if (atual.getProximo() != null) {
            No removido = atual.getProximo();
            atual.setProximo(removido.getProximo());
            removido.setProximo(null);
            return removido.getDado();
        }
        return null;
    }
}
