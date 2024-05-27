package WeekOne.Multithreading;

public class SharedCounter {
    private int counter = 0;
    private final Object lock = new Object();

    // Method to increment the counter
    public void increment() {
        synchronized (lock) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        }
    }

    // Method to get the current counter value
    public int getCounter() {
        return counter;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Creating multiple threads to increment the counter
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                sharedCounter.increment();
                try {
                    // Sleep to simulate some work
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Starting multiple threads
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display final counter value
        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }
}
