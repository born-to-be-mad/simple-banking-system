import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        Random random = new Random();
        random.setSeed(lower + upper);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += random.nextInt(upper - lower + 1) + lower;
        }
        System.out.println(sum);
    }
}
