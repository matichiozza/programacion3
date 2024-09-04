import java.util.*;

class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Constructor para inicializar el grafo con un número dado de vértices
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Método para agregar una arista de u a v
    public void agregarArista(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrizAdyacencia[u][v] = 1;
        } else {
            System.out.println("Índices de vértice fuera de rango.");
        }
    }

    // Método para eliminar una arista de u a v
    public void eliminarArista(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrizAdyacencia[u][v] = 0;
        } else {
            System.out.println("Índices de vértice fuera de rango.");
        }
    }

    // Método para verificar si hay una arista de u a v
    public boolean verificarArista(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            return matrizAdyacencia[u][v] == 1;
        } else {
            System.out.println("Índices de vértice fuera de rango.");
            return false;
        }
    }

    // Método para listar los vértices adyacentes a un vértice dado
    public List<Integer> listarAdyacentes(int u) {
        List<Integer> adyacentes = new ArrayList<>();
        if (u >= 0 && u < numVertices) {
            for (int v = 0; v < numVertices; v++) {
                if (matrizAdyacencia[u][v] == 1) {
                    adyacentes.add(v);
                }
            }
        } else {
            System.out.println("Índice de vértice fuera de rango.");
        }
        return adyacentes;
    }

    // Método para contar el grado de salida de un vértice
    public int contarGradoSalida(int u) {
        if (u >= 0 && u < numVertices) {
            int gradoSalida = 0;
            for (int v = 0; v < numVertices; v++) {
                if (matrizAdyacencia[u][v] == 1) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        } else {
            System.out.println("Índice de vértice fuera de rango.");
            return -1;
        }
    }

    // Método para contar el grado de entrada de un vértice
    public int contarGradoEntrada(int v) {
        if (v >= 0 && v < numVertices) {
            int gradoEntrada = 0;
            for (int u = 0; u < numVertices; u++) {
                if (matrizAdyacencia[u][v] == 1) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        } else {
            System.out.println("Índice de vértice fuera de rango.");
            return -1;
        }
    }

    public static void main(String[] args) {
        // Crear un grafo con 4 vértices
        Grafo grafo = new Grafo(4);

        // Agregar aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);

        // Verificar aristas
        System.out.println("¿Hay arista de 0 a 1? " + grafo.verificarArista(0, 1)); // true
        System.out.println("¿Hay arista de 1 a 0? " + grafo.verificarArista(1, 0)); // false

        // Listar adyacentes
        System.out.println("Vértices adyacentes a 0: " + grafo.listarAdyacentes(0)); // [1, 2]

        // Contar grados
        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0)); // 2
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2)); // 2

        // Eliminar una arista
        grafo.eliminarArista(0, 2);
        System.out.println("Vértices adyacentes a 0 después de eliminar la arista (0,2): " + grafo.listarAdyacentes(0)); // [1]
    }
}
