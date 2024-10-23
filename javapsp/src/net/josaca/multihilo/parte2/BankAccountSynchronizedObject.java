package net.josaca.multihilo.parte2;


public class BankAccountSynchronizedObject {

    public static void main(String[] args) {

        BankAccountObject myAccount = new BankAccountObject(100);

        Thread[] transacciones = new Thread[40];

        for (int i = 0; i < 20; i++) {
            transacciones[i] = new BankThreadSaveObject(myAccount);
        }
        for (int i = 20; i < 40; i++) {
            transacciones[i] = new BankThreadSpendObject(myAccount);
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

class BankThreadSaveObject extends Thread {
    BankAccountObject bankAccount;

    public BankThreadSaveObject(BankAccountObject bankAccount) {
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

class BankThreadSpendObject extends Thread {
    BankAccountObject bankAccount;

    public BankThreadSpendObject(BankAccountObject bankAccount) {
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

class BankAccountObject {

    int balance;

    public BankAccountObject(int balance) {
        this.balance = balance;
    }

    public void addMoney(int amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    public void takeOutMoney(int amount) {
        synchronized (this) {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}