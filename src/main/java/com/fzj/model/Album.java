package com.fzj.model;

import lombok.Data;

@Data
public class Album {

  /**
   *  专辑名称
   */
  private String name;

  /**
   *  专辑上所有曲目的列表
   */
  private Track track;

  /**
   *  参与本专辑的所有艺术家列表
   */
  private String musicians;


}
