public class NoDuplo {
    private int dado;
    private NoDuplo prox;
    private NoDuplo ant;
    private int chave;

    public NoDuplo(int valor) {
        this.dado = valor;
        this.prox = null;
        this.ant = null;
        this.chave = 0;
    }

    public int getDado() {
        return dado;
    }
    public NoDuplo getProx() {
        return prox;
    }
    public NoDuplo getAnt() {
        return ant;
    }
    public int getChave(){return chave;};

    public void setDado(int dado) {
        this.dado = dado;
    }
    public void setProx(NoDuplo prox) {
        this.prox = prox;
    }
    public void setAnt(NoDuplo ant) {
        this.ant = ant;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
}
