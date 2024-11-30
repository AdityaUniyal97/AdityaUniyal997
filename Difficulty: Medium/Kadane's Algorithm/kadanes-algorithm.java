//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
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

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution 
{
    int maxSubarraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        
        for(int i =0 ; i < arr.length ; i++){
            // Add the current element to the sub array sum
            maxEndingHere += arr[i];
            
            // update if current Sub Array is greter
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            
            // if current subarray become negative than reset it to zero
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}

/*
Dry Run for Array: [10, 15, -5, 15, 10] with Target Sum (S): 20

Initial Values:
- prefixSum = 0
- hashMap = {}

Step-by-Step Execution:

Index 0:
- Current Element: 10
- Update prefixSum: prefixSum = prefixSum + arr[0] = 0 + 10 = 10
- Check Condition: prefixSum - S = 10 - 20 = -10 (not in hashMap).
- Update hashMap: {10: 0}

Index 1:
- Current Element: 15
- Update prefixSum: prefixSum = prefixSum + arr[1] = 10 + 15 = 25
- Check Condition: prefixSum - S = 25 - 20 = 5 (not in hashMap).
- Update hashMap: {10: 0, 25: 1}

Index 2:
- Current Element: -5
- Update prefixSum: prefixSum = prefixSum + arr[2] = 25 + (-5) = 20
- Check Condition: prefixSum - S = 20 - 20 = 0 (found in hashMap at "virtual index" -1).
- Subarray Found:
  - Start Index: hashMap[0] + 1 = 0 + 1 = 0
  - End Index: 2
  - Subarray: [10, 15, -5]
- Update hashMap: {10: 0, 25: 1, 20: 2}

Index 3:
- Current Element: 15
- Update prefixSum: prefixSum = prefixSum + arr[3] = 20 + 15 = 35
- Check Condition: prefixSum - S = 35 - 20 = 15 (not in hashMap).
- Update hashMap: {10: 0, 25: 1, 20: 2, 35: 3}

Index 4:
- Current Element: 10
- Update prefixSum: prefixSum = prefixSum + arr[4] = 35 + 10 = 45
- Check Condition: prefixSum - S = 45 - 20 = 25 (found in hashMap at index 1).
- Subarray Found:
  - Start Index: hashMap[25] + 1 = 1 + 1 = 2
  - End Index: 4
  - Subarray: [-5, 15, 10]
- Update hashMap: {10: 0, 25: 1, 20: 2, 35: 3, 45: 4}

Final Result:
- Subarrays with sum 20:
  1. [10, 15, -5] (indices 0 to 2)
  2. [-5, 15, 10] (indices 2 to 4)
*/
