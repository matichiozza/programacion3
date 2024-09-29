package actividad4;

public class SeleccionInversionDinamica {

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
        int maxGanancia = programacionDinamica(paquetes, presupuesto);
        System.out.println("Máxima ganancia (Programación Dinámica): " + maxGanancia);
    }

    public static int programacionDinamica(Paquete[] paquetes, int presupuesto) {
        int n = paquetes.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (paquetes[i - 1].costo <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - paquetes[i - 1].costo] + paquetes[i - 1].ganancia);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }

        // La ganancia máxima estará en dp[n][presupuesto]
        return dp[n][presupuesto];
    }
}
