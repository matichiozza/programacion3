

public class MochilaProgramacionDinamica {

    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto(2, 4),  // Objeto 1
            new Objeto(5, 2),  // Objeto 2
            new Objeto(6, 1),  // Objeto 3
            new Objeto(7, 6)   // Objeto 4
        };

        int capacidadMochila = 10;
        int valorMaximo = programacionDinamica(objetos, capacidadMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo (Programación Dinámica): " + valorMaximo);
    }

    public static int programacionDinamica(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (objetos[i - 1].peso <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - objetos[i - 1].peso] + objetos[i - 1].valor);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo estará en dp[n][capacidad]
        return dp[n][capacidad];
    }
}
