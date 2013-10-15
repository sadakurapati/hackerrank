/*
 * The MIT License
 *
 * Copyright 2013 Sada Kurapati <sadakurapati@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sada.hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Count and print the swaps performed by insertion sorting algorithm
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class InsertionSortAdvanceAnalysis {

  //Using long so that this program can be used to count inversions for the 
  //input size more than 100,000 and for that, the inversions are out of Integer range.
  private static long inversions = 0l;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //how many test cases?
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      inversions = 0l;
      //now read each test case
      int n = sc.nextInt(); // number of array elements in this input.
      int[] ar = new int[n];
      for (int j = 0; j < n; j++) {
        ar[j] = sc.nextInt();
      }
      getInversions(ar, 0, ar.length - 1);
      System.out.println(inversions);
      //System.out.println(getBiggerElementsCount(ar, ar.length));
      //System.out.println(getElementSwaps(ar, ar.length));

    }
  }

  //I sort the array using merge sort technique. O(n log n)
  public static void getInversions(int[] nums, int left, int right) {
    if (left < right) {
      //Split in half
      int mid = (left + right) / 2;
      //Sort recursively.
      getInversions(nums, left, mid);
      getInversions(nums, mid + 1, right);
      //Merge the two sorted sub arrays.
      merge(nums, left, mid, right);
    }
  }

  private static void merge(int[] nums, int left, int mid, int right) {
    int leftLength = mid - left + 1;
    int rightLength = right - mid;
    int[] lAr = new int[leftLength];
    //Just for simplicity, we are creating this right array. 
    //We could use actual nums array with mid and right indexes.
    //a place to improve memory foot print.
    int[] rAr = new int[rightLength];
    for (int i = 0; i < leftLength; i++) {
      lAr[i] = nums[left + i];
    }
    for (int i = 0; i < rightLength; i++) {
      rAr[i] = nums[mid + 1 + i];
    }
    int i = 0, j = 0, k = left;
    while (i < leftLength && j < rightLength) {
      if (lAr[i] <= rAr[j]) {
        nums[k] = lAr[i];
        inversions += j;
        i++;
      } else {
        nums[k] = rAr[j];
        j++;
      }
      k++;
    }
    //remaining iversions, using long cast as multiplication will be out of
    //Integer range for large inputs
    inversions += (long) j * (leftLength - i);
    if (i >= leftLength) {
      //copy remaining elements from right
      for (; j < rightLength; j++, k++) {
        nums[k] = rAr[j];
      }
    } else {
      //copy remaining elements from left
      for (; i < leftLength; i++, k++) {
        nums[k] = lAr[i];
      }
    }
  }

  public static int getBiggerElementsCount(int[] ar, int size) {
    //base case
    if (size <= 1) {
      return 0;
    }
    int biggerElements = 0;
    //starting at 2nd element as first element is already sorted and no swaps are required. 
    for (int i = 1; i < size; i++) {
      //find number of elements less than current
      int moveMe = ar[i];
      for (int j = i - 1; j >= 0; j--) {
        if (moveMe < ar[j]) {
          //found small element on my (ar[i]) left
          ++biggerElements;
        }
      }
    }
    return biggerElements;
  }

  public static int getElementSwaps(int[] ar, int size) {
    //base case
    if (size <= 1) {
      return 0;
    }
    int shifts = 0;
    //starting at 2nd element as first element is already sorted. 
    //Loop Invarient - left part of the array is already sorted.
    for (int i = 1; i < size; i++) {
      int moveMe = ar[i];
      int j = i;
      while (j > 0 && moveMe < ar[j - 1]) {
        //Move element
        ar[j] = ar[j - 1];
        --j;
        //increase the count as element swap is happend
        ++shifts;
      }
      ar[j] = moveMe;
    }
    return shifts;
  }
}
