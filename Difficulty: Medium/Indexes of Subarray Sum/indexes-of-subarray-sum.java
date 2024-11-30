//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length; // Get the size of the array
        int pre = 0; // To store the running prefix sum
        HashMap<Integer, Integer> h = new HashMap<>(); // To store prefix sums and their indices
        ArrayList<Integer> result = new ArrayList<>(); // To store the result

        // Traverse the array
        for (int i = 0; i < n; i++) {
            pre += arr[i]; // Update the prefix sum
            
            // If prefix sum equals the target, the subarray starts from index 0
            if (pre == target) {
                result.add(1); // Start index (1-based)
                result.add(i + 1); // End index (1-based)
                return result; // Return early upon finding the subarray
            }

            // If (prefix sum - target) exists in the map, we found a subarray
            if (h.containsKey(pre - target)) {
                result.add(h.get(pre - target) + 2); // Start index (1-based)
                result.add(i + 1); // End index (1-based)
                return result; // Return early upon finding the subarray
            }

            // Add the current prefix sum to the map
            h.put(pre, i);
        }

        // If no subarray is found, return -1
        result.add(-1);
        return result;
    }
}
