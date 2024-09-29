
public class MochilaDinamica {

    public static int optimizarMochila(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2};  // Pesos de los objetos
        int[] valores = {4, 5, 3};  // Valores de los objetos
        int capacidad = 6;  // Capacidad máxima de la mochila

        int valorMaximo = optimizarMochila(pesos, valores, capacidad);
        System.out.println("Valor máximo con la capacidad " + capacidad + " es: " + valorMaximo);
    }
}
