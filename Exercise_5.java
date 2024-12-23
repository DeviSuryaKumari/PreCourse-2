// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Time Complexity : O(nlogn)
// Space Complexity : O(n) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

import java.util.LinkedList;
import java.util.Deque;
//import java.util.*;
class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];

//        int t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h)
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, h);
        return i + 1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h)
    { 
        //Try using Stack Data Structure to remove recursion.
        Deque<Integer> stack = new LinkedList<>(); // ArrayDeque can also be used
        stack.push(l);
        stack.push(h);
        while (!stack.isEmpty()) {
            h = stack.pop();
            l = stack.pop();
            int pi = partition(arr, l, h);
            if (pi - 1 > l) {
                stack.push(l);
                stack.push(pi - 1);
            }
            if (pi + 1 < h){
                stack.push(pi + 1);
                stack.push(h);
            }
        }
//        if (low < high) {
//            int pi = partition(arr, low, high);
//            QuickSort(arr, low, pi - 1);
//            QuickSort(arr, pi + 1, high);
//        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 };
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 