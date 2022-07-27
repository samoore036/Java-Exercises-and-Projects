/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//sort an array of strings by length
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter strings to be sorted by length");
        System.out.println("Enter x to stop");
        ArrayList<String> strings = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("x||X")) {
                break;
            }
            strings.add(input);
        }
        Collections.sort(strings, Comparator.comparingInt(String::length));//sorts in ascending order
        System.out.println(strings);
        Collections.sort(strings, Comparator.comparingInt(String::length).reversed());//sorts in descending order
        System.out.println(strings);
    }
}
