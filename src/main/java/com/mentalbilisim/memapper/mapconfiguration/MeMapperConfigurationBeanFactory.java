package com.mentalbilisim.memapper.mapconfiguration;

import com.mentalbilisim.memapper.util.mapping.MapPair;
import com.mentalbilisim.memapper.util.mapping.MapSetting;
import com.mentalbilisim.memapper.util.mapping.MapSettingBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MeMapperConfigurationBeanFactory
    implements Between, And, IsOneWay, AddPair, AddNewSetting {

  private MeMapperConfigurationBeanFactory() {
    settings = new ArrayList<>();
  }

  public static AddNewSetting configure() {
    MeMapperConfigurationBeanFactory bean = new MeMapperConfigurationBeanFactory();
    return bean;
  }

  private List<MapSetting> settings;

  private MapSettingBuilder mapSettingBuilder;


  @Override
  public MeMapperConfigurationBean getBean() {
    if (mapSettingBuilder != null) {
      settings.add(mapSettingBuilder.build());
    }
    return new MeMapperConfigurationBean(settings);
  }

  @Override
  public Between addNewSetting() {
    if (mapSettingBuilder != null) {
      settings.add(mapSettingBuilder.build());
    }
    mapSettingBuilder = new MapSettingBuilder();
    return this;
  }

  @Override
  public And between(Class<?> firstClazz) {
    mapSettingBuilder.firstClazz(firstClazz);
    return this;
  }

  @Override
  public IsOneWay and(Class<?> secondClazz) {
    mapSettingBuilder.secondClazz(secondClazz);
    return this;
  }

  @Override
  public AddPair isOneWay(boolean isOneWay) {
    mapSettingBuilder.isMapOneWay(isOneWay);
    return this;
  }

  @Override
  public AddPair addPair(String firstKey, String secondKey) {
    mapSettingBuilder.addPair(new MapPair(firstKey, secondKey));
    return this;
  }
}
