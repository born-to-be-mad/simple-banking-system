package banking;

import java.util.Arrays;
import java.util.Random;

/**
 * Card holder.
 *
 * @author dzmitry.marudau
 * @since 2020.4
 */
public class Card {
    private static final Random RANDOM = new Random();

    final int[] id = new int[16];
    final int[] pin = new int[4];

    public Card(int prefix) {
        id[0] = prefix;
        for (int j = 6, idLength = id.length; j < idLength; j++) {
            id[j] = RANDOM.nextInt(10);
        }
        for (int j = 0, idLength = pin.length; j < idLength; j++) {
            pin[j] = RANDOM.nextInt(10);
        }
    }

    public String getId() {
        return arrayToString(id);
    }

    public String getPin() {
        return arrayToString(pin);
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }

        Card card = (Card) o;

        if (!Arrays.equals(id, card.id)) {
            return false;
        }
        return Arrays.equals(pin, card.pin);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(id);
        result = 31 * result + Arrays.hashCode(pin);
        return result;
    }

    private String arrayToString(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf)
                     .reduce((a, b) -> a + "" + b)
                     .orElse("");
    }
}
