/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calc_test;
import java.util.Scanner;

/**
 *
 * @author serii
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1. Addition ");
        System.out.println("2. Subtraction ");
        System.out.println("3. Multiplication ");
        System.out.println("4. Division ");
        System.out.println("Enter operation: ");
 
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        
        System.out.println("Enter first number");
        int x = scanner.nextInt();
        System.out.println("Enter second number");
        int y = scanner.nextInt();
        
        int res = 0;
        
        if (operation == 1)
            res = x + y;
        else if (operation == 2)
            res = x - y;
        else if (operation == 3)
            res = x * y;
        else if (operation == 4)
            res = x / y;
        System.out.println("result = " + res);
        System.out.println("TuranovSV");
    }  
}
