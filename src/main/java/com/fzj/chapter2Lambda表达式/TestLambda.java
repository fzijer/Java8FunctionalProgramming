package com.fzj.chapter2Lambda表达式;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 编写Lambda表达式的不同形式*/

public class TestLambda {
  public static void main(String[] args) {

    //所示的Lambda表达式不包含参数，使用空括号()表示没有参数。该Lambda表达式实现了Runnable接口，该接口也只有一个run方法，没有参数，且返回类型为void
    Runnable noArguments =()-> System.out.println("Hello World");


    ActionListener oneArgument =event ->{
      System.out.println("Hello World");
    }  ;

    BinaryOperator<Long> add = (x, y) -> x+y;

    Predicate<Integer> atLeast5 = x -> x > 5;

    BinaryOperator<Long> addLongs = (x, y) -> x + y;



  }
}
