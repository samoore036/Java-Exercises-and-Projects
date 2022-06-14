
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
public class RandomPhraseGeneratorWithVowelMatch {
    public static void main(String[] args) {
        String[] wordListOne = {"agnostic","opinionated","voice activated","haptically driven","extensible"};
        String[] wordListTwo = {"loosely coupled","event driven","IoT","service oriented","containerized","serverless","microservices","distribted ledger"};
        String[] wordListThree = {"framework","library","DSL","REST API","repository","pipeline","service mesh","perspective"};
        
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        
        Random randomGenerator = new Random();
        int rand1 = randomGenerator.nextInt(oneLength);
        int rand2 = randomGenerator.nextInt(twoLength);
        int rand3 = randomGenerator.nextInt(threeLength);
        String phrase = String.format("%s %s %s", wordListOne[rand1],wordListTwo[rand2],wordListThree[rand3]);
        if (phrase.matches("^[aeiou].*")) {
            System.out.println(String.format("What we need is an %s",phrase));
        } else {
            System.out.println(String.format("What we need is a %s",phrase));
        }
    }
}
