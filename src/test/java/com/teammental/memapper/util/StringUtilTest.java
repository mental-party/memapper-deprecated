package com.teammental.memapper.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


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

  @Test
  public void generateRandomString_withCorrectLength() {
    final int length = 20;
    String randomString = StringUtil.generateRandomString(length);

    assertEquals(length,randomString.length());
  }
}