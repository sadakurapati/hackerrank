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
 * Print insertion sorting shift of given element. The left side elements in the
 * array will be in sorted order.
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class InsertionSortPart1 {

  static void insertionSort(int[] ar) {
    int size = ar.length;
    if (size <= 1) {
      printArray(ar);
      //we are done
      return;
    }
    int moveMe = ar[size - 1];
    int i = size - 1;
    //move big elements
    while (i > 0 && moveMe < ar[i - 1]) {
      //move element and decrement i.
      ar[i] = ar[i - 1];
      --i;
      printArray(ar);
    }
    //insert element.
    ar[i] = moveMe;
    printArray(ar);
  }

  /* Tail starts here */
  static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int i = 0; i < n; i++) {
      ar[i] = in.nextInt();
    }
    insertionSort(ar);
  }
}
