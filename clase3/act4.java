import java.util.ArrayList
import java.util.Collections;

public class EncontrarNElementosMaximos {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Collections.addAll(numeros, 5, 12, 7, 3, 18, 6, 9, 15, 20, 2);
        
        int n = 3; // Número de elementos más grandes a encontrar
        ArrayList<Integer> maximos = encontrarNElementosMaximos(numeros, n);
        System.out.println("Los " + n + " elementos más grandes son: " + maximos);
    }

    private static ArrayList<Integer> encontrarNElementosMaximos(ArrayList<Integer> numeros, int n) {
        return encontrarNElementosMaximos(numeros, 0, numeros.size(), n);
    }

    private static ArrayList<Integer> encontrarNElementosMaximos(ArrayList<Integer> numeros, int inicio, int fin, int n) {
        if (fin - inicio <= n) {
            // Caso base: Si la sublista es menor o igual a n, ordena y toma los n más grandes
            ArrayList<Integer> sublista = new ArrayList<>(numeros.subList(inicio, fin));
            Collections.sort(sublista, Collections.reverseOrder());
            return new ArrayList<>(sublista.subList(0, Math.min(n, sublista.size())));
        } else {
            // Dividir la lista en dos mitades
            int mitad = (inicio + fin) / 2;
            ArrayList<Integer> izquierda = encontrarNElementosMaximos(numeros, inicio, mitad, n);
            ArrayList<Integer> derecha = encontrarNElementosMaximos(numeros, mitad, fin, n);

            // Combinar los resultados de las dos mitades
            return combinarListas(izquierda, derecha, n);
        }
    }

    private static ArrayList<Integer> combinarListas(ArrayList<Integer> lista1, ArrayList<Integer> lista2, int n) {
        // Combinar dos listas y tomar los n elementos más grandes
        ArrayList<Integer> combinada = new ArrayList<>(lista1);
        combinada.addAll(lista2);
        
        // Ordenar la lista combinada en orden descendente
        Collections.sort(combinada, Collections.reverseOrder());
        
        // Devolver los primeros n elementos
        return new ArrayList<>(combinada.subList(0, Math.min(n, combinada.size())));
    }
}
