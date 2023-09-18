public class ImprimePilhas {
    public static void imprimePilhas(Pilha pilha1, Pilha pilha2, Pilha pilha3) {
        Node atual1 = pilha1.getTop();
        Node atual2 = pilha2.getTop();
        Node atual3 = pilha3.getTop();

        System.out.println("P.1\t\tP.2\t\tP.3");

        while (atual1 != null || atual2 != null || atual3 != null) {
            String data1 = (atual1 != null) ? atual1.data.toString() : " ";
            String data2 = (atual2 != null) ? atual2.data.toString() : " ";
            String data3 = (atual3 != null) ? atual3.data.toString() : " ";

            System.out.println(data1 + "\t\t" + data2 + "\t\t" + data3);

            if (atual1 != null) atual1 = atual1.next;
            if (atual2 != null) atual2 = atual2.next;
            if (atual3 != null) atual3 = atual3.next;
        }
    }
}
