package WeekOne.Algorithms.Fibonacci;

public class Fibonacci {
    private int number;
    public Fibonacci(int number){
        this.number = number;
    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(5);
        System.out.println(fibonacci.calculateFibonacci());
    }
    public int calculateFibonacci() {
        if(number <= 1) return number;
        return (number-1) + (number-2);
    }
}
