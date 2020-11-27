package com.fzj.Stream;

import com.fzj.annotation.Comment;
import com.fzj.model.Album;
import com.fzj.model.Artist;
import com.fzj.model.Track;
import lombok.val;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Comment("测试java8中流的操作")
public class TestStreamApi {
  public static void main(String[] args) {
    List<Artist> artistList = Lists.newArrayList();
    Artist artist = new Artist();
    for (int i = 0; i < ThreadLocalRandom.current().nextInt(100); i++) {
      artistList.add(artist.mock());
    }

    /**
     * 1.测试 .stream() 方法*/
    Stream<Artist> artistStream = artistList.stream();
    //System.out.println(artistStream);

    /**
     * 2. 使用 stream 中的 过滤操作 & 聚合操作*/
    long count = artistList.stream().filter(v -> v.getOrigin().equals("USA1")).count();
    System.out.println("乐队来源地来自 UAS1 的乐队数为: " + count);


    /**
     * 3. 使用 stream 中  foreeach 来遍历流*/
    artistList.stream().forEach(v -> {
      System.out.println(v);
    });


    /**
     * 4. 测试惰性求值方法 filter()*/
    System.out.println("========================================================================================");
    artistList.stream().filter(v -> {
      System.out.println(v.getName());
      return v.getOrigin().equals("USA1");
    });


    /**
     * 5.常用流操作 collect( toList() )*/
    List<String> collected = Stream.of("java", "scala", "oracle")
            .collect(Collectors.toList());
    collected.forEach(v -> {
      System.out.println(v);
    });
    // collect( toList() ) 就是 及早求值方法,将处理后的数据转为 及早求值.
    artistList.stream().filter(v -> {
      System.out.println(v.getName());
      return v.getOrigin().equals("USA1");
    }).collect(Collectors.toList());


    /**
     * 6.map操作  */
    System.out.println("=============map============================map==========================map====================");
    //List<String> collected2 = Stream.of("a","b","hello","java8").map(v->v.toUpperCase()).collect(Collectors.toList());
    Stream.of("a", "b", "hello", "java8").map(v -> v.toUpperCase()).forEach(v -> System.out.println(v));


    /**
     * 7. fliter 操作 */
    System.out.println("=============filter============================filter==========================filter====================");
    Stream.of("a", "b", "c", "java8").filter(v -> v.equals("a")).forEach(v -> System.out.println(v));


    /**
     * 8.flatMap */
    System.out.println("=============flatMap============================flatMap==========================flatMap====================");
    Stream.of(collected, collected).flatMap(v -> {
      return v.stream();
    }).forEach(v -> System.out.println(v));

    Stream.of(collected, collected).map(v -> v.size()).forEach(v -> System.out.println(v));

    /**
     * 9.max & min */
    System.out.println("=============max============================min==========================max====================");
    List<Track> trackList = Lists.newArrayList(new Track("Bakal", 524), new Track("Violets for your Furs", 378), new Track("Time Was", 451));
    val terst = trackList.stream().min(Comparator.comparing(v -> v.getLength())).get();
    System.out.println(terst);


    /**
     * 10. Reduce   使用Reduce 求和*/
    System.out.println("=============Reduce============================Reduce==========================Reduce====================");
    int count2 = Stream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
    System.out.println(count2);

  }


  /**
   * 11.重构代码
   */
  public Set<String> findLongTracks(List<Album> albums) {
    return albums.stream().flatMap(album -> album.getTrack().stream())
            .filter(v -> v.getLength() > 60)
            .map(v2 -> v2.getName())
            .collect(Collectors.toSet());
  }
}


