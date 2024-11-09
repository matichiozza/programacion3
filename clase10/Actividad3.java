

public class Actividad3 {

    static int N = 4;

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean esSeguro(char[][] tablero, int fila, int col, char tipo) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == tipo || tablero[i][col] == tipo) {
                return false;
            }
        }
        return true;
    }

    public static void resolverDistribucion() {
        char[][] tablero = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }
        colocarEquipos(tablero, 0, 0, 0, 0);
    }

    public static void colocarEquipos(char[][] tablero, int fila, int col, int computadorasColocadas, int impresorasColocadas) {
        if (computadorasColocadas == 4 && impresorasColocadas == 4) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = (i == fila ? col : 0); j < N; j++) {
                if (computadorasColocadas < 4 && esSeguro(tablero, i, j, 'C')) {
                    tablero[i][j] = 'C';
                    colocarEquipos(tablero, i, j + 1, computadorasColocadas + 1, impresorasColocadas);
                    tablero[i][j] = '.';
                }
                if (impresorasColocadas < 4 && esSeguro(tablero, i, j, 'I')) {
                    tablero[i][j] = 'I';
                    colocarEquipos(tablero, i, j + 1, computadorasColocadas, impresorasColocadas + 1);
                    tablero[i][j] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        resolverDistribucion();
    }
}
