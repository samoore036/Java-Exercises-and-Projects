/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//find the longest common prefix
/**
 *
 * @author mooshahe
 */
public class main {
    public static void main(String[] args) {
        String[] texts = {"premed", "premadonna", "precursor", "prevent", "precise", "prepare"};
        int length = texts[0].length();
        String shortest = texts[0];
        for (int i = 0; i < texts.length; i++) {
            if (length > texts[i].length()) {
                length = texts[i].length();
                shortest = texts[i];
            }
        }
        System.out.println(shortest);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0, j = 0; i < texts.length && j < shortest.length(); i++, j++) {
            if (shortest.charAt(j) == texts[i].charAt(j)) {
                sb.append(shortest.charAt(j));
            } else {
                break;
            }
        }
        System.out.println(sb.toString());
    }
}
