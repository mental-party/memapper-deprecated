package com.mentalbilisim.util;

/**
 * author @er-han on 3/30/2017.
 */
public class StringUtil {
  /**
   * Makes the first letter uppercase of the given String.
   *
   * @param str will be used in capitaling operation.
   * @return capitalized state of the given param.
   */
  public static String capitalizeFirstLetter(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(Character.toTitleCase(str.charAt(0)));
    if (str.length() > 1) {
      stringBuilder.append(str.substring(1));
    }
    return stringBuilder.toString();
  }
}
