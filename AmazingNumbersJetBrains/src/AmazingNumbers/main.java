package AmazingNumbers;
import java.text.NumberFormat;
import java.util.*;
public class main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("");
        System.out.println(String.format("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n"));
        while (true) {
            System.out.print("Enter a request: ");
            String request = sc.nextLine().toUpperCase();
            System.out.println("");
            if (request.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }
            evaluateRequest(request);
        }
    }

    public static void evaluateRequest(String s) {
        String[] split = s.split(" ");
        List<String> request = new ArrayList<>();
        request = Arrays.asList(split);
        if (request.size() == 1) {
            try {
                oneDigit(Long.valueOf(request.get(0)));
            } catch (RuntimeException e) {
                System.out.println("The first parameter should be a natural number or zero.\n");
            }
        }
        if (request.size() == 2) {
            try {
                if (checkParameters(request)) {
                    multipleDigits(Long.valueOf(request.get(0)), Integer.valueOf(request.get(1)));
                }
            } catch (RuntimeException e) {
                printParameterInfo(request);
            }
        }
        if (request.size() == 3) {
            if (checkParameters(request)) {
                if (correctKeywords(request)) {
                    processRequest(request);
                } else {
                    printIncorrectKeyword(request);
                }
            }
        }
        if (request.size() >= 4) {
            if (checkParameters(request)) {
                if (correctKeywords(request)) {
                    if (!isMutuallyExclusive(request)) {
                        processRequest(request);
                    } else {
                        printMutuallyExclusive(request);
                    }
                } else {
                    printIncorrectKeyword(request);
                }
            }
        }
    }

    public static boolean correctKeywords(List<String> request) {
        for (int i = 2; i < request.size(); i++) {
            String keyword = request.get(i).toUpperCase().trim().replaceAll("-", "");
            if (!keyword.matches("BUZZ|DUCK|PALINDROMIC|GAPFUL|SPY|SQUARE|SUNNY|JUMPING|EVEN|ODD|HAPPY|SAD")) {
                return false;
            }
        }
        return true;
    }

    public static void printIncorrectKeyword(List<String> request) {
        StringBuilder finished = new StringBuilder();
        int wrongCount = 0;
        for (int i = 2; i < request.size(); i++) {
            String check = request.get(i).toUpperCase().trim();
            if (!check.matches("BUZZ|-BUZZ|DUCK|-DUCK|PALINDROMIC|-PALINDROMIC|GAPFUL|-GAPFUL|SPY|-SPY|SQUARE|-SQUARE|SUNNY|-SUNNY|JUMPING|-JUMPING|EVEN|-EVEN|ODD|-ODD|HAPPY|-HAPPY|SAD|-SAD")) {
                wrongCount++;
                if (i != request.size() - 1) {
                    finished.append(check + ", ");
                } else {
                    finished.append(check + " ");
                }
            }
        }

        StringBuilder beginning = new StringBuilder();
        if (wrongCount > 1) {
            beginning.append("The properties ");
            finished.append("are ");
        } else {
            beginning.append("The property ");
            finished.append("is ");
        }
        beginning.append(finished);
        beginning.append("wrong.\nAvailable properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, EVEN, ODD, HAPPY, SAD]\n");
        System.out.println(beginning.toString());
        return;
    }
    public static boolean checkParameters(List<String> request) {
        if (!request.get(0).matches("\\d+") || Long.valueOf(request.get(0)) < 0 || !request.get(1).matches("\\d+") || Integer.valueOf(request.get(1)) <= 0) {
            printParameterInfo(request);
            return false;
        }
        return true;
    }
    public static void printParameterInfo(List<String> request) {
        if (Long.parseLong(request.get(0)) < 0) {
            System.out.println("The first parameter should be a natural number or zero.\n");
        } else if (!request.get(1).matches("\\d+") || Integer.valueOf(request.get(1)) <= 0){
            System.out.println("The second parameter should be a natural number.\n");
        } else {
            System.out.println("The first parameter should be a natural number or zero.\n");
        }
    }

    public static boolean isMutuallyExclusive(List<String> request) {
        if (request.contains("EVEN") && request.contains("ODD")) {
            return true;
        }
        if (request.contains("ODD") && request.contains("-ODD")) {
            return true;
        }
        if (request.contains("EVEN") && request.contains("-EVEN")) {
            return true;
        }
        if (request.contains("-ODD") && request.contains("-EVEN")) {
            return true;
        }
        if (request.contains("DUCK") && request.contains("SPY")) {
            return true;
        }
        if (request.contains("DUCK") && request.contains("-DUCK")) {
            return true;
        }
        if (request.contains("SPY") && request.contains("-SPY")) {
            return true;
        }
        if (request.contains("-DUCK") && request.contains("-SPY")) {
            return true;
        }
        if (request.contains("SQUARE") && request.contains("SUNNY")) {
            return true;
        }
        if (request.contains("SQUARE") && request.contains("-SQUARE")) {
            return true;
        }
        if (request.contains("SUNNY") && request.contains("-SUNNY")) {
            return true;
        }
        if (request.contains("SAD") && request.contains("HAPPY")) {
            return true;
        }
        if (request.contains("SAD") && request.contains("-SAD")) {
            return true;
        }
        if (request.contains("HAPPY") && request.contains("-HAPPY")) {
            return true;
        }
        if (request.contains("-HAPPY") && request.contains("-SAD")) {
            return true;
        }
        return false;
    }
    public static void printMutuallyExclusive(List<String> request) {
        if (request.contains("EVEN") && request.contains("ODD")) {
            System.out.println(mutuallyExclusiveError("EVEN", "ODD"));
        }
        if (request.contains("ODD") && request.contains("-ODD")) {
            System.out.println(mutuallyExclusiveError("ODD", "-ODD"));
        }
        if (request.contains("EVEN") && request.contains("-EVEN")) {
            System.out.println(mutuallyExclusiveError("EVEN", "-EVEN"));
        }
        if (request.contains("-ODD") && request.contains("-EVEN")) {
            System.out.println(mutuallyExclusiveError("-ODD", "-EVEN"));
        }
        if (request.contains("DUCK") && request.contains("SPY")) {
            System.out.println(mutuallyExclusiveError("DUCK", "SPY"));
        }
        if (request.contains("DUCK") && request.contains("-DUCK")) {
            System.out.println(mutuallyExclusiveError("DUCK", "-DUCK"));
        }
        if (request.contains("SPY") && request.contains("-SPY")) {
            System.out.println(mutuallyExclusiveError("SPY", "-SPY"));
        }
        if (request.contains("-DUCK") && request.contains("-SPY")) {
            System.out.println(mutuallyExclusiveError("-DUCK", "-SPY"));
        }
        if (request.contains("SQUARE") && request.contains("SUNNY")) {
            System.out.println(mutuallyExclusiveError("SQUARE", "SUNNY"));
        }
        if (request.contains("SQUARE") && request.contains("-SQUARE")) {
            System.out.println(mutuallyExclusiveError("SQUARE", "-SQUARE"));
        }
        if (request.contains("SUNNY") && request.contains("-SUNNY")) {
            System.out.println(mutuallyExclusiveError("SUNNY", "-SUNNY"));
        }
        if (request.contains("SAD") && request.contains("HAPPY")) {
            System.out.println(mutuallyExclusiveError("SAD", "HAPPY"));
        }
        if (request.contains("SAD") && request.contains("-SAD")) {
            System.out.println(mutuallyExclusiveError("SAD", "-SAD"));
        }
        if (request.contains("HAPPY") && request.contains("-HAPPY")) {
            System.out.println(mutuallyExclusiveError("HAPPY", "-HAPPY"));
        }
        if (request.contains("-HAPPY") && request.contains("-SAD")) {
            System.out.println(mutuallyExclusiveError("-HAPPY", "-SAD"));
        }
    }
    public static String mutuallyExclusiveError(String s1, String s2) {
        return String.format("The request contains mutually exclusive properties: [%s, %s]\nThere are no numbers with these properties.\n", s1, s2);
    }
    public static void oneDigit(long num) {
        if (num < 0) {
            System.out.println("");
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println("");
            return;
        }
        printSingleResults(num);
    }
    public static void multipleDigits(long num, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(evaluateNum(num + i));
        }
        System.out.println("");
    }
    public static void processRequest(List<String> request) {
        long num = Long.valueOf(request.get(0));
        int count = Integer.valueOf(request.get(1));
        int requestCount = 0;
        if (request.size() == 3) {
            while (requestCount < count) {
                if (request.get(2).contains("-")) {
                    String excluded = request.get(2).replaceAll("-", "").toLowerCase();
                    if (!evaluateNum(num).contains(excluded)) {
                        System.out.print(evaluateNum(num));
                        requestCount++;
                    }
                } else if (evaluateNum(num).contains(request.get(2).toLowerCase().trim())) {
                    System.out.print(evaluateNum(num));
                    requestCount++;
                }
                num++;
            }
            System.out.println("");
        }
        if (request.size() >= 4) {
            List<String> keywords = new ArrayList<>();
            List<String> excludedKeywords = new ArrayList<>();
            for (int i = 2; i < request.size(); i++) {
                if (request.get(i).contains("-")) {
                    excludedKeywords.add(request.get(i).toLowerCase().replaceAll("-", "").trim());
                } else {
                    keywords.add(request.get(i).toLowerCase());
                }
            }
            while (requestCount < count) {
                if (containsAllKeywords(num, keywords) && !containsExcludedWords(num, excludedKeywords)) {
                    System.out.print(evaluateNum(num));
                    requestCount++;
                }
                num++;
            }
        }
        System.out.println("");
    }

    public static boolean containsAllKeywords(long num, List<String> keywords) {
        for (String s : keywords) {
            if (!evaluateNum(num).contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsExcludedWords(long num, List<String> excludedKeywords) {
        for (String s : excludedKeywords) {
            String check = s.toLowerCase().trim().replaceAll("-", "");
            if (evaluateNum(num).contains(check)) {
                return true;
            }
        }
        return false;
    }
    public static void printSingleResults(long num) {
        System.out.println(String.format("Properties of %,d", num));
        System.out.println("\t\tbuzz: " + isBuzz(num));
        System.out.println("\t\tduck: " + isDuck(num));
        System.out.println(" palindromic: " + isPalindrome(num));
        System.out.println("      gapful: " + isGapful(num));
        System.out.println("         spy: " + isSpy(num));
        System.out.println("      square: " + isSquare(num));
        System.out.println("       sunny: " + isSunny(num));
        System.out.println("     jumping: " + isJumping(num));
        System.out.println("\t\teven: " + isEven(num));
        System.out.println("\t\t odd: " + !isEven(num));
        System.out.println("\t\thappy: " + isHappy(num));
        System.out.println("\t\tsad: " + !isHappy(num));
        System.out.println("");
    }
    public static String evaluateNum(long num) {
        StringBuilder sb = new StringBuilder();
        if (isEven(num)) {
            sb.append("even, ");
        } else {
            sb.append("odd, ");
        }
        if (isBuzz(num)) {
            sb.append("buzz, ");
        }
        if (isDuck(num)) {
            sb.append("duck, ");
        }
        if (isPalindrome(num)) {
            sb.append("palindromic, ");
        }
        if (isGapful(num)) {
            sb.append("gapful, ");
        }
        if (isSpy(num)) {
            sb.append("spy, ");
        }
        if (isSquare(num)) {
            sb.append("square, ");
        }
        if (isSunny(num)) {
            sb.append("sunny, ");
        }
        if (isJumping(num)) {
            sb.append("jumping, ");
        }
        if (isHappy(num)) {
            sb.append("happy");
        } else {
            sb.append("sad");
        }
        return String.format("\t\t\t%,d is %s\n", num, sb.toString());
    }
    public static boolean isHappy(long num) {
        if (num == 1) {
            return true;
        }
        if (num == 4) {
            return false;
        }
        return isHappy(sumOfDigits(num));
    }
    public static int sumOfDigits(long num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num%10, 2);
            num = num/10;
        }
        return sum;
    }
    public static boolean isJumping(long num) {
        if (num < 10) {
            return true;
        }
        String number = String.valueOf(num);
        for (int i = 0; i < number.length() - 1; i++) {
            if (Integer.valueOf(number.charAt(i) - 1) != number.charAt(i + 1) && Integer.valueOf(number.charAt(i) + 1) != number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSquare(long num) {
        double sqrt = Math.sqrt(num);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
    public static boolean isSunny(long num) {
        return isSquare(num + 1);
    }
    public static boolean isSpy(long num) {
        String[] nums = String.valueOf(num).split("");
        int sum = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.valueOf(nums[i]);
            product *= Integer.valueOf(nums[i]);
        }
        if (sum == product) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isGapful(long num) {
        if (num < 100) {
            return false;
        }
        String[] split = String.valueOf(num).split("");
        String div = split[0] + split[split.length - 1];
        if (num % Integer.valueOf(div) == 0) {
            return true;
        }
        return false;
    }
    public static boolean isPalindrome(long num) {
        if (num < 10) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(num)).reverse();
        if (sb.toString().equals(String.valueOf(num))) {
            return true;
        }
        return false;
    }
    public static boolean isEven(long num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isDuck(long num) {
        if (num < 10) {
            return false;
        }
        String number = String.valueOf(num);
        if (number.substring(1).contains("0")) {
            return true;
        }
        return false;
    }
    public static boolean isBuzz(long num) {
        if (div7(num) || lastIs7(num)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean div7(long num) {
        if (num % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean lastIs7(long num) {
        String[] nums = String.valueOf(num).split("");
        long lastN = Long.valueOf(nums[nums.length - 1]);
        if (lastN == 7) {
            return true;
        } else {
            return false;
        }
    }
}

