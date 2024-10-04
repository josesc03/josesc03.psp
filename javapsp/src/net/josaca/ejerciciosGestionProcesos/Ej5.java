package net.josaca.ejerciciosGestionProcesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        ask();
    }

    public static void ask() {
        Scanner sc = new Scanner(System.in);
        String file = "";
        while (true) {
            System.out.println("\nIngresa el nombre del archivo (0 to EXIT):");
            file = sc.nextLine();
            if (file.equals("0")) {
                System.out.println("Saliendo...");
                break;
            }
            escanearArchivo(file);
        }
    }

    public static void escanearArchivo(String file) {
        String line;
        int countlines = 0;
        int countwords = 0;
        int countletters = 0;
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "find", "/v", "\"\"", file);
        pb.directory(new File("C:\\Users\\pc\\Documents\\test"));
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = br.readLine()) != null) {
                countlines++;
                if (countlines > 2) {
                    countletters += line.length();
                    String[] piezas = line.split(" ");
                    for (String pieza : piezas) {
                        countwords++;
                    }
                    System.out.println(line);
                }
            }
            System.out.println(p.exitValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hay un total de " + (countlines - 2) + " lineas");
        System.out.println("Hay un total de " + countwords + " palabras");
        System.out.println("Hay un total de " + countletters + " letras");

    }
}
