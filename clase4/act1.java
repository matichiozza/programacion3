package clase4;

import java.util.ArrayList;
import java.util.Collections;

public class Ejemplo1 {
    public static void main(String[] args) {
        int[] monedas = {50,10,10,5};
        int monto = 70;
        System.out.println(tieneCambio(monedas,monto));
    }

    private static boolean tieneCambio(int[] monedas, int monto) {
        boolean rta = false;
        ArrayList<Integer> numeros = new ArrayList<>();
        for(int i=0; i< monedas.length; i++) {
            numeros.add(monedas[i]);
        }
        Collections.sort(numeros,Collections.reverseOrder());
        for(Integer n : numeros) {
            System.out.println(monto + " " + n);
            monto -= n;
            if (monto==0) return true;
        }
        return rta;
    }


    
}
