/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//remove the given character from the given string
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
        System.out.println("Enter the character you want to remove");
        String removeThis = scanner.nextLine();
        String newInput = input.replaceAll(removeThis, "");
        System.out.println(newInput);
    }
}
