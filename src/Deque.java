public class Deque extends ListaSimples {

    public void inserirInicio(int dado) {
        inserirNoInicio(dado);
    }

    public void inserirFim(int dado) {
        inserirNoFim(dado);
    }

    public Integer removerInicio() {
        return removerNoInicio();
    }

    public Integer removerFim() {
        return removerNoFim();
    }
}
