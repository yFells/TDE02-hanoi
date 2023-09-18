public class ResolverJogo {

    public static int countMoves;

    public static void resolver(int n, Pilha origem, Pilha destino, Pilha auxiliar, boolean ascending) {
        if (n == 1) {
            Integer disco = origem.remove();
            if (ascending) {
                destino.insereCrescente(disco);
            } else {
                destino.insereDecrescente(disco);
            }
            countMoves++;
        } else {
            resolver(n - 1, origem, auxiliar, destino, ascending);
            Integer disco = origem.remove();
            if (ascending) {
                destino.insereCrescente(disco);
            } else {
                destino.insereDecrescente(disco);
            }
            countMoves++;
            resolver(n - 1, auxiliar, destino, origem, ascending);
        }
    }
}