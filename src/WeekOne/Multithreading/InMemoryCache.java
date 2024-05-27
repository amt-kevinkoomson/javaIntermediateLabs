package WeekOne.Multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InMemoryCache<K, V> {
    private final ConcurrentHashMap<K, V> cache;

    public InMemoryCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public synchronized void put(K key, V value) {
        System.out.println(" putting " + key + "by thread " + Thread.currentThread().getName() + " ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public synchronized V remove(K key) {
        System.out.println(" removing " + key + " by thread " + Thread.currentThread().getName() + " ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cache.remove(key);
    }

    public int size() {
        return cache.size();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        InMemoryCache<String, String> cache = new InMemoryCache<>();
        ExecutorService service = Executors.newCachedThreadPool();
        String[][] array = {
                {"key1", "value1"},
                {"key2", "value2"},
                {"key3", "value3"},
                {"key4", "value4"},
                {"key5", "value5"},
        };
        for(String[] item : array) {
            service.submit(() -> cache.put(item[0], item[1]));
        }



//        // Retrieving items from the cache
//        System.out.println("key1: " + cache.get("key1")); // Output: key1: value1
//        System.out.println("key2: " + cache.get("key2")); // Output: key2: value2
//
//        // Removing an item from the cache
//        System.out.println("Removed key1: " + cache.remove("key1")); // Output: Removed key1: value1

        // Getting the size of the cache
        System.out.println("Cache size: " + cache.size()); // Output: Cache size: 1
    }
}
