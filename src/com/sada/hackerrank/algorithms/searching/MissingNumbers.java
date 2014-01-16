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

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class MissingNumbers {
  //TODO - this still take 5.26 secounds time for large input and fails

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k;
    //read A
    int an = sc.nextInt();
    int[] a = new int[an];
    HashMap<Integer, IntWrapper> map = new HashMap<Integer, IntWrapper>(101);
    TreeSet<Integer> result = new TreeSet<Integer>();
    for (int i = 0; i < an; i++) {
      k = sc.nextInt();
      a[i] = k;
      IntWrapper count = map.get(k);
      if (null == count) {
        count = new IntWrapper();
        map.put(k, count);
      }
      --count.i;
    }
    //read B
    int bn = sc.nextInt();
    int[] b = new int[bn];
    for (int i = 0; i < bn; i++) {
      k = sc.nextInt();
      b[i] = k;
      IntWrapper count = map.get(k);
      if (null == count) {
        result.add(k);
      } else if (count.i == -1) {
        map.remove(k);
      } else {
        ++count.i;
      }

    }
    //print
    for (int i : result) {
      System.out.printf("%d ", i);
    }
  }

  public static void method2() {

    Scanner sc = new Scanner(System.in);
    //read A
    int an = sc.nextInt();
    int[] a = new int[an];
    //find max to take the advantage of constraint Xmax - Xmin < 101
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < an; i++) {
      a[i] = sc.nextInt();
      if (a[i] > max) {
        max = a[i];
      }
    }
    //prepare the counts of A elements
    int[] counts = new int[101];
    for (int i = 0; i < an; i++) {
      --counts[max - a[i]];
    }
    //read B
    int bn = sc.nextInt();
    int[] b = new int[bn];
    for (int i = 0; i < bn; i++) {
      b[i] = sc.nextInt();
      ++counts[max - b[i]];
    }

    // all elements with count >1 are missing elements.
    //Traversing in reverse as we need to print the elements in ascending order
    for (int i = 100; i >= 0; i--) {
      if (counts[i] > 0) {
        System.out.printf("%d ", max - i);
      }
    }
  }

  public static void method1() {
    Scanner sc = new Scanner(System.in);
    //read A
    int an = sc.nextInt();
    int[] a = new int[an];
    TreeMap<Integer, IntWrapper> map = new TreeMap<Integer, IntWrapper>();
    for (int i = 0; i < an; i++) {
      a[i] = sc.nextInt();
      IntWrapper count = map.get(a[i]);
      if (null == count) {
        count = new IntWrapper();
        map.put(a[i], count);
      }
      --count.i;
    }
    //read B
    int bn = sc.nextInt();
    int[] b = new int[bn];
    for (int i = 0; i < bn; i++) {
      b[i] = sc.nextInt();
      IntWrapper count = map.get(b[i]);
      if (null == count) {
        count = new IntWrapper();
        map.put(b[i], count);
      }
      ++count.i;
    }

    // all elements with count >1 are missing elements.
    for (Entry<Integer, IntWrapper> entry : map.entrySet()) {
      if (entry.getValue().i > 0) {
        System.out.printf("%d ", entry.getKey());
      }
    }

  }

  static class IntWrapper {

    int i = 0;
  }
}
