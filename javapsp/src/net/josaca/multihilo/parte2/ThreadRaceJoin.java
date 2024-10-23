package net.josaca.multihilo.parte2;

public class ThreadRaceJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread A = new ThreadRacer();
        Thread B = new ThreadRacer();
        Thread C = new ThreadRacer();

        A.start();
        A.join();
        B.start();
        B.join();
        C.start();
        C.join();

        System.out.println("Procesos terminados.");

    }

}

class ThreadRacer extends Thread {
    int contador;

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            try {
                Thread.sleep(1);
                System.out.println(getContador());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            contador++;
        }
        super.run();
    }

    public int getContador() {
        return contador;
    }
}
