import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }
}

class RecursiveStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindrome(s, 0, s.length() - 1);
    }
    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }
}

public class PalindromeCheckerApp {

    private static void testStrategy(String name, PalindromeStrategy strategy, String input) {
        long start = System.nanoTime();
        boolean result = strategy.check(input);
        long end = System.nanoTime();
        System.out.println(name + " -> Result: " + result +
                " | Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        testStrategy("Stack Strategy", new StackStrategy(), input);
        testStrategy("Deque Strategy", new DequeStrategy(), input);
        testStrategy("Recursive Strategy", new RecursiveStrategy(), input);

        sc.close();
    }
}