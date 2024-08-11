public class App {
    public static void main(String[] args) throws Exception {
        int[] lista = new int[5];
        int max = 0;

        for (int i = 0; i < lista.length; i++) {
            lista[i] = i;
        }

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > max){
                max = lista[i];
            }
        }

        System.out.println(max);

    }
}
