package net.josaca.tests;

public class TestLoading {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("-");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\\");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("|");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("/");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\\");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("|");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("/");
            Thread.sleep(200);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
