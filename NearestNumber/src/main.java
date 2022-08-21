import java.util.*;
import java.util.stream.Collectors;
/*
find the nearest number or numbers to the target number
print the found numbers in ascending order
 */
public class main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int target = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<>();
        int distance = 0;
        while (result.isEmpty()) {
            for (int i : numbers) {
                if (i + distance == target || i - distance == target) {
                    result.add(i);
                }
            }
            distance++;
        }
        result.stream().sorted().forEach(i -> System.out.print(i + " "));
    }
}
