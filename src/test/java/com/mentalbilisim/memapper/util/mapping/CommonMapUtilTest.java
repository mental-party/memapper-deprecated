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

  private static final Integer ID = 31648;
  private static final String TITLE = "TITLE";
  private static final String FIRST_NAME = "FIRST_NAME";
  private static final String MIDDLE_NAME = "MIDDLE_NAME";
  private static final String LAST_NAME = "LAST_NAME";
  private static final EnumGender GENDER = EnumGender.FEMALE;
  private static final List<String> LESSONS = Arrays.asList("a", "b", "c", "d", "e");
  private static final Double SALARY = 5246.67;

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


  private TeacherPersonTo prepareTeacher() {
    TeacherPersonTo teacher = new TeacherPersonTo();

    teacher.setId(ID);
    teacher.setTitle(TITLE);
    teacher.setName(new NameTo(FIRST_NAME, MIDDLE_NAME, LAST_NAME));
    teacher.setLessons(LESSONS);
    teacher.setSalary(SALARY);
    teacher.setGender(GENDER);

    return teacher;
  }

}