import java.util.*;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                                    "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                                    "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!(Character.isLetter(ch))) continue;

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Collection<Integer> values = map.values();

        int maxQuantity = getMax(values);
        int minQuantity = getMin(values);

        List<Character> maxLetter = new ArrayList<>();
        List<Character> minLetter = new ArrayList<>();

        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if(kv.getValue() == maxQuantity) {
                maxLetter.add(kv.getKey());
            }

            if(kv.getValue() == minQuantity) {
                minLetter.add(kv.getKey());
            }
        }
        System.out.println("Чаще всего встречалась буква " + maxLetter + " - " + maxQuantity + " раз(а).");
        System.out.println("Реже всего встречалась буква " + minLetter + " - " + minQuantity + " раз(а).");
    }

    public static int getMax(Collection<Integer> values) {
        int max = -1;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int getMin(Collection<Integer> values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
