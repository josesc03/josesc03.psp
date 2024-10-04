package net.josaca.ejercicio1repaso;

import java.util.Scanner;

public class AgendaEstudiantes {

    public static void main(String[] args) {
        Scanner sc;

        String nombre;
        int edad;
        int count = 0;
        String mayor = "none";
        int mayorEdad = 0;
        String menor = "none";
        int menorEdad = 100;

        sc = new Scanner(System.in);

        while (true) {
            nombre = "";
            edad = -1;
            while (nombre.isBlank() || nombre.isEmpty()) {
                System.out.print("Inserte el nombre del Estudiante (* para salir): ");
                nombre = sc.nextLine();

                if (nombre.isEmpty() || nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.\n");
                    nombre = "";
                }
            }

            if (nombre.equals("*")) {
                break;
            }

            while (edad < 0 || edad > 99) {
                System.out.println("Inserte la edad del Estudiante: ");
                try {
                    edad = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Tiene que introducir un número entero.\n");
                    edad = -1;
                }

                if (edad < 0 || edad > 99) {
                    System.out.println("La edad tiene que ser entre 1 y 99");
                }
            }
            
            count += 1;
            if (edad > mayorEdad) {
                mayor = nombre;
                mayorEdad = edad;
            }
            if (edad < menorEdad){
                menor = nombre;
                menorEdad = edad;
            }
        }

        System.out.println("Hay un total de " + count + " estudiantes.");
        System.out.println("El estudiante con mayor edad es: " + mayor);
        System.out.println("El estudiante con menor edad es: " + menor);

        sc.close();
    }

}