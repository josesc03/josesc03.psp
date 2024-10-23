package net.josaca.tests;

public class Test2 {
    public static void main(String[] args) {
//  La letra es legal: true/false.
//  Si la letra del dígito de control es una de estas: "TRWAGMYFPDXBNJZSQVHLCKE" es legal.
//  CIF correcto: true/false. El resto de dividir las 8 primeras cifras entre 23 te indica la posición de la letra del dígito de control dentro de la cadena anterior.

        String DNI = "54426789A";
        String letra = DNI.substring(8);
        String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";

        System.out.println(DNI.substring(8));
        if (letrasValidas.contains(letra)) {
            System.out.println("True letra");

            if (DNI.substring(0, 8).matches("[0-9]{8}")) {
                System.out.println("True numeros");

                int calculo = Integer.parseInt(DNI.substring(0, 8)) % 23;

                if (letrasValidas.substring(calculo, calculo + 1).equals(letra)) {
                    System.out.println("True calculo letra");
                } else {
                    System.out.println("False calculo letra");
                }

            } else {
                System.out.println("False numeros");
            }
            
        } else {
            System.out.println("False letra");
        }

    }
}
