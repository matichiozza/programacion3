
public class Actividad2 {

    static int N = 4; // Tamaño de la habitación (4x4)

    // Imprime la disposición de escritorios y sillas en el tablero
    public static void imprimirHabitacion(char[][] habitacion) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(habitacion[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Revisa si es seguro colocar un escritorio o silla en una posición específica
    public static boolean esSeguro(char[][] habitacion, int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (habitacion[fila][i] != '.' || habitacion[i][col] != '.') {
                return false;
            }
        }
        return true;
    }

    // Método principal para resolver el problema
    public static void resolverCombinaciones() {
        char[][] habitacion = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                habitacion[i][j] = '.'; // Inicialmente, todas las celdas están vacías
            }
        }
        colocarElementos(habitacion, 0, 0, 0, 0);
    }

    // Coloca escritorios y sillas en el tablero
    public static boolean colocarElementos(char[][] habitacion, int filaEscritorio, int filaSilla, int escritoriosColocados, int sillasColocadas) {
        if (escritoriosColocados == 2 && sillasColocadas == 2) {
            imprimirHabitacion(habitacion);
            return true;
        }

        for (int i = filaEscritorio; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (escritoriosColocados < 2 && esSeguro(habitacion, i, j)) {
                    habitacion[i][j] = 'E';
                    colocarElementos(habitacion, i + 1, filaSilla, escritoriosColocados + 1, sillasColocadas);
                    habitacion[i][j] = '.';
                }
                if (sillasColocadas < 2 && esSeguro(habitacion, i, j)) {
                    habitacion[i][j] = 'S';
                    colocarElementos(habitacion, filaEscritorio, i + 1, escritoriosColocados, sillasColocadas + 1);
                    habitacion[i][j] = '.';
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        resolverCombinaciones();
    }
}
