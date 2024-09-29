package actividad2;

public class LogisticsFloydWarshall {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
        LogisticsFloydWarshall lw = new LogisticsFloydWarshall();
        // Representación de los centros de distribución y sus conexiones
        int graph[][] = { 
                            {0, 3, INF, INF, 5},  // Centro 1
                            {INF, 0, INF, 2, INF}, // Centro 2
                            {INF, -2, 0, INF, INF}, // Centro 3 (costo negativo)
                            {1, INF, 3, 0, INF},   // Centro 4
                            {INF, INF, -1, 2, 0}   // Centro 5
                        };
        int V = graph.length;
        lw.floydWarshall(graph, V);
    }

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
        
        // Verificar la existencia de ciclos negativos
        checkNegativeCycles(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de tiempos mínimos de entrega entre cada par de centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    void checkNegativeCycles(int dist[][], int V) {
        boolean hasNegativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println("Existen ciclos negativos en el sistema de rutas. Oportunidades de ahorro infinito.");
        } else {
            System.out.println("No se encontraron ciclos negativos en el sistema de rutas.");
        }
    }
}
