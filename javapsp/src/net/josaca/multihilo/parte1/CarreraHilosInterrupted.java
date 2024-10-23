package net.josaca.multihilo.parte1;

public class CarreraHilosInterrupted {

    public static void main(String[] args) {

        HiloContadorConInterrupted A = new HiloContadorConInterrupted("A");
        HiloContadorConInterrupted B = new HiloContadorConInterrupted("B");
        HiloContadorConInterrupted C = new HiloContadorConInterrupted("C");

        A.start();
        A.setKilled(true);
        B.start();
        C.start();

        do {
            System.out.printf("Hilo " + A.getName() + ": %5s  ", A.getContador());
            System.out.printf("Hilo " + B.getName() + ": %5s  ", B.getContador());
            System.out.printf("Hilo " + C.getName() + ": %5s  ", C.getContador());
            System.out.println();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while (A.isAlive() && B.isAlive() && C.isAlive());

        if (!A.isAlive()) {
            System.out.println("El hilo " + A.getName() + " ha ganado");
        }
        if (!B.isAlive()) {
            System.out.println("El hilo " + B.getName() + " ha ganado");
        }
        if (!C.isAlive()) {
            System.out.println("El hilo " + C.getName() + " ha ganado");
        }

        B.setKilled(true);
        C.setKilled(true);
    }

}

class HiloContadorConInterrupted extends Thread {

    private int contador;
    private boolean killed;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i <= 1000; i++) {
                if (i == 700 && isKilled()) {
                    Thread.currentThread().interrupt();
                    break;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                contador = i;
            }
        }
        super.run();
    }

    public HiloContadorConInterrupted(String name) {
        super(name);
        contador = 0;
        killed = false;
    }

    public int getContador() {
        return contador;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
}