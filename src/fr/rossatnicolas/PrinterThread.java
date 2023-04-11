package fr.rossatnicolas;

class PrinterThread implements Runnable {
    private MySemaphore semaphore;

    public PrinterThread(MySemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // Attendre pour obtenir un permis (acquérir le sémaphore)
            semaphore.acquire();

            // Accès à la ressource partagée (l'imprimante)
            System.out.println(Thread.currentThread().getName() + " is printing...");
            Thread.sleep(2000); // Simule le temps de l'impression
            System.out.println(Thread.currentThread().getName() + " has finished printing.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Libérer le sémaphore (retourner le permis)
            semaphore.release();
        }
    }
}
