/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej14;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Mario
 */
public class Ej14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sumaTemperaturas = 0;
        double temperatura;
        double tempMax = 0;
        double tempMin = 40;
        final int numHoras = 24;

        Random random = new Random(System.currentTimeMillis());
        DecimalFormat df = new DecimalFormat("#0.00");

        for (int i = 0; i < numHoras; i++) {
            temperatura = random.nextDouble() * 40;
            sumaTemperaturas += temperatura;
            System.out.println("Temperatura " + i + ": " + df.format(temperatura));
            if (tempMax < temperatura) {
                tempMax = temperatura;
            }
            if (tempMin > temperatura) {
                tempMin = temperatura;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Temperatura media: " + df.format(sumaTemperaturas / numHoras));
        System.out.println("Temperatura máxima: " + df.format(tempMax));
        System.out.println("Temperatura mínima: " + df.format(tempMin));
    }

}
