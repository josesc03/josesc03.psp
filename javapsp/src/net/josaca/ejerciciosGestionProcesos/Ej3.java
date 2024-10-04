package net.josaca.ejerciciosGestionProcesos;

import java.io.IOException;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Process p;
        try {
            p = Runtime.getRuntime().exec("notepad");
            while (p.isAlive()) {
                Thread.sleep(3000);
                System.out.println(p.isAlive());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
