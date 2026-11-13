import java.util.Comparator;

public class ListaDupla<T, K> {

    private No<T, K> cabeca;
    private No<T, K> cauda;

    public No<T, K> getCabeca() {
        return cabeca;
    }

    public void setCabeca(No<T, K> cabeca) {
        this.cabeca = cabeca;
    }

    public No<T, K> getCauda() {
        return cauda;
    }

    public void setCauda(No<T, K> cauda) {
        this.cauda = cauda;
    }

    public boolean ehVazia(){
        return this.cabeca == null;
    }

    public void inserirCabeca(No<T, K> no){
        if (ehVazia()){
            this.cabeca = no;
            this.cauda = no;
        }
        else {
            No<T, K> aux = this.cabeca;

            no.setAnterior(null);
            no.setProximo(aux);

            aux.setAnterior(no);

            this.cabeca = no;
        }
    }

    public void inserirOrdenado(No<T, K> novo, Comparator<T> comparador) {
        if (ehVazia()) {
            novo.setAnterior(null);
            novo.setProximo(null);
            this.cabeca = novo;
            this.cauda = novo;
            return;
        }

        if (comparador.compare(novo.getDado(), this.cabeca.getDado()) < 0) {
            inserirCabeca(novo);
            return;
        }

        if (comparador.compare(novo.getDado(), this.cauda.getDado()) >= 0) {
            novo.setAnterior(this.cauda);
            novo.setProximo(null);
            this.cauda.setProximo(novo);
            this.cauda = novo;
            return;
        }

        No<T, K> atual = this.cabeca.getProximo();
        while (comparador.compare(novo.getDado(), atual.getDado()) >= 0) {
            atual = atual.getProximo();
        }

        No<T, K> ant = atual.getAnterior();
        novo.setAnterior(ant);
        novo.setProximo(atual);
        ant.setProximo(novo);
        atual.setAnterior(novo);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        No<T, K> atual = this.cabeca;

        while (atual != null) {

            if (!sb.isEmpty()) {
                sb.append(",\n");
            }

            sb.append("{\n");

            sb.append("Proximo: ");
            sb.append(atual.getProximo() != null
                    ? atual.getProximo().getDado()
                    : "null");

            sb.append(";\nAnterior: ");
            sb.append(atual.getAnterior() != null
                    ? atual.getAnterior().getDado()
                    : "null");

            sb.append(";\nDado: ")
                    .append(atual.getDado());

            sb.append(";\nChave: ")
                    .append(atual.getChave());

            sb.append(";\n}");

            atual = atual.getProximo();
        }

        return !sb.isEmpty() ? sb.toString() : "{}";
    }
}
