import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> input = IntStream.range(1, n)
                                       .mapToObj(value -> scanner.nextInt())
                                       .collect(Collectors.toList());
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

    }
}
