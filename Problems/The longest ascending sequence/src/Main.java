import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int currentSeq = 1;
        int maxSeq = 1;
        int currentElem = scanner.nextInt();
        for (int i = 1; i < size; i++) {
            int nextElem = scanner.nextInt();
            if (nextElem > currentElem) {
                currentSeq++;
            } else {
                currentSeq = 1;
            }
            if (currentSeq > maxSeq) {
                maxSeq = currentSeq;
            }
            currentElem = nextElem;
        }
        System.out.println(maxSeq);
    }
}