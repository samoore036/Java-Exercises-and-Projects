/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
      
        Map<Character,Integer> duplicatesMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (duplicatesMap.containsKey(input.charAt(i))) {
                int duplicateCount = duplicatesMap.get(input.charAt(i)) + 1;
                duplicatesMap.put(input.charAt(i), duplicateCount);
            }
            duplicatesMap.putIfAbsent(input.charAt(i), 0);
        }
        System.out.println(duplicatesMap.toString());
        int duplicateCount = 0;
        for (int count : duplicatesMap.values()) {
            if (count > 0) {
                duplicateCount++;
            }
        } 
        System.out.println(String.format("Duplicates: %s", duplicateCount));
        
        //stream version:
        ArrayList<Character> duplicatesList = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            duplicatesList.add(ch);
        }
        
        long distinctChars = duplicatesList.stream()
                .distinct()
                .count();
        System.out.println(String.format("Length: %s", duplicatesList.size()));
        System.out.println(String.format("Unique chars: %s", distinctChars));
        int duplicatesTotal = duplicatesList.size() - (int) distinctChars;
        System.out.println(String.format("Stream duplicates: %s", duplicatesTotal));
    }
}
