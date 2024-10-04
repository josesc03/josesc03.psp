package net.josaca.ejerciciosGestionProcesos;

import java.io.*;

public class Ej4 {
    public static void main(String[] args) {
        verDirectorio("C:\\Users\\pc\\Documents\\tests");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        verDirectorio("C:\\Users\\pc\\Documents\\helloDevilMod");
    }

    public static void verDirectorio(String path) {
        String line;

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
        pb.directory(new File(path));

        try {
            System.out.println("-------------PROCESO-----------");

            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            pb.environment().forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("- - - - - - - - - - - - - - - - - - - - -");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Directorio de trabajo: " + pb.directory());
        System.out.println("-------------END PROCESO-----------");

    }
}
