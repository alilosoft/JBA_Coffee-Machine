import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int n;
        while ((n = scanner.nextInt()) != 0 && sum < 1000) {
            sum += n;
        }
        System.out.println(sum < 1000 ? sum : sum - 1000);
    }
}