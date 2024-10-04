package net.josaca.ejerciciosGestionProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ej6 {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Type the correct command...");
            System.exit(1);
        }
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            Process p = pb.start();
            try (InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)) {
                int codRet = p.waitFor();
                System.out.println("Execution of " + Arrays.toString(args)
                        + " returns " + codRet
                        + " " + (codRet == 0 ? "(execution OK)" : "(ERROR!!!)")
                );
                System.out.println("Output of process");
                System.out.println("------------------");
                String linea = null;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("------------------");
            }
        } catch (IOException e) {
            System.err.println("Error during process execution.");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException ex) {
            System.err.println("Process interrupted...");
            System.exit(3);
        }
    }
}