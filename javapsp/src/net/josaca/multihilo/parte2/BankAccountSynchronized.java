package net.josaca.multihilo.parte2;

import java.util.ArrayList;
import java.util.List;

public class BankAccountSynchronized {

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(100);

        Thread[] transacciones = new Thread[40];

        for (int i = 0; i < 20; i++) {
            transacciones[i] = new BankThreadSave(myAccount);
        }
        for (int i = 20; i < 40; i++) {
            transacciones[i] = new BankThreadSpend(myAccount);
        }

        for (int i = 0; i <= transacciones.length - 1; i++) {
            transacciones[i].start();
        }

        for (int i = 0; i <= transacciones.length - 1; i++) {
            try {
                transacciones[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Saldo final: " + myAccount.getBalance());

    }

}

class BankThreadSave extends Thread {
    BankAccount bankAccount;

    public BankThreadSave(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.addMoney(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.run();
    }
}

class BankThreadSpend extends Thread {
    BankAccount bankAccount;

    public BankThreadSpend(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.takeOutMoney(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        super.run();
    }
}

class BankAccount {

    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void addMoney(int amount) {
        balance += amount;
    }

    public synchronized void takeOutMoney(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}