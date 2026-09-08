public class Pilha extends ListaSimples {

    public void push(int dado) {
        inserirNoInicio(dado);
    }

    public void pop() {
        removerNoInicio();
    }
}
