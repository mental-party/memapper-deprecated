package com.mentalbilisim.memapper.mapconfiguration;

import com.mentalbilisim.memapper.to.PersonTo;
import com.mentalbilisim.memapper.to.StudentPersonTo;
import com.mentalbilisim.memapper.to.TargetPersonTo;
import com.mentalbilisim.memapper.to.TrainerPersonTo;
import org.junit.Test;

/**
 * Created by erhan.karakaya on 4/26/2017.
 */
public class MeMapperConfigurationBeanTest {

  @Test
  public void createBean() {
    MeMapperConfigurationBean bean = MeMapperConfigurationBeanFactory.configure()
        .addNewSetting().between(PersonTo.class).and(TrainerPersonTo.class).isOneWay(true)
        .addPair("Name", "Title")
        .addPair("test", "test")
        .addNewSetting().between(StudentPersonTo.class).and(TargetPersonTo.class).isOneWay(false)
        .addPair("gr", "gre")
        .getBean();
  }
}