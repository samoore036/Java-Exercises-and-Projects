

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//mirror the ASCII characters contained in the txt files
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the file path:");
        String path = sc.nextLine();
        List<String> strings = new ArrayList<>();
        try {
            File animal = new File(path);
            Scanner fileReader = new Scanner(animal);
            while (fileReader.hasNext()) {
                strings.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        printMirror(strings);
    }

    public static void printMirror(List<String> strings) {
        if (strings.isEmpty()) {
            return;
        }
        int longest = longestString(strings);
        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            String original = mirroredString(s, longest);
            String mirror = reverseString(original, longest);
            sb.append(original + " | " + mirror);
            System.out.println(sb);
        }
    }

    public static String mirroredString(String s, int length) {
        return String.format("%1$-" + length + "s", s);
    }

    public static String reverseString(String s, int length) {
        StringBuilder reverse =  new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '<': c = '>';
                break;
                case '>': c = '<';
                break;
                case '[': c = ']';
                break;
                case ']': c = '[';
                break;
                case '{': c = '}';
                break;
                case '}': c = '{';
                break;
                case '(': c = ')';
                break;
                case ')': c = '(';
                break;
                case '\\': c = '/';
                break;
                case '/': c = '\\';
                break;
            }
            reverse.append(c);
        }
        reverse.reverse();
        return reverse.toString();
    }

    public static int longestString(List<String> strings) {
        int longest = strings.get(0).length();
        for (int i = 0; i < strings.size(); i++) {
            if (longest < strings.get(i).length()) {
                longest = strings.get(i).length();
            }
        }
        return longest;
    }
}
