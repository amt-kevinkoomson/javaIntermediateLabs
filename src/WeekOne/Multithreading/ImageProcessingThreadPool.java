package WeekOne.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ImageProcessingThreadPool {

    // Define the Image Processing Task
    // Exercise 1: Implement a Thread Pool for Image Processing
    // Simulate processing multiple images concurrently using a thread pool.
    // Utilize an ExecutorService and create separate tasks for processing each image.

    static class ImageProcessingTask implements Runnable {
        private final String image;
        public ImageProcessingTask(String image){
            this.image = image;
        }
        @Override
        public void run() {
            System.out.println("Processing image " + image + " by " + Thread.currentThread().getName() + " ...");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(image + " done processing.");
            } catch (InterruptedException e) {
                System.out.println("Processing for " + image + " interrupted");
            }
        }
    }

    public static void main(String[] args) {
        String[] images = {"image1", "image2", "image3", "image4", "image5"};
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(String image: images){
            ImageProcessingTask task = new ImageProcessingTask(image);
            service.submit(task);
        }
        service.shutdown();
        try {
            if(!service.awaitTermination(30, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Executor failed to shutdown, shutting down now");
            service.shutdownNow();
        }
    }
}
