package net.josaca.ejercicio3repaso;

import java.util.HashMap;
import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

    //3) You are asked to implement a contact book using a Hash table. Define the "Contact" object with the attributes you want. To reference them in the hash table you will use the first name (without the last name, to simplify it). You must code 1 query method, another for creating contacts and another for modifying the data of 1 contact. The application will be console type, it will show the options menu and respond to the commands entered. 

    Scanner sc;

        sc = new Scanner(System.in);

        boolean menuloop = true;
        HashMap<String, Contacto> agendaContactos = new HashMap<>();

        do {

            int eleccion = -1;

            System.out.printf("%21s\n", "AGENDA DE CONTACTOS");
            System.out.printf("%s\n", "=======================");
            System.out.printf("%21s\n", "1. Añadir contacto.");
            System.out.printf("%21s\n", "2. Buscar contacto.");
            System.out.printf("%23s\n", "3. Eliminar contacto.");
            System.out.printf("%33s\n", "4. Modificar datos de contacto.");
            System.out.printf("%9s\n\n", "5. Exit");

            while (eleccion < 1 || eleccion > 5) {

                System.out.print("Elija una opcion: ");

                try {
                    eleccion = Integer.parseInt(sc.nextLine());
                    System.out.println("\n");
                } catch (NumberFormatException e) {
                    System.out.println("Tiene que elegir una opcion entre 1 y 5.\n");
                }
            }

            switch (eleccion) {

                case 1 -> crearContacto(sc, agendaContactos);
                case 2 -> buscarContacto(sc, agendaContactos);
                case 3 -> eliminarContacto(sc, agendaContactos);
                case 4 -> modificarContacto(sc, agendaContactos);
                case 5 -> menuloop = false;
                default -> System.err.println("Has burlado el sistema");
            }
        } while (menuloop);

        sc.close();

    }

    static void crearContacto(Scanner sc, HashMap<String, Contacto> agenda) {

        String nombre;
        String apellidos;
        String telefono;
        String correo_electronico;

        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el numero de telefono: ");
        telefono = sc.nextLine();

        System.out.println("Desea agregar apellidos? (s/n):");
        if (sc.nextLine().toLowerCase().equals("s")) {
            System.out.print("Ingrese los apellidos: ");
            apellidos = sc.nextLine();
        } else {
            apellidos = "-1";
        }

        System.out.println("Desea agregar correo electronico? (s/n):");
        if (sc.nextLine().toLowerCase().equals("s")) {
            System.out.print("Ingrese el correo electronico: ");
            correo_electronico = sc.nextLine();
        } else {
            correo_electronico = "-1";
        }

        Contacto newContacto = new Contacto(nombre, telefono, apellidos, correo_electronico);
        agenda.put(nombre, newContacto);
        System.out.println("Contacto insertado correctamente.\n ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    static void buscarContacto(Scanner sc, HashMap<String, Contacto> agenda) {

        String nombre;
        System.out.print("Ingrese el nombre del contacto: ");
        nombre = sc.nextLine();
        Contacto contactobuscado = agenda.get(nombre);

        if (contactobuscado != null) {
            System.out.println("Datos del contacto\n==================");
            System.out.println(contactobuscado.toString() + "\n");
        } else {
            System.out.println("No existe un contacto con ese nombre.\n");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

    }

    static void eliminarContacto(Scanner sc, HashMap<String, Contacto> agenda) {

        String nombre;
        System.out.print("Ingrese el nombre del contacto: ");
        nombre = sc.nextLine();
        Contacto contactobuscado = agenda.get(nombre);

        if (contactobuscado != null) {
            agenda.remove(nombre);
            System.out.println("Contacto eliminado\n==================");
            System.out.println(contactobuscado.getNombre() + "\n");
        } else {
            System.out.println("No existe un contacto con ese nombre.\n");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

    }

    static void modificarContacto(Scanner sc, HashMap<String, Contacto> agenda) {

        String nombre;
        System.out.print("Ingrese el nombre del contacto: ");
        nombre = sc.nextLine();
        Contacto contactobuscado = agenda.get(nombre);

        if (contactobuscado != null) {

            agenda.remove(nombre);

            System.out.println("Modificar contacto\n==================");
            String apellidos;
            String telefono;
            String correo_electronico;
            System.out.println("Desea modificar nombre? (s/n):");

            if (sc.nextLine().toLowerCase().equals("s")) {
                System.out.print("Ingrese el nuevo nombre: ");
                nombre = sc.nextLine();
            } else {
                nombre = "-1";
            }

            System.out.println("Desea modificar telefono? (s/n):");

            if (sc.nextLine().toLowerCase().equals("s")) {
                System.out.print("Ingrese el nuevo telefono: ");
                telefono = sc.nextLine();
            } else {
                telefono = "-1";
            }

            System.out.println("Desea agregar/modificar apellidos? (s/n):");

            if (sc.nextLine().toLowerCase().equals("s")) {
                System.out.print("Ingrese los nuevos apellido/s: ");
                apellidos = sc.nextLine();
            } else {
                apellidos = "-1";
            }

            System.out.println("Desea agregar/modificar correo electronico? (s/n):");
            if (sc.nextLine().toLowerCase().equals("s")) {
                System.out.print("Ingrese el nuevo correo electronico: ");
                correo_electronico = sc.nextLine();
            } else {
                correo_electronico = "-1";
            }

            contactobuscado.getNombre();
            Contacto newContacto = new Contacto(nombre, telefono, apellidos, correo_electronico);
            agenda.put(nombre, newContacto);
            System.out.println("Contacto modificado correctamente.\n");
        } else {
            System.out.println("No existe un contacto con ese nombre\n");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

    }

    static class Contacto {

        private final String nombre;
        private final String apellidos;
        private final String telefono;
        private final String correo_electronico;

        public Contacto(String nombre, String telefono, String apellidos, String correo_electronico) {
            this.nombre = nombre;
            this.telefono = telefono;
            
            if (apellidos.equals("-1")) {
                this.apellidos = "None";
            } else {
                this.apellidos = apellidos;
            }

            if (correo_electronico.equals("-1")) {
                this.correo_electronico = "None";
            } else {
                this.correo_electronico = correo_electronico;
            }
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getCorreo_electronico() {
            return correo_electronico;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre=").append(nombre).append("\n");

            if (!apellidos.equals("None")) {
                sb.append("Apellidos=").append(apellidos).append("\n");
            }

            sb.append("Telefono=").append(telefono).append("\n");
            
            if (!correo_electronico.equals("None")) {
                sb.append("Correo electronico=").append(correo_electronico).append("\n");
            }

            return sb.toString();

        }
    }
}