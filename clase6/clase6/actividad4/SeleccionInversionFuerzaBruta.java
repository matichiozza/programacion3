package actividad4;

public class SeleccionInversionFuerzaBruta {

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
        int maxGanancia = fuerzaBruta(paquetes, presupuesto);
        System.out.println("Máxima ganancia (Fuerza Bruta): " + maxGanancia);
    }

    public static int fuerzaBruta(Paquete[] paquetes, int presupuesto) {
        int n = paquetes.length;
        int mejorGanancia = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {
            int costoTotal = 0;
            int gananciaTotal = 0;

            // Evaluar cada combinación
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += paquetes[j].costo;
                    gananciaTotal += paquetes[j].ganancia;
                }
            }

            // Si el costo total es menor o igual al presupuesto, actualizar la mejor ganancia
            if (costoTotal <= presupuesto) {
                mejorGanancia = Math.max(mejorGanancia, gananciaTotal);
            }
        }

        return mejorGanancia;
    }
}
