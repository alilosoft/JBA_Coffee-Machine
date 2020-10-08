import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            int shifted = (i + 1) % arr.length;
            arr[shifted] = scanner.next();
        }
        System.out.println(String.join(" ", arr));
    }
}