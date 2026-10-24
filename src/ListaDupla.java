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
        if (ehVazia()) {
            this.cabeca = cabeca;
            this.cauda = cabeca;
        }
        else {
            this.cabeca = cabeca;
        }
    }

    public void setCauda(NoDuplo cauda) {
        if (ehVazia()) {
            this.cabeca = cauda;
            this.cauda = cauda;
        }
        else {
            this.cauda = cauda;
        }
    }

    public boolean ehVazia() {
        return this.cabeca == null;
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

    public Integer removerNoInicio() {
        if (ehVazia()) {
            return null;
        }
        NoDuplo removido = cabeca;
        cabeca = removido.getProx();
        if (cabeca == null) {
            cauda = null;
        } else {
            cabeca.setAnt(null);
        }
        removido.setProx(null);
        removido.setAnt(null);
        return removido.getDado();
    }

    public void mesclarListas(ListaDupla[] listas){
        boolean fimLista = ehVazia();
        NoDuplo auxFim = this.cauda;
        NoDuplo auxIni = this.cabeca;
        while (true){
            boolean finalizar = true;
            if (!fimLista){
                if(auxFim == this.cabeca){
                    fimLista = true;
                }
                this.inserirNoFim(this.removerNoInicio());
            }
            for (ListaDupla lista : listas) {
                if (!lista.ehVazia()) {
                    this.inserirNoFim(lista.removerNoInicio());
                    finalizar = false;
                }
            }
            if (finalizar){
                break;
            }
        }
        while(!fimLista){
            if(auxFim == this.cabeca){
                fimLista = true;
            }
            this.inserirNoFim(this.removerNoInicio());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoDuplo atual = this.cabeca;

        sb.append("[ ");
        while (atual != null) {
            sb.append(atual.getDado());

            if (atual.getProx() != null) {
                sb.append(" , ");
            }

            atual = atual.getProx();
        }
        sb.append(" ]");
        return sb.toString();
    }
}

