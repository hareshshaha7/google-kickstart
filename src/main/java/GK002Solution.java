import java.util.*;

/*

    Record Breaker (5pts, 7pts)

    Isyana is given the number of visitors at her local theme park on N consecutive days.
    The number of visitors on the i-th day is Vi. A day is record breaking if it satisfies both of the following conditions:
        Either it is the first day, or the number of visitors on the day is strictly larger than the number of visitors on each of the previous days.
        Either it is the last day, or the number of visitors on the day is strictly larger than the number of visitors on the following day.
    Note that the very first day could be a record breaking day!
    Please help Isyana find out the number of record breaking days.

    Input
        The first line of the input gives the number of test cases, T. T test cases follow.
        Each test case begins with a line containing the integer N. The second line contains N integers.
        The i-th integer is Vi and represents the number of visitors on the i-th day.

    Output
        For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
        and y is the number of record breaking days.

    Limits
        Time limit: 20 seconds.
        Memory limit: 1 GB.
        1≤T≤100.
        0≤Vi≤2×105, for all i.

        Test Set 1
            1≤N≤1000.
        Test Set 2
            1≤N≤2×105, for at most 10 test cases.
        For the remaining cases, 1≤N≤1000.

    Sample
    Sample Input
        4
        8
        1 2 0 7 2 0 2 0
        6
        4 8 15 16 23 42
        9
        3 1 4 1 5 9 2 6 5
        6
        9 9 9 9 9 9
    Sample Output
        Case #1: 2
        Case #2: 1
        Case #3: 3
        Case #4: 0

    In Sample Case #1, the underlined numbers in the following represent the record breaking days: 12––07––2020.
    In Sample Case #2, only the last day is a record breaking day: 4815162342–––.
    In Sample Case #3, the first, the third, and the sixth days are record breaking days: 3––14––159––265.
    In Sample Case #4, there is no record breaking day: 999999.
 */

/**
 * Author: Haresh Shaha
 * Date: 27-Aug-2022
 */
public class GK002Solution {

    public static int numberOfRecordBreakingDays(int numberOfDays, int[] visitors) {
        int recordBreakingDays = visitors[0] > visitors[1] ? 1 : 0;
        int highestRecord = visitors[0];

        for (int i = 1; i < numberOfDays - 1; i++) {
            if (visitors[i] > highestRecord && visitors[i] > visitors[i + 1]) {
                recordBreakingDays++;
                highestRecord = Math.max(visitors[i], highestRecord);
            }
        }

        recordBreakingDays = visitors[numberOfDays - 1] > highestRecord ? recordBreakingDays + 1 : recordBreakingDays;

        return recordBreakingDays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of test cases in input
        int testCaseCount = sc.nextInt();

        // Iterate through test cases
        for (int i = 1; i <= testCaseCount; ++i) {
            // Get number of days for this test case
            int numberOfDays = sc.nextInt();

            // Get attendance for each day
            int[] visitorsPerDay = new int[numberOfDays];
            for (int d = 0; d < numberOfDays; ++d) {
                visitorsPerDay[d] = sc.nextInt();
            }

            // Print results
            int answer = numberOfDays > 1 ? numberOfRecordBreakingDays(numberOfDays, visitorsPerDay) : numberOfDays;
            System.out.println("Case #" + i + ": " + answer);
        }

        sc.close();
    }
}
