public class NoDuplo {
    private int dado;
    private NoDuplo prox;
    private NoDuplo ant;

    public NoDuplo(int valor) {
        this.dado = valor;
        this.prox = null;
        this.ant = null;
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

    public void setDado(int dado) {
        this.dado = dado;
    }
    public void setProx(NoDuplo prox) {
        this.prox = prox;
    }
    public void setAnt(NoDuplo ant) {
        this.ant = ant;
    }
}
