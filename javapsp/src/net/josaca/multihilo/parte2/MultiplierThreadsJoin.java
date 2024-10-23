package net.josaca.multihilo.parte2;

public class MultiplierThreadsJoin {

    public static void main(String[] args) {

        Thread hiloA = new Thread(new HiloMultiplicador(5));
        Thread hiloB = new Thread(new HiloMultiplicador(7));
        Thread hiloC = new Thread(new HiloMultiplicador(2));

        try {
            hiloA.start();
            hiloA.join();
            hiloB.start();
            hiloB.join();
            hiloC.start();
            hiloC.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

class HiloMultiplicador extends Thread {
    int numero;

    public HiloMultiplicador(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " x " + numero + " = " + numero * i);
        }
    }
}