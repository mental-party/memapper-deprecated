package com.mentalbilisim.memapper.util.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MapSetting {

  MapSetting(Class<?> firstClazz, Class<?> secondClazz) {
    isMapOneWay = false;
    pairs = new ArrayList<>();
    this.firstClazz = firstClazz;
    this.secondClazz = secondClazz;
  }

  MapSetting(Class<?> firstClazz, Class<?> secondClazz, boolean isMapOneWay) {
    this.isMapOneWay = isMapOneWay;
    pairs = new ArrayList<>();
    this.firstClazz = firstClazz;
    this.secondClazz = secondClazz;
  }

  private Class<?> firstClazz;
  private Class<?> secondClazz;
  private boolean isMapOneWay;
  private List<MapPair> pairs;

  public Class<?> getFirstClazz() {
    return firstClazz;
  }

  public Class<?> getSecondClazz() {
    return secondClazz;
  }

  public boolean getIsMapOneWay() {
    return isMapOneWay;
  }

  public List<MapPair> getPairs() {
    return pairs;
  }

  public void addPair(String first, String second) {
    pairs.add(new MapPair(first, second));
  }
}
