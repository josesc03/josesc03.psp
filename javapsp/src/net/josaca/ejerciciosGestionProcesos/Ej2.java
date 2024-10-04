package net.josaca.ejerciciosGestionProcesos;

public class Ej2 {
    public void execute(String path) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(path);
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Windows\\WinSxS\\wow64_microsoft-windows-calc_31bf3856ad364e35_10.0.22621.1_none_15a8774142daea37\\calc.exe";
        Ej2 lp = new Ej2();
        lp.execute(path);
        System.out.println("Terminated.");
    }
}
