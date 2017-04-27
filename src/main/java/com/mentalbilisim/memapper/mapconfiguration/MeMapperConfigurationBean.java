package com.mentalbilisim.memapper.mapconfiguration;

import com.mentalbilisim.memapper.util.mapping.MapSetting;

import java.util.List;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MeMapperConfigurationBean {
  MeMapperConfigurationBean(List<MapSetting> settings) {
    this.settings = settings;
  }

  private List<MapSetting> settings;
}
