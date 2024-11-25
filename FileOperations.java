import java.io.*;
import java.util.Scanner;
public class FileOperations 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
	try 
	{
            System.out.print("Enter the file name (with extension): ");
            String fileName = scanner.nextLine();
            File file = new File(fileName);
            if (!file.exists()) 
	    {
                System.out.println("File does not exist. Creating a new file...");
                file.createNewFile();
            }
            int choice;
            do 
	    {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Write to file");
                System.out.println("2. Append to file");
                System.out.println("3. Read from file");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) 
		{
                    case 1:
                        writeFile(fileName, scanner);
                        break;
                    case 2:
                        appendFile(fileName, scanner);
                        break;
                    case 3:
                        readFile(fileName);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

        } 
	catch (IOException e) 
	{
            System.out.println("An error occurred: " + e.getMessage());
        } 
    }
    public static void writeFile(String fileName, Scanner scanner) 
    {
        try (FileWriter writer = new FileWriter(fileName)) 
	{
            System.out.print("Enter content to write to the file: ");
            String content = scanner.nextLine();
            writer.write(content);
            System.out.println("Content written to the file successfully.");
        } 
	catch (IOException e) 
	{
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
    public static void appendFile(String fileName, Scanner scanner) 
    {
        try (FileWriter writer = new FileWriter(fileName, true)) 
	{
            System.out.print("Enter content to append to the file: ");
            String content = scanner.nextLine();
            writer.write(content + System.lineSeparator());
            System.out.println("Content appended to the file successfully.");
        } 
	catch (IOException e) 
	{
            System.out.println("Error appending to the file: " + e.getMessage());
        }
    }
    public static void readFile(String fileName) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
	{
            String line;
            System.out.println("\nContents of the file:");
            while ((line = reader.readLine()) != null) 
	    {
                System.out.println(line);
            }
        } 
	catch (IOException e) 
  	{
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
}
