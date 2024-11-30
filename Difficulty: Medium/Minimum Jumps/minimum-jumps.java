//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int minJumps(int[] arr) {
        // Base case: If the array has only one element, no jumps are needed
        if (arr.length <= 1) {
            return 0;
        }

        // If the first element is 0, it's not possible to move forward
        if (arr[0] == 0) {
            return -1;
        }

        // Initialize variables
        int jumps = 0; // Number of jumps made so far
        int currentEnd = 0; // The farthest index reachable with the current number of jumps
        int farthest = 0; // The farthest index reachable overall at each step

        // Traverse the array (excluding the last element)
        for (int i = 0; i < arr.length - 1; i++) {
            // Update the farthest index reachable from the current position
            farthest = Math.max(farthest, i + arr[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++; // Increment the jump count
                currentEnd = farthest; // Update the currentEnd to the farthest index reachable

                // If currentEnd has reached or exceeded the last index, we can stop
                if (currentEnd >= arr.length - 1) {
                    break;
                }
            }
        }

        // If the loop finishes and we haven't reached the end, return -1 (not possible)
        return currentEnd >= arr.length - 1 ? jumps : -1;
    }
}
