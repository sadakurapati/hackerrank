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
package com.sada.hackerrank.algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class ClosestNumbers {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //number of elements
    int[] ar = new int[n];
    //Read array
    for (int i = 0; i < n; i++) {
      ar[i] = sc.nextInt();
    }
    //Sort the array - this will be O(n log n)
    Arrays.sort(ar);
    List<Integer> pairIndexes = new ArrayList<Integer>();
    int minDiffSoFar = Integer.MAX_VALUE;
    //start with 1st element to check diff(i to i-1)
    //this is linear - O(n)
    for (int i = 1; i < n; i++) {
      int diff = ar[i] - ar[i - 1];
      if (diff < minDiffSoFar) {
        //found new min, so clear all previous results and add this.
        pairIndexes.clear();
        pairIndexes.add(i - 1);
        pairIndexes.add(i);
        minDiffSoFar = diff;
        //System.out.printf("Diff: %d, %d - %d \n", diff, ar[i], ar[i-1]);
      } else if (diff == minDiffSoFar) {
        //found same min diff pair. add to result
        pairIndexes.add(i - 1);
        pairIndexes.add(i);
      }
    }
    //Print all
    for (int i : pairIndexes) {
      System.out.printf("%d ", ar[i]);
    }

  }
}
