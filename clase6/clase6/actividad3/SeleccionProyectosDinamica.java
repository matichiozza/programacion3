package actividad3;

public class SeleccionProyectosDinamica {

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
        int maxBeneficio = programacionDinamica(proyectos, presupuesto);
        System.out.println("Máximo beneficio (Programación Dinámica): " + maxBeneficio);
    }

    public static int programacionDinamica(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (proyectos[i - 1].costo <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - proyectos[i - 1].costo] + proyectos[i - 1].beneficio);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }

        // El beneficio máximo estará en dp[n][presupuesto]
        return dp[n][presupuesto];
    }
}
