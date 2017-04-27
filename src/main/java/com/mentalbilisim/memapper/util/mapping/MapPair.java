package com.mentalbilisim.memapper.util.mapping;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MapPair {

  public MapPair(String firstFieldName, String secondFieldName) {
    this.firstFieldName = firstFieldName;
    this.secondFieldName = secondFieldName;
  }

  private String firstFieldName;
  private String secondFieldName;

  public String getFirstFieldName() {
    return firstFieldName;
  }

  public String getSecondFieldName() {
    return secondFieldName;
  }

}
