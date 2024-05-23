package WeekOne.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

//Exercise 1:
//Create methods that throw both checked and unchecked exceptions.
//Implement try-catch blocks to handle these exceptions appropriately, demonstrating the difference in handling requirements.
public class CheckedAndUnchecked {
    public static void readFromFile(){
        try{
            FileReader reader = new FileReader("src/WeekOne/ExceptionHandling/test.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            try{
                String string = bufferedReader.readLine();
                System.out.println(string);
            } catch (IOException e){
                System.out.println("Error thrown: " + e.getMessage());
            }
            finally {
                reader.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error thrown: "+e.getMessage());
        }
    }
    // Method that throws a checked exception
    public static void methodWithCheckedException() throws Exception {
        throw new Exception("This is a checked exception");
    }

    // Method that throws an unchecked exception
    public static void methodWithUncheckedException() {
        throw new RuntimeException("This is an unchecked exception");
    }

    public static void main(String[] args) {
        readFromFile();

        // Handling checked exception
        try {
            methodWithCheckedException();
        } catch (Exception e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        // Handling unchecked exception
        // Exercise 2:
        //Simulate a scenario where you might need to handle multiple exceptions within nested code blocks.
        //Implement nested try-catch blocks to catch specific exceptions at different levels of your code.
        try {
            methodWithUncheckedException();
        } catch (RuntimeException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
        finally {
            System.out.println("This code is run regardless");
        }

        validateAge(ThreadLocalRandom.current().nextInt());

        // Demonstrating no mandatory handling for unchecked exception
//        methodWithUncheckedException();
    }

    public static class AgeLessThanZeroException extends Exception{
        public AgeLessThanZeroException(String message){
            super(message);
        }
        public AgeLessThanZeroException(){}
    }
    private static void validateAge(int age) {
        if(age < 0) {
            try{
                throw new AgeLessThanZeroException("Age cannot be negative");
            } catch (AgeLessThanZeroException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
