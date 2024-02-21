package classes;

public class ArvoreBinaria {

    private BIntNo Raiz;

    private BIntNo inserir(BIntNo arvore, int novoNo) {
        if (arvore == null) {
            return new BIntNo(novoNo); // Retorna o novo nó criado
        } else if (novoNo < arvore.valor) {
            arvore.esq = inserir(arvore.esq, novoNo);
        } else {
            arvore.dir = inserir(arvore.dir, novoNo);
        }

        return arvore;
    }

    public void inserirNo(int novoValor) {
        Raiz = inserir(Raiz, novoValor);
    }

    private void exibirEsquerdo(BIntNo arv) {
        if (arv != null) {
            exibirEsquerdo(arv.esq);
            System.out.println(arv.valor);
        }
    }

    public void exibirNoEsq() {
        exibirEsquerdo(Raiz);
    }

    private void exibirDireito(BIntNo arv) {
        if (arv != null) {
            exibirDireito(arv.dir);
            System.out.println(arv.valor);
        }
    }

    public void exibirNoDir() {
        exibirDireito(Raiz);
    }

    public void exibirRaiz() {
        if (Raiz != null) {
            System.out.println("raiz " + Raiz.valor);
        } else {
            System.out.println("Árvore vazia!");
        }
    }

    private BIntNo remover(BIntNo arvore, int valor) {
        if (arvore == null) {
            return null; // Se a árvore estiver vazia ou o valor não estiver presente, retorna null
        }

        if (valor < arvore.valor) {
            arvore.esq = remover(arvore.esq, valor);
        } else if (valor > arvore.valor) {
            arvore.dir = remover(arvore.dir, valor);
        } else {
            // Nó com apenas um filho ou sem filhos
            if (arvore.esq == null) {
                return arvore.dir;
            } else if (arvore.dir == null) {
                return arvore.esq;
            }

            // Nó com dois filhos: encontrar o sucessor em ordem
            arvore.valor = minValor(arvore.dir);

            // Remover o sucessor em ordem
            arvore.dir = remover(arvore.dir, arvore.valor);
        }

        return arvore;
    }

    private int minValor(BIntNo node) {
        int minValor = node.valor;
        while (node.esq != null) {
            minValor = node.esq.valor;
            node = node.esq;
        }
        return minValor;
    }

    public void removerNo(int valor) {
        Raiz = remover(Raiz, valor);
    }

    public void exibirNo() {
        exibirNoEsq();
        exibirRaiz();
        exibirNoDir();
    }

    private class BIntNo {
        int valor;
        BIntNo esq, dir;

        public BIntNo(int item) {
            valor = item;
            esq = dir = null;
        }
    }
}
