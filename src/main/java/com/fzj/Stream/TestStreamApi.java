package com.fzj.Stream;

import com.fzj.annotation.Comment;
import com.fzj.model.Artist;
import com.fzj.model.Track;
import com.sun.org.apache.xpath.internal.functions.Function;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.val;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    Stream.of("a","b","hello","java8").map(v->v.toUpperCase()).forEach(v-> System.out.println(v));


    /**
     * 7. fliter 操作 */
    System.out.println("=============filter============================filter==========================filter====================");
    Stream.of("a","b","c","java8").filter(v->v.equals("a")).forEach(v-> System.out.println(v));


    /**
     * 8.flatMap */
    System.out.println("=============flatMap============================flatMap==========================flatMap====================");
    Stream.of(collected,collected).flatMap(v ->{
      return v.stream();
    }).forEach(v-> System.out.println(v));

    Stream.of(collected,collected).map(v->v.size()).forEach(v-> System.out.println(v));

    /**
     * 9.max & min */
    System.out.println("=============max============================min==========================max====================");
    List<Track> trackList =Lists.newArrayList(new Track("Bakal",524),new Track("Violets for your Furs",378),new Track("Time Was",451));
    val terst=trackList.stream().min(Comparator.comparing(v->v.getNum())).get();
    System.out.println(terst);







  }
}
