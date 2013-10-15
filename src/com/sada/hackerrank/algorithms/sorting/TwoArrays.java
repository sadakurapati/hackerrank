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

import java.util.Arrays;
import java.util.Scanner;

/**
 * Is there an arrangement of the arrays such that Ai+Bi>=K for all i where Ai
 * denotes the ith element in the array A. If yes, print YES else print NO
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class TwoArrays {

  public static void main(String[] args) {
    //Read the input from console
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      //Read N and K
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = readIntArray(sc, n);
      int[] b = readIntArray(sc, n);
      //Sort b in ascending order
      Arrays.sort(b);
      boolean pairFound = true;
      boolean[] picked = new boolean[n];
      //find pairs in B for each element in A
      int j = 0;
      while (j < n && pairFound) {
        pairFound = findMyPair(a[j], b, k, picked);
        j++;
      }
      System.out.println(pairFound ? "YES" : "NO");
    }// test case for loop
  }

  //NOTE, b array should be sorted in ascending so that we can pick best element
  public static boolean findMyPair(int ai, int[] b, int k, boolean[] picked) {
    int bLength = b.length;
    int i = 0;
    while (i < bLength && ((ai + b[i]) < k || picked[i])) {
      ++i;
    }
    //if found, set the picked up flag to true and return i.
    if (i < bLength) {
      picked[i] = true; // set picked up flag to true
      return true;
    }
    //Not found
    return false;
  }

  public static int[] readIntArray(Scanner sc, int length) {
    //initialize array
    int[] a = new int[length];
    for (int i = 0; i < length; i++) {
      a[i] = sc.nextInt();
    }
    return a;
  }
}
