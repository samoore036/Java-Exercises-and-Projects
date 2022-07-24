/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//join multiple strings with a delimiter
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        String a = "this is a";
        String b = "this is b";
        String c = "this is c";
        String[] strings = {a,b,c};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length-1) {
                sb.append(strings[i]);
                break;
            }
            sb.append(strings[i]).append(", ");
        }
        System.out.println(sb);
    }
}
