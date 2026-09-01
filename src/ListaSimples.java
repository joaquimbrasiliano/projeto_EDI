public class ListaSimples {
    private No cabeca;

    ListaSimples(){
        this.cabeca = null;
    }

    public boolean ehVazia(){
        return this.cabeca == null;
    }

    public void inserirInicio(int valor){
        No aux = new No(valor);

        if(ehVazia()){
            cabeca.setProximo(aux);
        } else {
            aux.setProximo(cabeca);''
            cabeca = aux;
        }
    }

    public No getCabeca() {
        return cabeca;
    }

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }
}
