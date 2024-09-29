public class MochilaFuerzaBruta {

    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto(2, 4),  // Objeto 1
            new Objeto(5, 2),  // Objeto 2
            new Objeto(6, 1),  // Objeto 3
            new Objeto(7, 6)   // Objeto 4
        };

        int capacidadMochila = 10;
        Resultado mejorResultado = encontrarMejorCombinacion(objetos, capacidadMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo (Fuerza Bruta): " + mejorResultado.valorMaximo);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
    }

    static class Resultado {
        int valorMaximo;
        int pesoTotal;

        public Resultado(int valorMaximo, int pesoTotal) {
            this.valorMaximo = valorMaximo;
            this.pesoTotal = pesoTotal;
        }
    }

    public static Resultado encontrarMejorCombinacion(Objeto[] objetos, int capacidad) {
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

            // Verificar si el peso total no excede la capacidad de la mochila y si el valor es mejor
            if (pesoTotal <= capacidad && valorTotal > mejorValor) {
                mejorValor = valorTotal;
                mejorPeso = pesoTotal;
            }
        }

        return new Resultado(mejorValor, mejorPeso);
    }
}
