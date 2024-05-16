package WeekOne.ExceptionHandling;

public class RectangleAreaCalculator {
    // Method to calculate the area of a rectangle
    public static double calculateArea(double length, double width) {
        try {
            if (width == 0) {
                throw new ArithmeticException("Width cannot be zero.");
            }
            return length * width;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // Return a sentinel value to indicate error
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        double length = 5.0;
        double width1 = 2.0;
        double width2 = 0.0; // Causes division by zero error

        // Calculate area for valid width
        double area1 = calculateArea(length, width1);
        System.out.println("Area with width 2.0: " + area1);

        // Calculate area for zero width (causes error)
        double area2 = calculateArea(length, width2);
        if (area2 != -1) {
            System.out.println("Area with width 0.0: " + area2);
        } else {
            System.out.println("Error occurred. Unable to calculate area.");
        }
    }
}

