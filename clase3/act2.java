import java.util.ArrayList;

public class EncontrarDosMayores {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(12);
        numeros.add(7);
        numeros.add(3);
        numeros.add(18);
        numeros.add(6);
        numeros.add(9);

        Resultados resultados = encontrarDosMayores(numeros);
        System.out.println("Dos números mayores: " + resultados.max1 + " y " + resultados.max2);
    }

    private static Resultados encontrarDosMayores(ArrayList<Integer> numeros) {
        return encontrarDosMayores(numeros, 0, numeros.size());
    }

    private static Resultados encontrarDosMayores(ArrayList<Integer> numeros, int inicio, int fin) {
        if (fin - inicio == 1) {
            // Caso base: solo un número
            return new Resultados(numeros.get(inicio), Integer.MIN_VALUE);
        } else if (fin - inicio == 2) {
            // Caso base: dos números
            int num1 = numeros.get(inicio);
            int num2 = numeros.get(inicio + 1);
            if (num1 > num2) {
                return new Resultados(num1, num2);
            } else {
                return new Resultados(num2, num1);
            }
        } else {
            // Dividir la lista en dos partes
            int mitad = (inicio + fin) / 2;
            Resultados izq = encontrarDosMayores(numeros, inicio, mitad);
            Resultados der = encontrarDosMayores(numeros, mitad, fin);

            // Encontrar los dos mayores combinados
            return combinarResultados(izq, der);
        }
    }

    private static Resultados combinarResultados(Resultados izq, Resultados der) {
        // Inicializar los dos mayores globales
        int max1 = Math.max(izq.max1, der.max1);
        int max2;

        // Determinar el segundo mayor
        if (izq.max1 > der.max1) {
            max2 = Math.max(izq.max2, der.max1);
        } else {
            max2 = Math.max(izq.max1, der.max2);
        }

        return new Resultados(max1, max2);
    }

    // Clase para almacenar los dos números mayores encontrados
    private static class Resultados {
        int max1;
        int max2;

        Resultados(int max1, int max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }
}
