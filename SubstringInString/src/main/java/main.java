/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//check if a string contains a substring
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = scanner.nextLine();
        System.out.println("Enter a substring to find in the string");
        String substring = scanner.nextLine();
        System.out.println(input.contains(substring));
    }
}
