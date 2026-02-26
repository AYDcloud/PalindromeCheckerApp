import java.util.Scanner;
import java.util.Stack;

class PalindromeCheckerApp {

    public boolean checkPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("The string \"" + input + "\" " +
                (checker.checkPalindrome(input)
                        ? "is a palindrome."
                        : "is NOT a palindrome."));

        sc.close();
    }
}
