/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
//convert a string representing a number into an int, long, float or double
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = "";
        while (true) {
            System.out.println("Enter numbers");
            number = scanner.nextLine();
            if (!isNumeric(number)) {
                System.out.println("Enter numbers only");
                continue;
            } else {
                break;
            }
        }
        System.out.println("Enter 1 to convert to int, 2 to convert to float, 3 to conver to double");
        String selection = scanner.nextLine();
        if (selection.equals("1")) {
            System.out.println(toInt(number));
        }
        if (selection.equals("2")) {
            System.out.println(toFloat(number));
        }
        if (selection.equals("3")) {
            System.out.println(toDouble(number));
        }
    }
    
    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Cannot be converted to integer");
        }
        return -99;
    }
    
    public static float toFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            System.out.println("Cannot be converted to float");
        }
        return -99;
    }
    
    public static double toDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.out.println("Cannot be converted to double");
        }
        return -99;
    }
}
