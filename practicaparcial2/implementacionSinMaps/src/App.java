import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<SumaImportes> resultado = new ArrayList<>();

        // Población de datos para facturas y clientes

        for (Cliente cliente : clientes) {
            double suma = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }
            resultado.add(new SumaImportes(cliente.idCliente, suma));
        }

        // Imprimir resultado
        for (SumaImportes si : resultado) {
            System.out.println("ID Cliente: " + si.idCliente + ", Suma Importes: " + si.sumaImportes);
        }
    }
}
