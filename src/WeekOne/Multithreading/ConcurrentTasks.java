package WeekOne.Multithreading;

public class ConcurrentTasks {
    public static void main(String[] args) {
        // Create and start the threads
        Thread downloadThread = new Thread(new DownloadTask());
        Thread processThread = new Thread(new ProcessDataTask());

        downloadThread.start();
        processThread.start();

        // Main thread continues execution while download and process threads run concurrently
        System.out.println("Main thread continues execution...");

        // Wait for both threads to complete
        try {
            downloadThread.join();
            processThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // All threads have finished executing
        System.out.println("All tasks completed.");
    }
}

// Task to simulate downloading a file
class DownloadTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading file...");
        // Simulate download process
        try {
            Thread.sleep(3000); // Simulate 3 seconds of download time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File downloaded.");
    }
}

// Task to simulate processing data
class ProcessDataTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing data...");
        // Simulate data processing
        try {
            Thread.sleep(2000); // Simulate 2 seconds of processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data processed.");
    }
}

