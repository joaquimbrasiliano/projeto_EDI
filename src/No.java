class No<T, K> {
    private T dado;
    private K chave;
    private No<T, K> anterior;
    private No<T, K> proximo;

    public No(T dado, K chave) {
        this.dado = dado;
        this.chave = chave;
        this.anterior = null;
        this.proximo = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public No<T, K> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T, K> ant) {
        this.anterior = ant;
    }

    public No<T, K> getProximo() {
        return proximo;
    }

    public void setProximo(No<T, K> prox) {
        this.proximo = prox;
    }

}