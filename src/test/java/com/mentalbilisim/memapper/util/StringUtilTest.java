package com.mentalbilisim.memapper.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 4/3/2017.
 */
public class StringUtilTest {

  @Test
  public void shouldCapitalizeFirstLetter() {
    String string = "abcdefgh";

    String capitalizedString = StringUtil.capitalizeFirstLetter(string);

    String expectedValue = "Abcdefgh";

    assertEquals(expectedValue, capitalizedString);
  }
}