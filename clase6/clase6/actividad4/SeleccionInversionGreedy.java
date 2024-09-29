package actividad4;

import java.util.Arrays;
import java.util.Comparator;

public class SeleccionInversionGreedy {

    static class Paquete {
        int costo;
        int ganancia;

        public Paquete(int costo, int ganancia) {
            this.costo = costo;
            this.ganancia = ganancia;
        }
    }

    public static void main(String[] args) {
        Paquete[] paquetes = {
            new Paquete(12, 150),  // Paquete 1
            new Paquete(20, 200),  // Paquete 2
            new Paquete(15, 100),  // Paquete 3
            new Paquete(25, 300)   // Paquete 4
        };

        int presupuesto = 35;
        int maxGanancia = algoritmoGreedy(paquetes, presupuesto);
        System.out.println("Máxima ganancia (Greedy): " + maxGanancia);
    }

    public static int algoritmoGreedy(Paquete[] paquetes, int presupuesto) {
        // Ordenar los paquetes por ganancia/costo de mayor a menor
        Arrays.sort(paquetes, Comparator.comparingDouble(p -> -(double) p.ganancia / p.costo));

        int gananciaTotal = 0;
        int costoTotal = 0;

        for (Paquete p : paquetes) {
            if (costoTotal + p.costo <= presupuesto) {
                costoTotal += p.costo;
                gananciaTotal += p.ganancia;
            }
        }

        return gananciaTotal;
    }
}
