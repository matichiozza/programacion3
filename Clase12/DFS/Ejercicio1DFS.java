import java.util.*;

public class Ejercicio1DFS {
    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    // agregar una arista al grafo
    public void agregarArista(int origen, int destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()).add(origen);
    }

    // Método principal de DFS
    public void dfs(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>(); // aca almacenamos los nodos visitados
        dfsRecursivo(nodoInicial, visitado);
    }

    // DFS recursivo
    private void dfsRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo); // actualizar el nodo como visitado
        System.out.println("Visitando nodo: " + nodo);

        // explora vecinos no visitados
        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                dfsRecursivo(vecino, visitado);
            }
        }
    }
}
