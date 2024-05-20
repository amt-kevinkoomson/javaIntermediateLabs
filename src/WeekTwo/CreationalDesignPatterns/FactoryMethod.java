package WeekTwo.CreationalDesignPatterns;

// Shape interface
interface Shape {
    void draw();
}

// Concrete implementation of Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Concrete implementation of Square
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Factory class for creating Shape objects
class ShapeFactory {
    // Method to create Shape objects based on the provided type
    public Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + type);
        }
    }
}

// Main class to test the ShapeFactory
public class FactoryMethod {
    public static void main(String[] args) {
        // Create a ShapeFactory instance
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create Circle object using the ShapeFactory
        Shape circle = shapeFactory.createShape("circle");
        // Draw the Circle
        circle.draw();

        // Create Square object using the ShapeFactory
        Shape square = shapeFactory.createShape("square");
        // Draw the Square
        square.draw();
    }
}

