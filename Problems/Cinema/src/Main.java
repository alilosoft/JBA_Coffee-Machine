import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] seats = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int foundRow = 0;
        for (int i = 0; i < n; i++) {
            int availableCount = 0;
            for (int j = 0; j < m & availableCount < k; j++) {
                if (seats[i][j] == 0) {
                    availableCount++;
                } else {
                    availableCount = 0;
                }
            }
            if (availableCount == k) {
                foundRow = i + 1;
                break;
            }
        }
        System.out.println(foundRow);
    }
}
// check this:  https://hyperskill.org/learn/daily/1930#solutions-574214