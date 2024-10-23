package net.josaca.multihilo.parte1;

public class CarreraHilos {

    public static void main(String[] args) {

        HiloContador A = new HiloContador("A");
        HiloContador B = new HiloContador("B");
        HiloContador C = new HiloContador("C");

        A.start();
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

    }

}

class HiloContador extends Thread {

    private int contador;

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            contador = i;
        }
        super.run();
    }

    public HiloContador(String name) {
        super(name);
        contador = 0;
    }

    public int getContador() {
        return contador;
    }
}