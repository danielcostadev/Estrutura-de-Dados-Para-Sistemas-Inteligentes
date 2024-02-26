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


    public void exibirNoEsq(BIntNo arv) {
        if (arv != null) {
            System.out.println("Esquerdo: " + arv.valor);
            exibirNoEsq(arv.esq);
            exibirNoEsq(arv.dir);
        }
    }

    public void exibirNoDir(BIntNo arv) {
        if (arv != null) {
            System.out.println("Direito: " + arv.valor);
            exibirNoDir(arv.esq);
            exibirNoDir(arv.dir);
        }
    }
    
    public void exibirNo() {
        exibirNoEsq(Raiz.esq);
        exibirRaiz();
        exibirNoDir(Raiz.dir);
    }

    public void exibirRaiz() {
        if (Raiz != null) {
            System.out.println("raiz " + Raiz.valor);
        } else {
            System.out.println("Árvore vazia!");
        }
    }
    
    public void No(int item) {
        BIntNo tempNo, pai, filho, temp;

        tempNo = Raiz;
        pai = null;
        filho = Raiz;

        while (tempNo != null && tempNo.valor != item) {
            pai = tempNo;
            if (item < tempNo.valor) {
                tempNo = tempNo.esq;
            } else {
                tempNo = tempNo.dir;
            }

            if (tempNo == null) {
                System.out.println("Item não localizado!");
                return; // Se o item não foi encontrado, retorna sem fazer nada
            }
        }

        if (pai == null) {
            if (tempNo.dir == null) {
                Raiz = tempNo.esq;
            } else if (tempNo.esq == null) {
                Raiz = tempNo.dir;
            } else {
                for (temp = tempNo, filho = tempNo.esq; filho.dir != null; temp = filho, filho = filho.dir) {
                    // Encontra o nó mais à direita na subárvore esquerda
                }
                if (filho != tempNo.esq) {
                    temp.dir = filho.esq;
                    filho.esq = tempNo.esq;
                }
                filho.dir = tempNo.dir;
                Raiz = filho;
            }
        } else {
            if (tempNo.dir == null) {
                if (pai.esq == tempNo) {
                    pai.esq = tempNo.esq;
                } else {
                    pai.dir = tempNo.esq;
                }
            } else if (tempNo.esq == null) {
                if (pai.esq == tempNo) {
                    pai.esq = tempNo.dir;
                } else {
                    pai.dir = tempNo.dir;
                }
            } else {
                for (temp = tempNo, filho = tempNo.esq; filho.dir != null; temp = filho, filho = filho.dir) {
                    // Encontra o nó mais à direita na subárvore esquerda
                }
                if (filho != tempNo.esq) {
                    temp.dir = filho.esq;
                    filho.esq = tempNo.esq;
                }
                filho.dir = tempNo.dir;

                if (pai.esq == tempNo) {
                    pai.esq = filho;
                } else {
                    pai.dir = filho;
                }
            }
        }
    }

    
}
