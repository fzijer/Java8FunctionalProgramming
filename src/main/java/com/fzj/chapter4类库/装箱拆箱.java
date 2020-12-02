package com.fzj.chapter4类库;

import java.util.stream.Stream;

public class 装箱拆箱 {
  public static void main(String[] args) {
    /**
     * mapToInt  */
    System.out.println("=============mapToInt============================mapToInt==========================mapToInt====================");
    int sum = Stream.of(1, 2, 3).mapToInt(x-> Integer.parseInt(x.toString())).sum();
    System.out.println(sum);

    Stream.of(1, 2, 3).mapToInt(x-> Integer.parseInt(x.toString())).mapToObj(x->x);

    System.out.println(Stream.of(1, 2, 3).mapToInt(x -> Integer.parseInt(x.toString())).summaryStatistics());

  }
}
