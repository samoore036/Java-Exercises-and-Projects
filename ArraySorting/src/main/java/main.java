/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//write different sorting algorithms for arrays
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(21);
        }
        
        System.out.println("Unsorted array: " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
        
        Package[] packages = new Package[20];
        for (int i = 0; i < packages.length; i++) {
            packages[i] = new Package(new Random().nextInt(100));
        }
        
        System.out.println("Unsorted array: " + Arrays.toString(packages));
        Arrays.sort(packages, (Package p1, Package p2) -> Integer.compare(p1.getWeight(), p2.getWeight()));
        //ascending order. descending order would be (p2.getWeight(), p1.getWeight()));
        System.out.println("Sorted array: " + Arrays.toString(packages));        
    }
}
