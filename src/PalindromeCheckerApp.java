import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("The string \"" + s + "\" " +
                (isPalindrome(s, 0, s.length() - 1) ? "is a palindrome." : "is NOT a palindrome."));
        sc.close();
    }
}