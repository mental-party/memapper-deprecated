package com.mentalbilisim.memapper.util.mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MapSettingBuilder {
  private Class<?> firstClazz;
  private Class<?> secondClazz;
  private boolean isMapOneWay;
  private List<MapPair> pairs;

  public MapSettingBuilder() {
    pairs = new ArrayList<>();
  }

  public MapSettingBuilder firstClazz(Class<?> firstClazz) {
    this.firstClazz = firstClazz;
    return this;
  }

  public MapSettingBuilder secondClazz(Class<?> secondClazz) {
    this.secondClazz = secondClazz;
    return this;
  }

  public MapSettingBuilder addPair(MapPair pair) {
    pairs.add(pair);
    return this;
  }

  public MapSettingBuilder isMapOneWay(boolean isMapOneWay) {
    this.isMapOneWay = isMapOneWay;
    return this;
  }

  public MapSetting build() {
    MapSetting mapSetting = new MapSetting(firstClazz, secondClazz, isMapOneWay);
    return mapSetting;
  }


}
