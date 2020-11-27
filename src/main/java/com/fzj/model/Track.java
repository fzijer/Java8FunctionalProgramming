package com.fzj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Track {

  /**
   *  曲目名称
   */
  private String name;

  private long length;

}
