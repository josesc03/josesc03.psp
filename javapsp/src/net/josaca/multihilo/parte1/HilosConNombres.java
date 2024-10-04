package net.josaca.multihilo.parte1;

public class HilosConNombres {

    public static void main(String[] args) {
        HiloNombrado hilo = new HiloNombrado("ThreadNombrado");
        hilo.start();
    }

}

class HiloNombrado extends Thread {
    @Override
    public void run() {
        System.out.println("Hola me llamo: " + Thread.currentThread().getName());
        super.run();
    }

    public HiloNombrado(String name) {
        super(name);
    }
}
