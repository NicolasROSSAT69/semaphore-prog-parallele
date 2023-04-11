package fr.rossatnicolas;

public class Main {

    public static void main(String[] args) {

        MySemaphore printerSemaphore = new MySemaphore(1); // Crée un sémaphore avec 1 permis

        // Crée et démarre 3 threads qui souhaitent utiliser l'imprimante
        for (int i = 0; i < 3; i++) {
            new Thread(new PrinterThread(printerSemaphore), "Thread-" + (i + 1)).start();
        }

    }
}