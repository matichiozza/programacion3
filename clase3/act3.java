import java.util.ArrayList;

public class EncontrarDosClientesMaximos {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Matias", 1.9));
        clientes.add(new Cliente(3, "Juan", 1.4));
        clientes.add(new Cliente(4, "Raul", 1.5));
        clientes.add(new Cliente(5, "Daniela", 2.1));
        clientes.add(new Cliente(6, "Ana", 2.0));
        clientes.add(new Cliente(7, "Luis", 1.7));

        Resultados resultados = encontrarDosClientesMaximos(clientes);
        System.out.println("Clientes con los dos scoring máximos:");
        System.out.println("1. " + resultados.max1);
        System.out.println("2. " + resultados.max2);
    }

    private static Resultados encontrarDosClientesMaximos(ArrayList<Cliente> clientes) {
        return encontrarDosClientesMaximos(clientes, 0, clientes.size());
    }

    private static Resultados encontrarDosClientesMaximos(ArrayList<Cliente> clientes, int inicio, int fin) {
        if (fin - inicio == 1) {
            // Caso base: solo un cliente
            Cliente cliente = clientes.get(inicio);
            return new Resultados(cliente, null);
        } else if (fin - inicio == 2) {
            // Caso base: dos clientes
            Cliente cliente1 = clientes.get(inicio);
            Cliente cliente2 = clientes.get(inicio + 1);
            if (cliente1.getScoring() > cliente2.getScoring()) {
                return new Resultados(cliente1, cliente2);
            } else {
                return new Resultados(cliente2, cliente1);
            }
        } else {
            // Dividir la lista en dos partes
            int mitad = (inicio + fin) / 2;
            Resultados izq = encontrarDosClientesMaximos(clientes, inicio, mitad);
            Resultados der = encontrarDosClientesMaximos(clientes, mitad, fin);

            // Combinar los resultados de las dos partes
            return combinarResultados(izq, der);
        }
    }

    private static Resultados combinarResultados(Resultados izq, Resultados der) {
        // Inicializar los dos clientes con el scoring máximo global
        Cliente max1, max2;

        // Determinar el primer cliente con el scoring máximo global
        if (izq.max1.getScoring() > der.max1.getScoring()) {
            max1 = izq.max1;
            max2 = Math.max(izq.max2 != null ? izq.max2.getScoring() : Double.MIN_VALUE,
                            der.max1.getScoring()) == der.max1.getScoring() ? der.max1 : izq.max2;
        } else {
            max1 = der.max1;
            max2 = Math.max(izq.max1.getScoring(), der.max2 != null ? der.max2.getScoring() : Double.MIN_VALUE) == izq.max1.getScoring() ? izq.max1 : der.max2;
        }

        return new Resultados(max1, max2);
    }

    // Clase para almacenar los dos clientes con los scoring máximos encontrados
    private static class Resultados {
        Cliente max1;
        Cliente max2;

        Resultados(Cliente max1, Cliente max2) {
            this.max1 = max1;
            this.max2 = max2;
        }
    }

    // Clase Cliente
    private static class Cliente {
        private int idCliente;
        private String nombre;
        private double scoring;

        Cliente(int idCliente, String nombre, double scoring) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        public int getIdCliente() {
            return this.idCliente;
        }

        public String getNombre() {
            return this.nombre;
        }

        public double getScoring() {
            return this.scoring;
        }

        @Override
        public String toString() {
            return this.nombre + " " + this.idCliente + " " + this.scoring;
        }
    }
}
