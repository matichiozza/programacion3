import java.util.*;

public class Logistica {

    static class Edge {
        int target;
        int time;

        Edge(int target, int time) {
            this.target = target;
            this.time = time;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int time) {
            adjList.get(source).add(new Edge(target, time));
            adjList.get(target).add(new Edge(source, time)); // Para un grafo no dirigido
        }

        void dijkstra(int startVertex) {
            int[] times = new int[vertices];
            Arrays.fill(times, Integer.MAX_VALUE);
            times[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.time));
            pq.add(new Edge(startVertex, 0));

            boolean[] visited = new boolean[vertices];

            while (!pq.isEmpty()) {
                int u = pq.poll().target;

                if (visited[u]) continue;
                visited[u] = true;

                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;
                    int time = edge.time;

                    if (!visited[v] && times[u] + time < times[v]) {
                        times[v] = times[u] + time;
                        pq.add(new Edge(v, times[v]));
                    }
                }
            }

            printSolution(times, startVertex);
        }

        void printSolution(int[] times, int startVertex) {
            System.out.println("Tiempo mínimo de entrega desde el centro de distribución principal (" + startVertex + "):");
            for (int i = 0; i < vertices; i++) {
                if (times[i] == Integer.MAX_VALUE) {
                    System.out.println("Ciudad " + i + ": No hay ruta");
                } else {
                    System.out.println("Hasta ciudad " + i + ": " + times[i] + " minutos");
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6; // Número de centros de distribución
        Graph graph = new Graph(vertices);

        // Agregar aristas (centro1, centro2, tiempo en minutos)
        graph.addEdge(0, 1, 10); // Ciudad 0 - Ciudad 1 con tiempo 10 minutos
        graph.addEdge(0, 2, 15); // Ciudad 0 - Ciudad 2 con tiempo 15 minutos
        graph.addEdge(1, 2, 12); // Ciudad 1 - Ciudad 2 con tiempo 12 minutos
        graph.addEdge(1, 3, 15); // Ciudad 1 - Ciudad 3 con tiempo 15 minutos
        graph.addEdge(2, 3, 10); // Ciudad 2 - Ciudad 3 con tiempo 10 minutos
        graph.addEdge(2, 4, 5);  // Ciudad 2 - Ciudad 4 con tiempo 5 minutos
        graph.addEdge(3, 4, 10); // Ciudad 3 - Ciudad 4 con tiempo 10 minutos
        graph.addEdge(4, 5, 3);  // Ciudad 4 - Ciudad 5 con tiempo 3 minutos
        graph.addEdge(3, 5, 8);  // Ciudad 3 - Ciudad 5 con tiempo 8 minutos

        graph.dijkstra(0);  // Ejecutar Dijkstra desde el centro de distribución principal (vértice 0)
    }
}
