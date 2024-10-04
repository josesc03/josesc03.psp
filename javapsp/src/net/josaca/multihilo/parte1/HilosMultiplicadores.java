package net.josaca.multihilo.parte1;

public class HilosMultiplicadores {
    public static void main(String[] args) {

        MiHilo mihilo = new MiHilo(2);
        MiHilo mihilo2 = new MiHilo(5);

        mihilo.start();
        try {
            mihilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mihilo2.start();
    }
}

class MiHilo extends Thread {
    int numero;

    public MiHilo(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " x " + numero + " = " + numero * i);
        }
    }
}
