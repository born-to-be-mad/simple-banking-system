package banking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final List<String> MAIN_MENU = List.of(
        "1. Create an account",
        "2. Log into account",
        "0. Exit");

    private static final List<String> CARD_MENU = List.of(
        "1. Balance",
        "2. Log out",
        "0. Exit");

    private final static Map<String, Card> CARDS = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userChoice = 0;
        boolean exit = false;
        do {
            MAIN_MENU.forEach(System.out::println);
            userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice) {
            case 0:
                exit = true;
                System.out.println("Bye!");
                break;
            case 1: {
                System.out.println();
                Card card = createCard();
                CARDS.put(card.getId(), card);
                System.out.println("Your card has been created");
                System.out.println("Your card number:");
                System.out.println(card.getId());
                System.out.println("Your card PIN:");
                System.out.println(card.getPin());
                System.out.println();
                break;
            }
            case 2: {
                System.out.println("Enter your card number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter your PIN:");
                String pin = scanner.nextLine();
                if (!CARDS.containsKey(cardNumber)) {
                    System.out.println("Wrong card number or PIN!");
                    break;
                }
                Card card = CARDS.get(cardNumber);
                if (!card.getPin().equals(pin)) {
                    System.out.println("Wrong card number or PIN!");
                    break;
                }
                System.out.println("You have successfully logged in!");
                boolean loggedOut = false;
                do {
                    CARD_MENU.forEach(System.out::println);
                    userChoice = Integer.parseInt(scanner.nextLine());
                    switch (userChoice) {
                    case 1:
                        System.out.printf("Balance: %d%n", 0);
                        break;
                    case 2:
                        loggedOut = true;
                        System.out.println("You have successfully logged out!");
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Bye!");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + userChoice);
                    }
                } while (!loggedOut && !exit);
                break;
            }
            default:
                break;
            }
        } while (!exit);
    }

    private static Card createCard() {
        return new Card(4);
    }
}
