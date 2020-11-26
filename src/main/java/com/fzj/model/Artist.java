package com.fzj.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;


@Data
public class Artist {

  /**
   *  乐队名称
   */
  private String name;

  /**
   *  乐队成员
   */
  private String members;

  /**
   *  乐队来源
   */
  private String origin;


  public Artist mock() {
    Artist artist = new Artist();
    artist.setMembers("Arich" + ThreadLocalRandom.current().nextInt(10));
    artist.setName("Oracle" +ThreadLocalRandom.current().nextInt(10));
    artist.setOrigin("USA" +ThreadLocalRandom.current().nextInt(10));
    return  artist;
  }


}
