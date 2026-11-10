/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import modelo.Cajero;
import java.util.HashMap;

/**
 *
 * @author Hplay
 */
public class Dispensador {
    HashMap<Integer, Integer> cajero_automatico = new HashMap<>();
    private static final int[] denominaciones = {10000, 20000, 50000, 100000};
    

    public Dispensador(Cajero c) {
        cajero_automatico.put(10000, c.getNdiez());
        cajero_automatico.put(20000, c.getNveinte());
        cajero_automatico.put(50000, c.getNcincuenta());
        cajero_automatico.put(100000, c.getNcien());        
    }
    
    public int obtener_cantidad(int denominacion){
        if (!cajero_automatico.containsKey(denominacion)) {
            return -1;
        }
        return cajero_automatico.get(denominacion);
    }    
    
    public String validar_monto(int monto){
        if (monto < 10000 || monto > 1000000) {
            return "Error:  el monto debe estar entre 10.000 y 1.000.000";
        }
        else if (monto % 10000 != 0) {
            return "Error: el monto debe ser multiplo de 10";
        }
        return "";
    }
    
    private int repartir(int monto, int [] billetes){
        for (int i = denominaciones.length - 1; i >= 0; i--) {
            int disponibles = obtener_cantidad(denominaciones[i] - billetes[i]);
            int necesarios = monto / denominaciones[i];
            int usar = Math.min(necesarios, disponibles);
            billetes[i] += usar;
            monto = monto - usar * denominaciones[i];
        }
        return monto;
    }
    
    public int[] calcular_distribucion(int monto){
        int[] billetes = new int[4];

        // Regla especial de 50.000: 1 de 10.000 y 2 de 20.000 (si los hay)
        if (monto == 50000 && obtener_cantidad(10000) >= 1 && obtener_cantidad(20000) >= 2) {
            billetes[0] = 1;
            billetes[1] = 2;
            return billetes;
        }

        // Regla especial de 100.000 o más: 1 de 10.000, 2 de 20.000 y 1 de 50.000 (si los hay)
        if (monto >= 100000 && obtener_cantidad(10000) >= 1
                && obtener_cantidad(20000) >= 2 && obtener_cantidad(50000) >= 1) {
            billetes[0] = 1;
            billetes[1] = 2;
            billetes[2] = 1;
            int sobra = repartir(monto - 100000, billetes);
            if (sobra == 0) {
                return billetes;
            }
            billetes = new int[4];   // no alcanzó con la regla: se intenta el reparto normal
        }

        // Reparto normal: menor cantidad de billetes con los que hay
        int sobra = repartir(monto, billetes);
        if (sobra != 0) {
            return null;   // el cajero no tiene billetes para armar ese monto
        }        
            return billetes;
    }
   
    
    public void descontar_billetes(Cajero c, int[] billetes){
        c.setNdiez(obtener_cantidad(10000) - billetes[0]);
        c.setNveinte(obtener_cantidad(20000) - billetes[1]);
        c.setNcincuenta(obtener_cantidad(50000) - billetes[2]);
        c.setNcien(obtener_cantidad(100000) - billetes[3]);
    }    
}//fin de lac lase
