import java.util.Scanner;

public class Main {

    // inspired by https://hyperskill.org/learn/daily/2157#solutions-547942
    public static boolean isVowel(char ch) {
        return "AaEeIiOoUu".indexOf(ch) != -1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}