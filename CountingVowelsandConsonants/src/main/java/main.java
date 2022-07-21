/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
//count the number of vowels and consonants. vowels: a,e,i,o,u
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or words");
        String input = scanner.nextLine();
        
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int vowelCount = 0;
        int consonantCount = 0;
        String newInput = input.replaceAll("\\s", "").toLowerCase();
        /*take out any spaces, \s is anything that is a space character and replace it with no space
          must assign the string to a new reference variable because strings are immutable 
          also make newInput all lower case so only need to iterate over lower case chars*/
        for (int i = 0; i < newInput.length(); i++) {
            if (vowels.contains(newInput.charAt(i))) {
                vowelCount++;
            } else if (newInput.charAt(i) >= 'a' && newInput.charAt(i) <= 'z') {
                consonantCount++;
            }

        }
        System.out.println(String.format("Vowel count: %s", vowelCount));
        System.out.println(String.format("Consonant count: %s", consonantCount));
        streamVersion(input, vowels);
    }
    
    public static void streamVersion(String s, ArrayList<Character> vowelList) {
        System.out.println("----Stream Version----");
        String trimmedString = s.replaceAll("\\s", "").toLowerCase();
        
        long vowelCount = s.chars()
                .filter(c -> vowelList.contains((char) c))
                .count();
        long consonantCount = s.chars()
                .filter(c -> !vowelList.contains((char) c))
                .filter(c -> c >= 'a' && c <= 'z')
                .count();
        System.out.println(String.format("Vowel count: %s", vowelCount));
        System.out.println(String.format("Consonant count: %s", consonantCount));
    }
    
}
