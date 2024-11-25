import java.util.Scanner;

public class MatrixOperations 
{
    static void setMatrix(int[][] m, int row, int col) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements in matrix:");
        for (int i = 0; i < row; i++) 
	{
            	for (int j = 0; j < col; j++) 
		{
                	m[i][j] = sc.nextInt();
            	}
        }
        System.out.println("Matrix:");
        for (int i = 0; i < row; i++) 
	{
            	for (int j = 0; j < col; j++) 
		{
                	System.out.print(m[i][j] + " ");
            	}
            System.out.println();
        }
    }
    static void display(int[][] result, int row, int col) 
    {
        System.out.println("Result:");
        for (int i = 0; i < row; i++) 
	{
            	for (int j = 0; j < col; j++) 
		{
               	 	System.out.print(result[i][j] + " ");
            	}
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        int row, col, temp = 1, ch;
        Scanner sc = new Scanner(System.in);
        int[][] m1, m2;
        MatrixTest mt = new MatrixTest();
        System.out.println("Enter size of row and column:");
        row = sc.nextInt();
        col = sc.nextInt();
        m1 = new int[row][col];
        m2 = new int[row][col];
        System.out.println("Enter elements for Matrix 1:");
        setMatrix(m1, row, col);
        System.out.println("Enter elements for Matrix 2:");
        setMatrix(m2, row, col);
        int[][] result = new int[row][col];

        while (temp != 0) 
	{
            System.out.println("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
            System.out.println("Enter choice:");
            ch = sc.nextInt();
            switch (ch) 
		{
                case 1:
                    result = mt.addition(m1, m2, row, col);
                    System.out.println("Addition result:");
                    display(result, row, col);
                    break;
                case 2:
                    result = mt.subtraction(m1, m2, row, col);
                    System.out.println("Subtraction result:");
                    display(result, row, col);
                    break;
                case 3:
                    result = mt.multiplication(m1, m2, row, col);
                    System.out.println("Multiplication result:");
                    display(result, row, col);
                    break;
                case 4:
                    result = mt.division(m1, m2, row, col);
                    System.out.println("Division result:");
                    display(result, row, col);
                    break;
                case 5:
                    temp = 0;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Enter a valid choice...");
                    break;
            }
        }
        sc.close();
    }
}

class MatrixTest {
    int[][] addition(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m3;
    }

    int[][] subtraction(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return m3;
    }

    int[][] multiplication(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] * m2[i][j];
            }
        }
        return m3;
    }

    int[][] division(int[][] m1, int[][] m2, int row, int col) {
        int[][] m3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m2[i][j] != 0) {
                    m3[i][j] = m1[i][j] / m2[i][j];
                } else {
                    System.out.println("Error: Division by zero at position (" + i + ", " + j + ")");
                    m3[i][j] = 0;
                }
            }
        }
        return m3;
    }
}
