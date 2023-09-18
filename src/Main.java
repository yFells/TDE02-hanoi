import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();
        Pilha pilha3 = new Pilha();
        Pilha memoria = new Pilha();

        Scanner scanner = new Scanner(System.in);
        System.out.println("==/==/==/==/==/==/==/==/==");
        System.out.println("Escolha o tamanho da pilha: ");
        int tamanho_pilha = scanner.nextInt();
        pilha1.preencher_Pilha(tamanho_pilha);

        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
        int countJogadas = 0;
        boolean jogoEncerrado = false;

        System.out.println("==/==/==/==/==/==/==/==/==");
        System.out.println("Organizar pilha em ordem decrescente ou crescente?");
        System.out.println("1. Crescente");
        System.out.println("2. Decrescente");
        int ordenacao;
        while (true) {
            ordenacao = scanner.nextInt();
            if (ordenacao == 1 || ordenacao == 2) {break;}
            System.out.println("Opcao invalida");
        }

        System.out.println("==/==/==/==/==/==/==/==/==");
        System.out.println("Cada pilha tem seu numero para manipulacao:");
        System.out.println("1. Pilha 1");
        System.out.println("2. Pilha 2");
        System.out.println("3. Pilha 3");

        while (!jogoEncerrado) {
            System.out.println("==/==/==/==/==/==/==/==/==");
            System.out.println("0. Sair do jogo.");
            System.out.println("1. Movimentar.");
            System.out.println("2. Solucao automatica.");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0 -> {
                    System.out.println("Jogo encerrado.");
                    jogoEncerrado = true;
                }
                case 1 -> {                                  //movimentacao jogador
                    while (true) {
                        System.out.println("==/==/==/==/==/==/==/==/==");
                        System.out.println("Qual pilha para remover o topo: ");
                        int pilhaRemovida = scanner.nextInt();

                        if ((pilhaRemovida == 1) && (!pilha1.estaVazia())) {
                            memoria.insere(pilha1.remove());
                            break;
                        } else if ((pilhaRemovida == 2) && (!pilha2.estaVazia())) {
                            memoria.insere(pilha2.remove());
                            break;
                        } else if ((pilhaRemovida == 3) && (!pilha3.estaVazia())) {
                            memoria.insere(pilha3.remove());
                            break;
                        } else {
                            System.out.println("Opcao invalida");
                        }
                    }

                    if (ordenacao == 1) {
                        boolean escolhaCrescente = false;
                        while (!escolhaCrescente) {
                            System.out.println("==/==/==/==/==/==/==/==/==");
                            System.out.println("Qual pilha para adicionar ao topo: ");
                            int pilhaAdicionada = scanner.nextInt();

                            switch (pilhaAdicionada) {
                                case 1 -> {
                                    Integer addedDisc = memoria.getTop().data;

                                    if (pilha1.estaVazia() || addedDisc >= pilha1.getTop().data) {
                                        pilha1.insere(memoria.remove());
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaCrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é menor que o topo da Pilha 1");
                                    }
                                }
                                case 2 -> {
                                    Integer addedDisc = memoria.getTop().data;

                                    if (pilha2.estaVazia() || addedDisc >= pilha2.getTop().data) {
                                        pilha2.insere(memoria.remove());
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaCrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é menor que o topo da Pilha 2");
                                    }
                                }
                                case 3 -> {
                                    Integer addedDisc = memoria.getTop().data;

                                    if (pilha3.estaVazia() || addedDisc >= pilha3.getTop().data) {
                                        pilha3.insere(memoria.remove());
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaCrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é menor que o topo da Pilha 3");
                                    }
                                }
                                default -> System.out.println("Opcao invalida");
                            }

                            if (pilha1.estaVazia() && pilha2.estaVazia()) {
                                if (pilha3.estaCrescente(memoria)) {
                                    System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                    jogoEncerrado = true;
                                }
                            } else if (pilha1.estaVazia() && pilha3.estaVazia()) {
                                if (pilha2.estaCrescente(memoria)) {
                                    System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                    jogoEncerrado = true;
                                }
                            } else if (pilha2.estaVazia() && pilha3.estaVazia()) {
                                if (pilha1.estaCrescente(memoria)) {
                                    System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                    jogoEncerrado = true;
                                }
                            }
                        }
                    } else {
                        boolean escolhaDecrescente = false;
                        while (!escolhaDecrescente) {
                            System.out.println("==/==/==/==/==/==/==/==/==");
                            System.out.println("Qual pilha para adicionar ao topo: ");
                            int pilhaAdicionada = scanner.nextInt();

                            switch (pilhaAdicionada) {
                                case 1 -> {
                                    Integer addedDisc = memoria.remove();
                                    if (pilha1.estaVazia() || addedDisc <= pilha1.getTop().data) {
                                        pilha1.insere(addedDisc);
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaDecrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é maior que o topo da Pilha 1");
                                    }
                                }
                                case 2 -> {
                                    Integer addedDisc = memoria.remove();
                                    if (pilha2.estaVazia() || addedDisc <= pilha2.getTop().data) {
                                        pilha2.insere(addedDisc);
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaDecrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é maior que o topo da Pilha 2");
                                    }
                                }
                                case 3 -> {
                                    Integer addedDisc = memoria.remove();
                                    if (pilha3.estaVazia() || addedDisc <= pilha3.getTop().data) {
                                        pilha3.insere(addedDisc);
                                        countJogadas++;
                                        ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                                        escolhaDecrescente = true;
                                    } else {
                                        System.out.println("Movimento inválido. O disco é maior que o topo da Pilha 3");
                                    }
                                }
                                default -> System.out.println("Opcao invalida");
                            }
                        }

                        if (pilha1.estaVazia() && pilha2.estaVazia()) {
                            if (pilha3.estaDecrescente(memoria)) {
                                System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                jogoEncerrado = true;
                            }
                        } else if (pilha1.estaVazia() && pilha3.estaVazia()) {
                            if (pilha2.estaDecrescente(memoria)) {
                                System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                jogoEncerrado = true;
                            }
                        } else if (pilha2.estaVazia() && pilha3.estaVazia()) {
                            if (pilha1.estaDecrescente(memoria)) {
                                System.out.println("Jogo finalizado em " + countJogadas + " jogadas.");
                                jogoEncerrado = true;
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean crescente = ordenacao == 1;
                    ResolverJogo.resolver(tamanho_pilha, pilha1, pilha3, pilha2, crescente);
                    ImprimePilhas.imprimePilhas(pilha1, pilha2, pilha3);
                    System.out.println("Jogo resolvido em: " + ResolverJogo.countMoves);
                    jogoEncerrado = true;
                }
                default -> System.out.println("Opcao invalida");
            }
        }
    }
}
