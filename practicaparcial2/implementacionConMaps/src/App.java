import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        Map<Integer, Double> resultado = new HashMap<>();

        // Población de datos para facturas y clientes

        for (Factura factura : facturas) {
            resultado.put(factura.idCliente, resultado.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        // Imprimir resultado
        for (Map.Entry<Integer, Double> entry : resultado.entrySet()) {
            System.out.println("ID Cliente: " + entry.getKey() + ", Suma Importes: " + entry.getValue());
        }
    }
}
