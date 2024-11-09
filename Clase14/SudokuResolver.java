public class SudokuResolver {

    // especificamos el tamanio que tendra tablero
    private static final int SIZE = 6;

    // llama a la función para resolver
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0, 0, 4, 0},
                {4, 0, 6, 0, 0, 2},
                {0, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0},
                {5, 0, 0, 2, 0, 6},
                {0, 0, 3, 0, 1, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solucion para este sudoku.");
        }
    }

    // resolvemos el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  // para encontrar una celda vacía
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // intenta resolver el tablero recursivamente
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // rollbackea el intento si falla
                            board[row][col] = 0;
                        }
                    }
                    return false;  // si ningun numero es valido, retrocede
                }
            }
        }
        return true;  // El tablero está completo y es válido
    }

    // verifica si un numero puede ser colocado en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // verifica si el numero esta presente en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar si el numero está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // verifica si el numero está en el subcuadro 2x3
        int startRow = (row / 2) * 2; 
        int startCol = (col / 3) * 3;  
        
        // revisa celdas dentro del subcuadrante 2x3
        for (int i = startRow; i < startRow + 2; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;  // si pasa las pruebas, es válido
    }

    // imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
