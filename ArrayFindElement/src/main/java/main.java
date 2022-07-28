
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {4,5,1,3,7,4,1};
        System.out.println(containsInt(nums, 8));
        System.out.println(binaryContainsInt(nums, 7));
        System.out.println(streamContainsInt(nums, 54));
    }
    
    public static boolean containsInt(int[] array, int toFind) {
        for (int i : array) {
            if (i == toFind) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean binaryContainsInt(int[] array, int toFind) {
        //binarysearch only works if the array is sorted
        Arrays.sort(array);
        return Arrays.binarySearch(array, toFind) >= 0;
        //the method will return the corresponding index or a negative value
    }
    
    public static boolean streamContainsInt(int[] array, int toFind) {
        return Arrays.stream(array)
                .anyMatch(i -> i == toFind);
    }
    
    public static <T> boolean containsObject(T[] array, T toFind) {
        for (T obj : array) {
            if (obj.equals(toFind)) {
                return true;
            }
        }
        return false;
    }
    
    public static <T> boolean simpleContainsObject(T[] array, T toFind) {
        return Arrays.asList(array).contains(toFind);
    }
}
