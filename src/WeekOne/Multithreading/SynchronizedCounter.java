package WeekOne.Multithreading;

public class SynchronizedCounter {
    private int count = 0;

    // Method to increment the counter (synchronized)
    public synchronized void increment() {
        count++;
    }

    // Method to decrement the counter (synchronized)
    public synchronized void decrement() {
        count--;
    }

    // Method to get the current value of the counter (synchronized)
    public synchronized int getCount() {
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of the synchronized counter
        SynchronizedCounter counter = new SynchronizedCounter();

        // Create and start two threads to increment and decrement the counter
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        // Wait for both threads to complete
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final count
        System.out.println("Final count: " + counter.getCount());
    }
}

