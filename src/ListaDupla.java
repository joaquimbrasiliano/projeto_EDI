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

    private int chaveDe(NoDuplo no) {
        return no.getDado();
    }

    private boolean contemChave(int chave) {
        NoDuplo atual = this.cabeca;
        while (atual != null) {
            if (chaveDe(atual) == chave) {
                return true;
            }
            atual = atual.getProx();
        }
        return false;
    }

    private boolean estaOrdenada() {
        NoDuplo atual = this.cabeca;
        while (atual != null &&  atual.getProx() != null) {
            if (chaveDe(atual) > chaveDe(atual.getProx())) {
                return false;
            }
            atual = atual.getProx();
        }
        return true;
    }

    public ListaDupla intersecao(ListaDupla outra) {
        ListaDupla resultado = new ListaDupla();
        NoDuplo atual = this.cabeca;
        while (atual != null) {
            int chave = chaveDe(atual);
            if (outra.contemChave(chave) && !resultado.contemChave(chave)) {
                resultado.inserirNoFim(atual.getDado());
                resultado.cauda.setChave(atual.getChave());
            }
            atual = atual.getProx();
        }
        return resultado;
    }

    public String balanceLine(ListaDupla outra) {
        if (!this.estaOrdenada() || !outra.estaOrdenada()) {
            throw new IllegalStateException("Balance-line exige listas ordenadas");
        }
        StringBuilder sb = new StringBuilder();
        NoDuplo a = this.cabeca;
        NoDuplo b = outra.cabeca;

        while (a != null && b != null) {
            int ca = chaveDe(a);
            int cb = chaveDe(b);
            if (ca == cb) {
                sb.append(ca).append(": em ambas\n");
                a = a.getProx();
                b = b.getProx();
            } else if (ca < cb) {
                sb.append(ca).append(": só em A\n");
                a = a.getProx();
            } else {
                sb.append(cb).append(": só em B\n");
                b = b.getProx();
            }
        }
        while (a != null) {
            sb.append(chaveDe(a)).append(": só em A\n");
            a = a.getProx();
        }
        while (b != null) {
            sb.append(chaveDe(b)).append(": só em B\n");
            b = b.getProx();
        }
        return sb.toString();
    }

    public void inserirOrdenado(int valor, int chave) {
        NoDuplo novo = new NoDuplo(valor);
        novo.setChave(chave);

        if (ehVazia()) {
            cabeca = novo;
            cauda = novo;
            return;
        }

        NoDuplo atual = cabeca;

        while (atual != null && atual.getChave() <= chave) {
            atual = atual.getProx();
        }

        if (atual == cabeca) {
            novo.setProx(cabeca);
            cabeca.setAnt(novo);
            cabeca = novo;
        } else if (atual == null) {
            novo.setAnt(cauda);
            cauda.setProx(novo);
            cauda = novo;
        } else {
            novo.setProx(atual);
            novo.setAnt(atual.getAnt());
            atual.getAnt().setProx(novo);
            atual.setAnt(novo);
        }
    }


    public ListaDupla[] particionar() {
        ListaDupla listaA = new ListaDupla();
        ListaDupla listaB = new ListaDupla();

        int tamanho = 0;
        NoDuplo atual = cabeca;

        while (atual != null) {
            tamanho++;
            atual = atual.getProx();
        }

        atual = cabeca;
        int posicao = 0;

        while (atual != null) {
            if (posicao < (tamanho + 1) / 2) {
                listaA.inserirNoFim(atual.getDado());
                listaA.cauda.setChave(atual.getChave());
            } else {
                listaB.inserirNoFim(atual.getDado());
                listaB.cauda.setChave(atual.getChave());
            }

            posicao++;
            atual = atual.getProx();
        }

        return new ListaDupla[]{listaA, listaB};
    }

    void inverterComPilha() {
        Pilha pilha = new Pilha();
        Integer valor;

        while ((valor = this.removerNoInicio()) != null) {
            pilha.push(valor);
        }

        while ((valor = pilha.pop()) != null) {
            this.inserirNoFim(valor);
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

