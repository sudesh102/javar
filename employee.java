import java.util.Scanner;

class employee {
    String name;
    String empid;
    float salary;
    public employee() {
        name = "Sanika";
        empid = "22UCS088";
        salary = 60000;
    }

    public employee(String n, String eid, float s) {
        name = n;
        empid = eid;
        salary = s;
    }

        public String getName() {
        return name;
    }

       public String getEmpId() {
        return empid;
    }

   
    public float getSalary() {
        return salary;
    }


    public float incrementSalary() {
        salary = salary * 1.1f; // Increment by 10%
        return salary;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        employee e = new employee();
        System.out.println("Default Constructor");
        System.out.println("\nInitial Employee Information:");
        System.out.println("Employee Id: " + e.getEmpId());
        System.out.println("Employee Name: " + e.getName());
        System.out.println("Employee Salary: " + e.getSalary());

        
        System.out.println("\nEnter the name of an employee:");
        String n = sc.nextLine();

        System.out.println("Enter the ID of an employee:");
        String eid = sc.nextLine();

        System.out.println("Enter the salary of an employee:");
        float s = sc.nextFloat();

                employee q = new employee(n, eid, s);
        System.out.println("\nParameterized Constructor");
        System.out.println("\nNew Employee Information:");
        System.out.println("Employee Id: " + q.getEmpId());
        System.out.println("Employee Name: " + q.getName());
        System.out.println("Employee Salary: " + q.getSalary());

        System.out.println("\nAfter incrementing salary by 10%:");
        float updatedSalary = q.incrementSalary();
        System.out.println("Updated Salary: " + updatedSalary);
    }
}
