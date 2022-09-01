import java.io.File;
import java.nio.file.*;
import java.util.*;
//find the biggest population increase compared to the previous year
public class Main {
    public static void main(String[] args) {
        String path = "src/dataset_91069.txt";
        File file = new File(path);
        List<String> pops = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                pops.add(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        List<Integer> years = new ArrayList<>();
        List<Long> populations = new ArrayList<>();
        for (String s : pops) {
            String[] split = s.split("\t");
            years.add(Integer.valueOf(split[0]));
            populations.add(Long.valueOf(split[1].replaceAll(",", "")));
        }
        long biggestDiff = populations.get(0) - populations.get(1);
        long diff = 0;
        int index = 1;
        for (int i = 1; i < populations.size() - 1; i++) {
            diff = populations.get(i) - populations.get(i + 1);
            if (diff < biggestDiff) {
                biggestDiff = diff;
                index = i;
            }
        }
        System.out.println(years.get(index+1));
    }
}
