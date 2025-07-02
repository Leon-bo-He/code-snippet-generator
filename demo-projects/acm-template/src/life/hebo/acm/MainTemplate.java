package life.hebo.acm;

imoprt java.util.Scanner;

/**
 * ACM input template. (sum of integers)
 */

public class MainTemplate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read integers until EOF
        while (scanner.hasNextInt()) {

            // Read the number of integers
            int n = scanner.nextInt();

            // Read integers array
            int[] arr = new int[n];
            for (int i =0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Process the logic
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            // Output the sum
            System.out.println("Sum: " + sum);
        }

        // Close the scanner
        scanner.close();
    }
}