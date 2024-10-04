package net.josaca.multihilo.parte1;

public class HiloMensajeTerminado {
    public static void main(String[] args) {
        HiloMensajero mensajero = new HiloMensajero("HiloMensajero");
        mensajero.start();
        while (mensajero.getState() != Thread.State.TERMINATED) {
            System.out.println(mensajero.getName() + " esta ejecutandose");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(mensajero.getName() + " ha terminado");
    }

}

class HiloMensajero extends Thread {
    @Override
    public void run() {
        System.out.println("Hola, mi nombre es: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
        super.run();
    }

    public HiloMensajero(String name) {
        super(name);
    }
}