package net.josaca.multihilo.parte1;

public class LanzaHilos {
    public static void main(String[] args) {
        Thread miotro = new Thread(new MiOtroHilo());
        Runnable lambdaRun = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println("Hilo 2: " + i);
            }
        };
        Thread miotrootro = new Thread(lambdaRun);
        miotro.start();
        miotrootro.start();

    }
}

class MiOtroHilo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hilo 1: " + i);
        }
    }
}
