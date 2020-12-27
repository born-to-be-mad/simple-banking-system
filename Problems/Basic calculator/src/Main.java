class Problem {
    public static void main(String[] args) {
        try {
            String operation = args[0];
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);

            switch (operation) {
            case "+": {
                System.out.println(a + b);
                break;
            }
            case "-": {
                System.out.println(a - b);
                break;
            }
            case "*": {
                System.out.println(a * b);
                break;
            }
            default:
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("Unknown operator");
        }
    }
}
