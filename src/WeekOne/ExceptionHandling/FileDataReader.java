package WeekOne.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader {
    // Method to read data from a text file
    public static void readDataFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String file = "src/WeekOne/ExceptionHandling/test.txt";
        readDataFromFile(file);

        String fileName = "example.txt";
        readDataFromFile(fileName);
    }
}

