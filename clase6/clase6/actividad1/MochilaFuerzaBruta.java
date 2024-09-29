public class MochilaFuerzaBruta {
    // Clase para representar un objeto con peso y valor
    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    // Función principal
    public static void main(String[] args) {
        // Definir los objetos
        Objeto[] objetos = {
            new Objeto(3, 4),  // Objeto 1
            new Objeto(4, 5),  // Objeto 2
            new Objeto(2, 3)   // Objeto 3
        };

        int capacidad = 6;  // Capacidad máxima de la mochila

        // Llamar a la función que realiza la búsqueda de la mejor combinación
        Resultado mejorResultado = mejorCombinacion(objetos, capacidad);

        // Mostrar el resultado
        System.out.println("Valor máximo: " + mejorResultado.valorMaximo);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
    }

    // Clase para almacenar el resultado de la mejor combinación
    static class Resultado {
        int valorMaximo;
        int pesoTotal;

        public Resultado(int valorMaximo, int pesoTotal) {
            this.valorMaximo = valorMaximo;
            this.pesoTotal = pesoTotal;
        }
    }

    // Función para encontrar la mejor combinación
    static Resultado mejorCombinacion(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int mejorValor = 0;
        int mejorPeso = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int pesoTotal = 0;
            int valorTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    pesoTotal += objetos[j].peso;
                    valorTotal += objetos[j].valor;
                }
            }

            // Verificar si el peso total no excede la capacidad y si el valor es mejor
            if (pesoTotal <= capacidad && valorTotal > mejorValor) {
                mejorValor = valorTotal;
                mejorPeso = pesoTotal;
            }
        }

        // Retornar el mejor resultado
        return new Resultado(mejorValor, mejorPeso);
    }
}
