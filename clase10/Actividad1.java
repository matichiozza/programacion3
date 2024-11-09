package clase10;

public class DosReinasBacktracking {

    static int N = 4;

    public static boolean esSeguro(int tablero[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1 || tablero[i][col] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i < N && j < N; i++, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = col; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void resolverDosReinas() {
        int tablero[][] = new int[N][N];
        colocarReina(tablero, 0, 0, 0);
    }

    public static boolean colocarReina(int tablero[][], int fila, int col, int reinasColocadas) {
        if (reinasColocadas == 2) {
            imprimirTablero(tablero);
            return true;
        }
        for (int i = fila; i < N; i++) {
            for (int j = col; j < N; j++) {
                if (esSeguro(tablero, i, j)) {
                    tablero[i][j] = 1;
                    colocarReina(tablero, i, j + 1, reinasColocadas + 1);
                    tablero[i][j] = 0;
                }
            }
            col = 0;
        }
        return false;
    }

    public static void imprimirTablero(int tablero[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDosReinas();
    }
}
