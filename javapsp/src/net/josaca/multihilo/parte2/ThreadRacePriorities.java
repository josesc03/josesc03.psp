package net.josaca.multihilo.parte2;

public class ThreadRacePriorities {

    public static void main(String[] args) throws InterruptedException {

        Thread A = new ThreadRacerPriorities("A");
        Thread B = new ThreadRacerPriorities("B");
        Thread C = new ThreadRacerPriorities("C");

        A.setPriority(Thread.MAX_PRIORITY);
        B.setPriority(Thread.NORM_PRIORITY);
        C.setPriority(Thread.MIN_PRIORITY);

        A.start();
        B.start();
        C.start();

        System.out.println("Procesos terminados.");

    }

}

class ThreadRacerPriorities extends Thread {
    int contador;

    public ThreadRacerPriorities(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            try {
                Thread.sleep(1);
                System.out.println("Thread " + Thread.currentThread().getName() + " - " + getContador());
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
