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
        String s = "abc";
        int n = 4;
        System.out.println(solution1(s, n));
        System.out.println(solution2(s, n));
    }
    
    public static String solution1(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < n; i++) {
            sb.append(" " + s);
        }
        return sb.toString();
    }
    
    public static String solution2(String s, int n) {
        String sNew = s + " ";
        return sNew.repeat(n);
    }
}
