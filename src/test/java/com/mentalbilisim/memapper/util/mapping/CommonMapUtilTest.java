package com.mentalbilisim.memapper.util.mapping;

import static org.junit.Assert.*;

import com.mentalbilisim.memapper.to.EnumGender;
import com.mentalbilisim.memapper.to.NameTo;
import com.mentalbilisim.memapper.to.TeacherPersonTo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;


/**
 * Created by erhan.karakaya on 3/31/2017.
 */

public class CommonMapUtilTest {



  @Test
  public void shouldIncludeSuperFields_whenIncludeSuperFieldsIsTrue() {
    final boolean includeSuperfields = true;

    List<Field> fields = CommonMapUtil.getAllFields(TeacherPersonTo.class, includeSuperfields);
    HashMap<String, Class<?>> actualFields = new HashMap<>();
    fields.forEach(field -> actualFields.put(field.getName(), field.getType()));

    HashMap<String, Class<?>> expectedFields =
        prepareHashMapOfFieldsInTeacherPersonTo(includeSuperfields);

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void shouldIncludeSuperFields_whenIncludeSuperFieldsIsNotGiven() {
    final boolean includeSuperfields = true;

    List<Field> fields = CommonMapUtil.getAllFields(TeacherPersonTo.class);
    HashMap<String, Class<?>> actualFields = new HashMap<>();
    fields.forEach(field -> actualFields.put(field.getName(), field.getType()));

    HashMap<String, Class<?>> expectedFields =
        prepareHashMapOfFieldsInTeacherPersonTo(includeSuperfields);

    assertEquals(expectedFields, actualFields);
  }

  @Test
  public void shouldNotIncludeSuperFields_whenIncludeSuperFieldsIsFalse() {
    final boolean includeSuperfields = false;

    List<Field> fields = CommonMapUtil.getAllFields(TeacherPersonTo.class, includeSuperfields);
    HashMap<String, Class<?>> actualFields = new HashMap<>();
    fields.forEach(field -> actualFields.put(field.getName(), field.getType()));

    HashMap<String, Class<?>> expectedFields =
        prepareHashMapOfFieldsInTeacherPersonTo(includeSuperfields);

    assertEquals(expectedFields, actualFields);
  }


  private HashMap<String, Class<?>> prepareHashMapOfFieldsInTeacherPersonTo(
      boolean includeSuperfields) {
    HashMap<String, Class<?>> expectedFields = new HashMap<>();
    if (includeSuperfields) {
      expectedFields.put("id", Integer.class);
      expectedFields.put("title", String.class);
      expectedFields.put("name", NameTo.class);
      expectedFields.put("gender", EnumGender.class);
    }
    expectedFields.put("lessons", List.class);
    expectedFields.put("salary", Double.class);
    return expectedFields;
  }



}