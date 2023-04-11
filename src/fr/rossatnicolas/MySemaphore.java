package fr.rossatnicolas;

public class MySemaphore {

    //Pour stocker le nombre de permis disponibles
    private int permits;
    //Un objet lock pour la synchronisation
    private final Object lock = new Object();

    public MySemaphore(int permits) {
        this.permits = permits;
    }

    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (permits <= 0) {
                lock.wait();
            }
            permits--;
        }
    }

    public void release() {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }
}

