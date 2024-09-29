package actividad3;

public class SeleccionProyectosFuerzaBruta {

    static class Proyecto {
        int costo;
        int beneficio;

        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }
    }

    public static void main(String[] args) {
        Proyecto[] proyectos = {
            new Proyecto(10, 100),  // Proyecto 1
            new Proyecto(15, 200),  // Proyecto 2
            new Proyecto(20, 150),  // Proyecto 3
            new Proyecto(25, 300)   // Proyecto 4
        };

        int presupuesto = 40;
        int maxBeneficio = fuerzaBruta(proyectos, presupuesto);
        System.out.println("Máximo beneficio (Fuerza Bruta): " + maxBeneficio);
    }

    public static int fuerzaBruta(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;
        int mejorBeneficio = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {
            int costoTotal = 0;
            int beneficioTotal = 0;

            // Evaluar combinación
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += proyectos[j].costo;
                    beneficioTotal += proyectos[j].beneficio;
                }
            }

            // Verificar si no se excede el presupuesto
            if (costoTotal <= presupuesto) {
                mejorBeneficio = Math.max(mejorBeneficio, beneficioTotal);
            }
        }

        return mejorBeneficio;
    }
}
