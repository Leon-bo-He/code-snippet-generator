package life.hebo.acm;

import java.util.Scanner;

/**
 * ACM input template. (sum of integers)
 * @author ${author}
 */

public class MainTemplate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

<#if loop>
        // Read integers until EOF
        while (scanner.hasNextInt()) {
</#if>

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
            System.out.println("${outputMessage}" + sum);
<#if loop>
        }
</#if>

        // Close the scanner
        scanner.close();
    }
}