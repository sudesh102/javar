import java.io.*;
import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        String fileName = "student_data.dat"; 
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.println("Enter Student Roll No:");
            int rollNo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Student Class:");
            String studentClass = scanner.nextLine();

            System.out.println("Enter Student Age:");
            int age = scanner.nextInt();

            System.out.println("Enter Student Weight (in kg):");
            double weight = scanner.nextDouble();

            System.out.println("Enter Student Height (in cm):");
            double height = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.println("Enter Student City:");
            String city = scanner.nextLine();

            System.out.println("Enter Student Phone Number:");
            String phone = scanner.nextLine();

           
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                dos.writeInt(rollNo);
                dos.writeUTF(studentClass);
                dos.writeInt(age);
                dos.writeDouble(weight);
                dos.writeDouble(height);
                dos.writeUTF(city);
                dos.writeUTF(phone);
                System.out.println("Data saved successfully to file.");
            }
            System.out.println("\nRetrieving data from file...");
            try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
                int readRollNo = dis.readInt();
                String readClass = dis.readUTF();
                int readAge = dis.readInt();
                double readWeight = dis.readDouble();
                double readHeight = dis.readDouble();
                String readCity = dis.readUTF();
                String readPhone = dis.readUTF();

                
                System.out.println("\n--- Student Information ---");
                System.out.println("Roll No: " + readRollNo);
                System.out.println("Class: " + readClass);
                System.out.println("Age: " + readAge);
                System.out.println("Weight: " + readWeight + " kg");
                System.out.println("Height: " + readHeight + " cm");
                System.out.println("City: " + readCity);
                System.out.println("Phone: " + readPhone);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
