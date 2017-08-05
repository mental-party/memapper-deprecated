package com.teammental.memapper.util;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/**
 * Created by erhan.karakaya on 4/3/2017.
 */
public class StringUtilTest {

  public static class CapitalizeFirstLetter {

    @Test
    public void shouldCapitalizeFirstLetter() {
      String string = "abcdefgh";

      String capitalizedString = StringUtil.capitalizeFirstLetter(string);

      String expectedValue = "Abcdefgh";

      assertEquals(expectedValue, capitalizedString);
    }
  }


  public static class GenerateRandomString {

    @Test
    public void shouldGenerateRandomStringWithCorrectLength() {
      final int length = 20;
      String randomString = StringUtil.generateRandomString(length);

      assertEquals(length, randomString.length());
    }
  }

  public static class IsNullOrEmpty {

    @Test
    public void shouldReturnTrue_whenStringIsNull() {
      final String str = null;

      final boolean expectedResult = true;

      boolean isNullOrEmpty = StringUtil.isNullOrEmpty(str);

      assertEquals(expectedResult, isNullOrEmpty);
    }

    @Test
    public void shouldReturnTrue_whenStringIsEmpty() {
      final String str = "";

      final boolean expectedResult = true;

      boolean isNullOrEmpty = StringUtil.isNullOrEmpty(str);

      assertEquals(expectedResult, isNullOrEmpty);
    }

    @Test
    public void shouldReturnFalse_whenStringIsNotNullOrEmpty() {
      final String str = "str";

      final boolean expectedResult = false;

      boolean isNullOrEmpty = StringUtil.isNullOrEmpty(str);

      assertEquals(expectedResult, isNullOrEmpty);
    }

  }

  public static class SplitByCapitalLetters {

    @Test
    public void shouldReturnNull_whenGivenParameterIsNull() {
      final String str = null;
      final List<String> expectedResult = null;

      List<String> actualResult = StringUtil.splitByCapitalLetters(str);

      assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNull_whenGivenParameterIsEmpty() {
      final String str = "";
      final List<String> expectedResult = null;

      List<String> actualResult = StringUtil.splitByCapitalLetters(str);

      assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnOneItemedList_whenNoCapitalLetter() {
      final String str = "abc";
      final List<String> expectedResult = new ArrayList<>(Arrays.asList("abc"));

      List<String> actualResult = StringUtil.splitByCapitalLetters(str);

      assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldSplitByAllCapitals() {
      final String str = "abcDeFGjkMNo";
      final List<String> expectedResult = new ArrayList<>(
          Arrays.asList("abc", "De", "F", "Gjk", "M", "No"));

      List<String> actualResult = StringUtil.splitByCapitalLetters(str);

      assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldSplitByFirstCapital() {
      final String str = "abcDeFGjkMNo";
      final List<String> expectedResult = new ArrayList<>(
          Arrays.asList("abc", "DeFGjkMNo"));

      List<String> actualResult = StringUtil.splitByCapitalLetters(str, true);

      assertEquals(expectedResult, actualResult);
    }
  }
}