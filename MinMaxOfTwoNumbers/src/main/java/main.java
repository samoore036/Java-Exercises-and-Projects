/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//find the min and max of numbers
import java.util.*;
import java.util.function.BinaryOperator;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        
        int one = random();
        int two = random();
        
        int max = BinaryOperator.maxBy(Integer::compare).apply(one, two);
        int min = BinaryOperator.minBy(Integer::compare).apply(one, two);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);  
    }
    
    public static int random() {
        return new Random().nextInt(101);
    }
}
