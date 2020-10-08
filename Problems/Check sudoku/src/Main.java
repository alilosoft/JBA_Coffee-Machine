import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nSquare = n * n;
        int[][] table = new int[nSquare][nSquare];
        for (int i = 0; i < nSquare; i++) {
            for (int j = 0; j < nSquare; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        boolean solved = checkRowsNCols(n, table) && checkSquares(n, table);
        System.out.println(solved ? "YES" : "NO");
    }

    private static boolean checkRowsNCols(int n, int[][] table) {
        int nSquare = n * n;
        int sum1ToNSquare = nSquare * (nSquare + 1) / 2;
        boolean solved = true;
        for (int i = 0; i < nSquare && solved; i++) {
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < nSquare; j++) {
                sumRow += table[i][j];
                sumColumn += table[j][i];
            }
            if (sumRow != sum1ToNSquare || sumColumn != sum1ToNSquare) {
                solved = false;
            }
        }
        return solved;
    }

    private static boolean checkSquares(int n, int[][] table) {
        int nSquare = n * n;
        boolean solved = true;
        int sum1ToNSquare = nSquare * (nSquare + 1) / 2;
        for (int l = 0; l < nSquare && solved; l += n) {
            for (int k = 0; k < nSquare && solved; k += n) {
                int sumSquare = 0;
                for (int i = l; i < l + n; i++) {
                    for (int j = k; j < k + n; j++) {
                        sumSquare += table[i][j];
                    }
                }
                if (sumSquare != sum1ToNSquare) {
                    solved = false;
                }
            }
        }
        return solved;
    }
}