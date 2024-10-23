package net.josaca.multihilo.parte1;

public class HiloConIdentificador {

    public static void main(String[] args) {

        // hilo con id y metodo sleep

        HiloIdentificador t = new HiloIdentificador();

        t.start();

        /*
        el hilo desde el que se llama a sleep es el que duerme y el
        hilo t seguirá ejecutándose mientras el hilo principal duerme
        */

        try {
            t.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

class HiloIdentificador extends Thread {
    @Override
    public void run() {
        System.out.println("Thread #" + Thread.currentThread().getId());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("He dormido 2 segunditos");

        super.run();
    }
}