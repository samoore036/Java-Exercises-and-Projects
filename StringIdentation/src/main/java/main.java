/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//apply identation to the given string
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("test");
        strings.add("string");

        //uniform indentation loop
        for (int i = 0; i < strings.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ").append(strings.get(i));
            System.out.println(sb.toString());
        }
        
        //cascading indentation loop
        for (int i = 0; i < strings.size(); i++) {
            printSpace(i);
            System.out.println(strings.get(i));
        }
    }
    
    public static void printSpace(int n) {
        if (n == 0) {
            System.out.print("");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(" ");
            }
        }
    }
}
