/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author mooshahe
 */
//find the first non-repeated character from a given string and return it 
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.next();
        
        Map<Character,Integer> orderedMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (orderedMap.containsKey(input.charAt(i))) {
                int newCount = orderedMap.get(input.charAt(i)) + 1;
                orderedMap.put(input.charAt(i), newCount);
            }
            orderedMap.putIfAbsent(input.charAt(i),0);   
        }
        
        char firstUnique = 0;
        for (char c : orderedMap.keySet()) {
            if (orderedMap.get(c) == 0) {
                firstUnique = c;
                break;
            }
        }
        
        System.out.println(String.format("The first non-repeated character is: %s", firstUnique));         
    }
}
