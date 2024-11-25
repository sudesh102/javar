import java.util.Scanner;
class Arithmetic 
{
    public double add(double a, double b) 
    {
        return a + b;
    }

    public double subtract(double a, double b) 
    {
        return a - b;
    }

    public double multiply(double a, double b) 
    {
        return a * b;
    }

    public double divide(double a, double b) 
    {
        if (b == 0) 
        {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
class Statistics 
{
    public double mean(double[] numbers) 
    {
        double sum = 0;
        for (double num : numbers) 
	{
            sum += num;
        }
        return sum / numbers.length;
    }

    public double variance(double[] numbers) 
    {
        double mean = mean(numbers);
        double sumSquaredDiffs = 0;
        for (double num : numbers) 
        {
            sumSquaredDiffs += Math.pow(num - mean, 2);
        }
        return sumSquaredDiffs / numbers.length;
    }

    public double standardDeviation(double[] numbers) 
    {
        return Math.sqrt(variance(numbers));
    }
}
class Trigonometry 
{
    public double sine(double angleInDegrees) 
    {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return Math.sin(angleInRadians);
    }

    public double cosine(double angleInDegrees) 
    {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return Math.cos(angleInRadians);
    }

    public double tangent(double angleInDegrees) 
    {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return Math.tan(angleInRadians);
    }
}
public class MathematicalPackage 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Arithmetic arithmetic = new Arithmetic();
        System.out.println("Arithmetic Operations:");
        System.out.print("Enter two numbers for arithmetic operations: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Addition: " + arithmetic.add(num1, num2));
        System.out.println("Subtraction: " + arithmetic.subtract(num1, num2));
        System.out.println("Multiplication: " + arithmetic.multiply(num1, num2));
        try 
        {
            System.out.println("Division: " + arithmetic.divide(num1, num2));
        } 
        catch (ArithmeticException e) 
        {
            System.out.println(e.getMessage());
        }
        Statistics statistics = new Statistics();
        System.out.println("\nStatistical Operations:");
        System.out.print("Enter the number of elements for statistical operations: ");
        int n = sc.nextInt();
        double[] numbers = new double[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = sc.nextDouble();
        }
        System.out.println("Mean: " + statistics.mean(numbers));
        System.out.println("Variance: " + statistics.variance(numbers));
        System.out.println("Standard Deviation: " + statistics.standardDeviation(numbers));
        Trigonometry trigonometry = new Trigonometry();
        System.out.println("\nTrigonometric Operations:");
        System.out.print("Enter an angle in degrees: ");
        double angle = sc.nextDouble();
        System.out.println("Sine: " + trigonometry.sine(angle));
        System.out.println("Cosine: " + trigonometry.cosine(angle));
        System.out.println("Tangent: " + trigonometry.tangent(angle));
    }
}
