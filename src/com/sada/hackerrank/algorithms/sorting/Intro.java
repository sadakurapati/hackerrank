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
 * Find the index of index of given element in the array or return -1
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class Intro {

  public static void main(String[] args) {
    //Read the input
    Scanner scan = new Scanner(System.in);
    int v = scan.nextInt();
    int n = scan.nextInt();
    int[] elements = new int[n];
    //constructing array elements
    for (int i = 0; i < n; i++) {
      elements[i] = scan.nextInt();
    }
    System.out.println(binarySearch(elements, 0, n, v));
  }

  public static int binarySearch(int[] elements, int start, int end, int findMe) {
    //Base case - element not found
    if (start > end) {
      return -1;
    }
    Integer mid = (start + end) / 2;
    Integer midElement = elements[mid];
    //is mid the element we are looking?
    if (findMe == midElement) {
      return mid;
    }
    if (findMe < midElement) {
      //its in left half
      return binarySearch(elements, start, mid - 1, findMe);
    } else {
      //in right half of array
      return binarySearch(elements, mid + 1, end, findMe);
    }
  }
}
