import java.util.Scanner;

class TooLongAdditionException extends Exception {
    public TooLongAdditionException(String message) {
        super(message);
    }
}

class NegativeAnswerException extends Exception {
    public NegativeAnswerException(String message) {
        super(message);
    }
}

class TooLongMultiplicationException extends Exception {
    public TooLongMultiplicationException(String message) {
        super(message);
    }
}

class ArithmeticOperations {
    private int num1;
    private int num2;

    public ArithmeticOperations(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() throws TooLongAdditionException {
        int result = num1 + num2;
        if (result > 1000) {
            throw new TooLongAdditionException("Addition result exceeds 1000.");
        }
        return result;
    }

    public int subtract() throws NegativeAnswerException {
        int result = num1 - num2;
        if (result < 0) {
            throw new NegativeAnswerException("Subtraction result is negative.");
        }
        return result;
    }

    public int multiply() throws TooLongMultiplicationException {
        int result = num1 * num2;
        if (result > 5000) {
            throw new TooLongMultiplicationException("Multiplication result exceeds 5000.");
        }
        return result;
    }

    public double divide() {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) num1 / num2;
    }
}
public class ArithmeticOperationsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        ArithmeticOperations operations = new ArithmeticOperations(num1, num2);

        try {
            System.out.println("Addition Result: " + operations.add());
        } catch (TooLongAdditionException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
             System.out.println("Subtraction Result: " + operations.subtract());
        } catch (NegativeAnswerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println("Multiplication Result: " + operations.multiply());
        } catch (TooLongMultiplicationException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println("Division Result: " + operations.divide());
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
