import java.util.Scanner;

// https://hyperskill.org/learn/step/1931#solutions-583663
// also check this: https://rosettacode.org/wiki/Spiral_matrix#Java
// and this: https://www.educative.io/edpresso/spiral-matrix-algorithm
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] spiral = new int[n][n];
        int i = 0;
        int j = 0;
        int layer = 0;
        int fill = 0;
        while (fill < n * n) {
            while (j < n - layer) {
                spiral[i][j] = ++fill;
                j++;
            }
            i++;
            j--; // redo last increment
            while (i < n - layer) {
                spiral[i][j] = ++fill;
                i++;
            }
            i--;
            j--;
            while (j >= layer) {
                spiral[i][j] = ++fill;
                j--;
            }
            i--;
            j++;
            while (i > layer) {
                spiral[i][j] = ++fill;
                i--;
            }
            i++;
            j++;
            layer++;
        }
        // output
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(spiral[k][l] + "\t");
            }
            System.out.println();
        }
    }
}