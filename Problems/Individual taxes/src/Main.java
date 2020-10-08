import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nbr = scanner.nextInt();
        int[] income = new int[nbr];
        for (int i = 0; i < nbr; i++) {
            income[i] = scanner.nextInt();
        }
        double maxTax = 0;
        int company = 0;
        for (int i = 0; i < nbr; i++) {
            double tax = income[i]  * scanner.nextDouble() / 100;
            if (tax > maxTax) {
                maxTax = tax;
                company = i + 1;
            }
        }
        System.out.println(company);
    }
}