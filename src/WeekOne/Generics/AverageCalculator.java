package WeekOne.Generics;

import java.util.List;

public class AverageCalculator {
    // Generic method to calculate the average of a list of numbers
    public static <T extends Number> double calculateAverage(List<T> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty or null");
        }

        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
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
