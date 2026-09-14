public class Fila extends ListaSimples {

    public void inserir(int dado) {
        inserirNoFim(dado);
    }

    public Integer remover() {
        return removerNoInicio();
    }
}
