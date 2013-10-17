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
package com.sada.hackerrannk.algorithms.searching;

import java.util.Scanner;

/**
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class LonelyInteger {
  /* Head ends here */

  static int lonelyinteger(int[] a) {
    int[] count = new int[101];
    int n = a.length;
    //Prepare the counts
    for (int el : a) {
      ++count[el];
    }
    //Find non duplicate - count with 1
    int i = 0;
    for (; i < 101 && count[i] != 1; i++);
    return (i < 101) ? i : 0;
  }
  /* Tail starts here */

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int res;

    int _a_size = Integer.parseInt(in.nextLine());
    int[] _a = new int[_a_size];
    int _a_item;
    String next = in.nextLine();
    String[] next_split = next.split(" ");

    for (int _a_i = 0; _a_i < _a_size; _a_i++) {
      _a_item = Integer.parseInt(next_split[_a_i]);
      _a[_a_i] = _a_item;
    }

    res = lonelyinteger(_a);
    System.out.println(res);

  }
}
