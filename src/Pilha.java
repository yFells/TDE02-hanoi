import java.util.Random;

public class Pilha {

    private Node top;

    public Pilha() {
        top = null;
    }

    public Node getTop() {
        return top;
    }

    public boolean estaVazia() {
        return top == null;
    }

    public void preencher_Pilha(int tamanho) {
        int count = 0;
        while(count < tamanho) {
            Random random = new Random();
            int data = random.nextInt(100) + 1;
            insere(data);
            count++;
        }
    }

    public void insere(Integer data) {
        Node novoNode = new Node(data);
        novoNode.next = top;
        top = novoNode;
    }

    public void insereDecrescente(Integer data) {
        Node novoNode = new Node(data);
        Pilha pilhaTemp = new Pilha();

        while (!estaVazia() && data >= top.data) {
            pilhaTemp.insere(remove());
        }

        novoNode.next = top;
        top = novoNode;

        while (!pilhaTemp.estaVazia()) {
            insere(pilhaTemp.remove());
        }
    }


    public void insereCrescente(Integer data) {
        Node novoNode = new Node(data);
        Pilha pilhaTemp = new Pilha();

        while (!estaVazia() && data <= top.data) {
            pilhaTemp.insere(remove());
        }

        novoNode.next = top;
        top = novoNode;

        while (!pilhaTemp.estaVazia()) {
            insere(pilhaTemp.remove());
        }
    }

    public Integer remove() {
        if (estaVazia()) {
            System.out.println("\nA pilha esta vazia\n");
            return null;
        } else {
            Integer removido = top.data;
            top = top.next;
            return removido;
        }
    }

    public boolean estaCrescente(Pilha pilhaTeste) {
        Node atual = top;
        while (!estaVazia()) {
            if (atual.data >= atual.next.data) {
                pilhaTeste.insere(remove());
            }else {
                while (!pilhaTeste.estaVazia()) {
                    insere(pilhaTeste.remove());
                }
                return false;
            }
        }
        while (!pilhaTeste.estaVazia()) {
            insere(pilhaTeste.remove());
        }
        return true;
    }

    public boolean estaDecrescente(Pilha pilhaTeste) {
        Node atual = top;
        while (!estaVazia()) {
            if (atual.data <= atual.next.data) {
                pilhaTeste.insere(remove());
            }else {
                while (!pilhaTeste.estaVazia()) {
                    insere(pilhaTeste.remove());
                }
                return false;
            }
        }
        while (!pilhaTeste.estaVazia()) {
            insere(pilhaTeste.remove());
        }
        return true;
    }
}
