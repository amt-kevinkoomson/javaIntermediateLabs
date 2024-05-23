package WeekOne.Generics;

import java.util.List;

public class AverageCalculator {
    // Generic method to calculate the average of a list of numbers
    public static <T extends Number> double calculateAverage(List<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty or null");
        }
//        Choose a collection of data (e.g., list of objects).
//                Implement a custom comparator to sort the collection based on specific criteria.
//                Utilize the Stream API to filter, transform, and process elements within the sorted collection.

        double sum = numbers.stream().mapToDouble(Number::doubleValue).sum();
        return sum / numbers.size();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        List<Integer> intList = List.of(10, 20, 30, 40, 50);
        double intAverage = calculateAverage(intList);
        System.out.println("Average of integers: " + intAverage);

        List<Double> doubleList = List.of(10.5, 20.5, 30.5, 40.5, 50.5);
        double doubleAverage = calculateAverage(doubleList);
        System.out.println("Average of doubles: " + doubleAverage);
    }
}
