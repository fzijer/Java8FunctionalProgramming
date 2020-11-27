package com.fzj.pactice.chapter3;

import com.fzj.model.Artist;
import lombok.val;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyPractice {
  public static void main(String[] args) {

    /*1.......................*/
    val list = Lists.newArrayList(1,2,3);
    System.out.println(addUp(list.stream()));


    /*2.....................*/
    List<Artist> artistList =Lists.newArrayList();
    returnArtistName(artistList);
  }

  /**
   * 1.编写一个求和函数,计算流中所有数之和,例如: int addUp(Stream<Integer> numbers)
   * */
  public static int addUp(Stream<Integer> numbers){
    return numbers.reduce(0,(x,y) -> x+y);
  }



  /**
   * 2.编写一个函数,接收艺术家列表作为参数,放回一个字符串列表,其中包含艺术家的姓名和国籍*/
  public static List<String> returnArtistName(List<Artist> artistList){
    return artistList.stream()
            .map(v->v.getName()+v.getOrigin())
            .collect(Collectors.toList());
  }


  /**
   * 3.只用 reduce 和 Lambda 表达式 实现Stream上 的Map 操作，如果不想返回Stream 就 返回一个 List*/
  public static Optional reduceMap(List<Integer> numbers){
    numbers.stream().reduce(0,(x,y)-> x+y);
   return null;
  }

}


