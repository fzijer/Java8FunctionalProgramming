package com.fzj.chapter5高级集合类和收集器;

import com.fzj.model.Artist;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 高级集合类 {
  public static void main(String[] args) {

    /**1. List 是有序的，所有改代码不会报错*/
    List<Integer> numbers = Lists.newArrayList(4,3,2,1);
    List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
    System.out.println(sameOrder);


    /**2. HashSet 是无序的集合因此不能保证 程序正常通过*/
    System.out.println("=============HashSet============================HashSet==========================HashSet====================");
    Set<Integer> numberSets = Sets.newHashSet(numbers);
    List<Integer> sameOrde2 =numberSets.stream().collect(Collectors.toList());
    System.out.println(numberSets);
    System.out.println(sameOrde2);


    /**3. 收集器 转换成值*/
    List<Integer> collect = Lists.newArrayList(4,3,2,1);
//    int maxNum =collect.stream().max(Comparator.comparing(x->x)).get();
//    int maxNum2 =collect.stream().reduce(0,(x,y) -> x+y);


    /**4.partitioningBy 收集器 */
    List<Artist> artistList = Lists.newArrayList();
    Artist artist = new Artist();
    for (int i = 0; i < ThreadLocalRandom.current().nextInt(100); i++) {
      artistList.add(artist.mock());
    }

    //List<Artist> artistStream = artistList.stream().collect(Collectors.toList());

  }
}
