import java.util.Scanner;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Node head = null, tail = null;
        for (int i = 0; i < s.length(); i++) {
            Node newNode = new Node(s.charAt(i));
            if (head == null) head = tail = newNode;
            else { tail.next = newNode; tail = newNode; }
        }

        System.out.println("The string \"" + s + "\" " +
                (isPalindrome(head) ? "is a palindrome." : "is NOT a palindrome."));
        sc.close();
    }
}