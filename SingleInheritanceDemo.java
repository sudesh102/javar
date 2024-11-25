import java.util.Scanner;
class Person 
{
    String name;
    String birthdate;
    double height;
    double weight;
    String address;
    Person(String name, String birthdate, double height, double weight, String address) 
    {
        this.name = name;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.address = address;
    }
    public double calculate() 
    {
        return weight / (height * height); 
    }
    public void displayPersonDetails() 
    {
        System.out.println("Name: " + name);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Height: " + height + " meters");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Address: " + address);
    }
}
class Student extends Person 
{
    String rollNo;
    double[] marks;
    Student(String name, String birthdate, double height, double weight, String address, String rollNo, double[] marks) 
    {
        super(name, birthdate, height, weight, address);
        this.rollNo = rollNo;
        this.marks = marks;
    }
    public double calculateAvg() 
    {
        double sum = 0;
        for (double mark : marks) 
        {
            sum += mark;
        }
        return sum / marks.length;
    }
    public void displayStudentDetails() 
    {
        displayPersonDetails();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Average Marks: " + calculateAvg());
    }
}
class Employee extends Person 
{
    String empId;
    double salary;
    Employee(String name, String birthdate, double height, double weight, String address, String empId, double salary) 
    {
        super(name, birthdate, height, weight, address); 
        this.empId = empId;
        this.salary = salary;
    }
    public double calculateTax() 
    {
        return salary * 0.1;
    }
    public void displayEmployeeDetails() 
    {
        displayPersonDetails();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + calculateTax());
    }
}
public class SingleInheritanceDemo 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Details:");
        System.out.print("Name: ");
        String studentName = sc.nextLine();
        System.out.print("Birthdate (yyyy-mm-dd): ");
        String studentBirthdate = sc.nextLine();
        System.out.print("Height (in meters): ");
        double studentHeight = sc.nextDouble();
        System.out.print("Weight (in kg): ");
        double studentWeight = sc.nextDouble();
        sc.nextLine();
        System.out.print("Address: ");
        String studentAddress = sc.nextLine();
        System.out.print("Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter the number of Subjects: ");
        int n = sc.nextInt();
        double[] marks = new double[n];
        System.out.println("Enter the marks:");
        for (int i = 0; i < n; i++) 
        {
            marks[i] = sc.nextDouble();
        }
        Student student = new Student(studentName, studentBirthdate, studentHeight, studentWeight, studentAddress, rollNo, marks);
        sc.nextLine(); 
        System.out.println("\nEnter Employee Details:");
        System.out.print("Name: ");
        String employeeName = sc.nextLine();
        System.out.print("Birthdate (yyyy-mm-dd): ");
        String employeeBirthdate = sc.nextLine();
        System.out.print("Height (in meters): ");
        double employeeHeight = sc.nextDouble();
        System.out.print("Weight (in kg): ");
        double employeeWeight = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Address: ");
        String employeeAddress = sc.nextLine();
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        Employee employee = new Employee(employeeName, employeeBirthdate, employeeHeight, employeeWeight, employeeAddress, empId, salary);
        System.out.println("\nStudent Details:");
        student.displayStudentDetails();
        System.out.println("\nEmployee Details:");
        employee.displayEmployeeDetails();
    }
}
