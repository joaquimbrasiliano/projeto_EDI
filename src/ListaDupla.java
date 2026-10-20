    public class ListaDupla {
    private NoDuplo cabeca;
    private NoDuplo cauda;

    public ListaDupla() {
        this.cabeca = null;
        this.cauda = null;
    }

    public NoDuplo getCabeca() {
        return cabeca;
    }
    public NoDuplo getCauda() {
        return cauda;
    }
    public void setCabeca(NoDuplo cabeca) {
        this.cabeca = cabeca;
    }
    public void setCauda(NoDuplo cauda) {
        this.cauda = cauda;
    }

    public boolean ehVazia() {
        if (this.cabeca == null)
            return true;
        return false;
    }

    public void inserirNoInicio(int valor) {
        NoDuplo aux = new NoDuplo(valor);
        if (ehVazia()) {
            this.cabeca = aux;
            this.cauda = aux;
        } else {
            aux.setProx(this.cabeca);
            this.cabeca.setAnt(aux);
            this.cabeca = aux;
        }
    }

    public void inserirNoFim(int valor) {
        NoDuplo aux = new NoDuplo(valor);
        if (ehVazia()) {
            this.cabeca = aux;
            this.cauda = aux;
        } else {
            aux.setAnt(this.cauda);
            this.cauda.setProx(aux);
            this.cauda = aux;
        }
    }
}

