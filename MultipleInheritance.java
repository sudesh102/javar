import java.util.Scanner;

interface PersonalDetails {
    void setPersonalDetails(String name, int age);
    void displayPersonalDetails();
}

interface ProfessionalDetails {
    void setProfessionalDetails(String company, String role);
    void displayProfessionalDetails();
}

class Employee implements PersonalDetails, ProfessionalDetails {
    private String name;
    private int age;
    private String company;
    private String role;

    public void setPersonalDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPersonalDetails() {
        System.out.println("Personal Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void setProfessionalDetails(String company, String role) {
        this.company = company;
        this.role = role;
    }

    public void displayProfessionalDetails() {
        System.out.println("Professional Details:");
        System.out.println("Company: " + company);
        System.out.println("Role: " + role);
    }
}
public class MultipleInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        employee.setPersonalDetails(name, age);
        System.out.print("Enter your company: ");
        String company = scanner.nextLine();

        System.out.print("Enter your role: ");
        String role = scanner.nextLine();

        employee.setProfessionalDetails(company, role);
        System.out.println("\n Employee Details :");
        employee.displayPersonalDetails();
        employee.displayProfessionalDetails();
    }
}
