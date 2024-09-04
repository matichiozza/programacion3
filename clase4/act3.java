package clase4;

import java.util.*;

public class Ejercicio3 {
    // Clase para representar un objeto con su valor y peso
    static class Mercancia {
        double value, weight, ratio;

        Mercancia(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }

        @Override
        public String toString() {
            return this.value + " " + this.weight + " " + this.ratio;
        }
    }

    public static ArrayList<Mercancia> fractionalTruck(int W, Mercancia[] Mercancias) {

        ArrayList<Mercancia> mercanciasCargadas = new ArrayList<>();

        // Ordenar los objetos por la relación valor/peso en orden descendente
        Arrays.sort(Mercancias, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0;

        for (Mercancia mercancia : Mercancias) {
            if (W == 0) break; // Si la mochila está llena, terminar

            if (mercancia.weight <= W) {
                // Tomar el objeto completo
                maxValue += mercancia.value;
                W -= mercancia.weight;
                mercanciasCargadas.add(mercancia);
            } else {
                // Tomar solo la fracción del objeto que cabe en la mochila
                maxValue += mercancia.value * ((double) W / mercancia.weight);
                W = 0;
            }
        }

        return mercanciasCargadas;
    }

    public static void main(String[] args) {
        Mercancia[] Mercancias = {
            new Mercancia(30, 10),
            new Mercancia(50, 20),
            new Mercancia(60, 30)
        };

        int W = 50; // Capacidad de la mochila

        System.out.println("Carga sin fraccionar = " + fractionalTruck(W, Mercancias));
    }
    
}
