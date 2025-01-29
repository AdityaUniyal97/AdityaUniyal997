//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l < r){
        int mid = l + (r - l) / 2;
        mergeSort(arr , l , mid);
        mergeSort(arr , mid + 1, r);
        merge(arr , l , mid , r);
       }
    }
    
    private void merge(int[] arr , int left , int mid , int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] LA = new int[n1];
        int[] RA = new int[n2];
        for(int i =0 ; i < n1; i++){
            LA[i] = arr[left +  i];
        }
        for(int j = 0 ; j < n2 ; j++){
            RA[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(LA[i] <= RA[j]){
                arr[k] = LA[i];
                i++;
            }
            else{
                arr[k] = RA[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = LA[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = RA[j];
            j++;
            k++;
        }
    }
    
    public static void print(int arr[]){
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
