public class ListaSimples {

    protected No cabeca;

    public ListaSimples() {
        cabeca = null;
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

    public void removerNoInicio() {
        if (cabeca != null) {
            cabeca = cabeca.getProximo();
        }
    }

    public void removerNoFim() {
        if (cabeca == null) {
            return;
        }

        if (cabeca.getProximo() == null) {
            cabeca = null;
            return;
        }

        No atual = cabeca;

        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }

        atual.setProximo(null);
    }

    public void removerNoMeio(int posicao) {
        if (cabeca == null) {
            return;
        }

        if (posicao <= 0) {
            removerNoInicio();
            return;
        }

        No atual = cabeca;
        int contador = 0;

        while (atual.getProximo() != null &&
               contador < posicao - 1) {

            atual = atual.getProximo();
            contador++;
        }

        if (atual.getProximo() != null) {
            atual.setProximo(
                atual.getProximo().getProximo()
            );
        }
    }
}
