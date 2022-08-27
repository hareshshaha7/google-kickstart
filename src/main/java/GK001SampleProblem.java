import java.util.Scanner;

public class GK001SampleProblem {
    // Object for Input
    static Scanner inputObject = new Scanner(System.in);

    public static void main(String[] args) {
        // Declare integer 'T' (Number of Test Cases)
        int T;

        // & read it from Standard Input
        T = inputObject.nextInt();

        // Loop through the number of Test Cases [1, T]
        for (int test_case = 1; test_case <= T; ++test_case) {
            // Print the Test Case Number to Standard Output
            System.out.print("Case #" + test_case + ": ");

            // Call the 'solve()' function to answer each test
            solve();
        }

        // Close the Object for Input
        inputObject.close();
    }

    static void solve() {
        // Declare the integers N (Number of Boxes) & M (Number of Kids)
        int numberOfBoxes, numberOfKids;

        // Read Integers N & M from Standard Input
        numberOfBoxes = inputObject.nextInt();
        numberOfKids = inputObject.nextInt();

        // Declare an array 'C' (Candies) of size 'N'
        int[] C = new int[numberOfBoxes];

        // Read the array 'C' from Standard Input
        for (int i = 0; i < numberOfBoxes; ++i) {
            C[i] = inputObject.nextInt();
        }

        // Declare integer 'totalCandies' to store the overall count of Candies in all boxes
        int totalCandies = 0;

        // Calculate the sum (totalCandies) by iterating through array 'C'
        for (int i = 0; i < numberOfBoxes; ++i) {
            totalCandies += C[i];
        }

        // Every Kid will get 'floor(totalCandies / M)' Candies
        // Hence, Left Out Candies will be (totalCandies % M).
        int leftOutCandies = totalCandies % numberOfKids;

        // Print 'leftOutCandies' (ans) to Standard Output
        System.out.println(leftOutCandies);
    }
}
