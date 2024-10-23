package net.josaca.multihilo.parte2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Lavavajillas {

    public static void main(String[] args) {

        PilaPlatos pila = new PilaPlatos();
        Runnable fregar = new Friega(20, pila);
        Thread t1 = new Thread(fregar);

        Runnable seca = new Seca(20, pila);
        Thread t2 = new Thread(seca);

        t1.start();
        t2.start();

    }

}

class Plato {
    private int id_plato;

    public Plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }
}

class PilaPlatos {
    private Deque<Plato> platos;
    private int counterId = 0;

    public PilaPlatos() {
        platos = new ArrayDeque<>();
    }

    public synchronized void lavar(Plato plato) {
        while (platos.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        platos.push(plato);
        notify();
    }

    public synchronized void secar() {
        while (platos.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Plato plato = platos.pop();
        System.out.println("Plato secado #" + plato.getId_plato() + ",  total en pila: " + platos.size());
        notify();
    }

    public int getCounterId() {
        counterId++;
        return counterId;
    }

    public Deque<Plato> getPlatos() {
        return platos;
    }
}

class Friega implements Runnable {
    int numero;
    PilaPlatos platos;

    public Friega(int N, PilaPlatos pila) {
        numero = N;
        platos = pila;
    }

    @Override
    public void run() {
        for (int i = 0; i < numero; i++) {
            Plato plato = new Plato(platos.getCounterId());
            platos.lavar(plato);
            System.out.println("Plato lavado #" + plato.getId_plato() + ",  total en pila: " + platos.getPlatos().size());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class Seca implements Runnable {
    int numero;
    PilaPlatos platos;

    public Seca(int N, PilaPlatos pila) {
        numero = N;
        platos = pila;
    }

    @Override
    public void run() {
        for (int i = 0; i < numero; i++) {

            platos.secar();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

        }
    }
}