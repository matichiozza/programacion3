package clase4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CambioComprobantes {
    // Función para encontrar la cantidad mínima de comprobantes
    public static List<Integer> encontrarMinimoComprobantes(int[] comprobantes, int monto) {
        // Ordenar los comprobantes de mayor a menor
        Arrays.sort(comprobantes);
        List<Integer> resultado = new ArrayList<>();
        for (int i = comprobantes.length - 1; i >= 0; i--) {
            // Mientras el monto sea mayor o igual al comprobante actual
            while (monto >= comprobantes[i]) {
                monto -= comprobantes[i];
                resultado.add(comprobantes[i]);
            }
        }
        // Si el monto no se ha reducido a 0, significa que no es posible dar el cambio exacto
        if (monto > 0) {
            throw new IllegalArgumentException("No se puede dar el cambio exacto con los comprobantes disponibles.");
        }
        return resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] comprobantes = {100, 50, 20, 10, 5, 1}; // Diferentes tipos de comprobantes
        int monto = 123; // Monto objetivo
        try {
            List<Integer> resultado = encontrarMinimoComprobantes(comprobantes, monto);
            System.out.println("Comprobantes usados para hacer " + monto + ": " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
