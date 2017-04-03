package com.mentalbilisim.memapper.util.mapping;

import static org.junit.Assert.*;

import com.mentalbilisim.memapper.exception.TargetTypeInstantiationException;
import com.mentalbilisim.memapper.to.EnumGender;
import com.mentalbilisim.memapper.to.NameTo;
import com.mentalbilisim.memapper.to.TargetPersonNoEmptyConstructorTo;
import com.mentalbilisim.memapper.to.TargetPersonTo;
import com.mentalbilisim.memapper.to.TeacherPersonTo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Created by erhan.karakaya on 4/3/2017.
 */
public class MapByFieldNameUtilTest {

  private static final Integer ID = 31648;
  private static final String TITLE = "TITLE";
  private static final String FIRST_NAME = "FIRST_NAME";
  private static final String MIDDLE_NAME = "MIDDLE_NAME";
  private static final String LAST_NAME = "LAST_NAME";
  private static final EnumGender GENDER = EnumGender.FEMALE;
  private static final List<String> LESSONS = Arrays.asList("a", "b", "c", "d", "e");
  private static final Double SALARY = 5246.67;


  @Test
  public void shouldMapAllFieldsWithSameName_whenTargetClassIsGiven() {
    TeacherPersonTo teacherPersonTo = prepareTeacher();
    try {
      TargetPersonTo targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, TargetPersonTo.class);

      assertEquals(teacherPersonTo.getId(), targetPersonTo.getId());
      assertEquals(teacherPersonTo.getLessons(), targetPersonTo.getLessons());
      assertEquals(teacherPersonTo.getSalary(), targetPersonTo.getSalary());
      assertEquals(teacherPersonTo.getGender(), targetPersonTo.getGender());
      assertEquals(teacherPersonTo.getTitle(), targetPersonTo.getTitle());
      assertEquals(teacherPersonTo.getName(), targetPersonTo.getName());

    } catch (TargetTypeInstantiationException e) {
      fail();
    }
  }

  @Test(expected = TargetTypeInstantiationException.class)
  public void shouldThrowException_whenTargetClassIsGivenAndTargetHasNotEmptyConstructor()
      throws TargetTypeInstantiationException {
    TeacherPersonTo teacherPersonTo = prepareTeacher();
    TargetPersonNoEmptyConstructorTo targetPersonTo =
        MapByFieldNameUtil.map(teacherPersonTo, TargetPersonNoEmptyConstructorTo.class);
  }

  @Test
  public void shouldReturnNull_whenTargetClassIsGivenAndSourceObjectIsNull()
      throws TargetTypeInstantiationException {
    TeacherPersonTo teacherPersonTo = null;
    TargetPersonTo targetPersonTo =
        MapByFieldNameUtil.map(teacherPersonTo, TargetPersonTo.class);

    assertNull(targetPersonTo);
  }

  @Test
  public void shouldMapAllFieldsWithSameName_whenTargetObjectIsGiven() {
    TeacherPersonTo teacherPersonTo = prepareTeacher();

    TargetPersonTo targetPersonTo = new TargetPersonTo();

    targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, targetPersonTo);

    assertEquals(teacherPersonTo.getId(), targetPersonTo.getId());
    assertEquals(teacherPersonTo.getLessons(), targetPersonTo.getLessons());
    assertEquals(teacherPersonTo.getSalary(), targetPersonTo.getSalary());
    assertEquals(teacherPersonTo.getGender(), targetPersonTo.getGender());
    assertEquals(teacherPersonTo.getTitle(), targetPersonTo.getTitle());
    assertEquals(teacherPersonTo.getName(), targetPersonTo.getName());
  }

  @Test
  public void shouldReturnNull_whenTargetObjectIsGivenAndSourceObjectIsNull() {
    TeacherPersonTo teacherPersonTo = null;
    TargetPersonTo targetPersonTo = new TargetPersonTo();

    targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, targetPersonTo);

    assertNull(targetPersonTo);
  }

  @Test
  public void shouldReturnNull_whenTargetObjectIsGivenAndTargetObjectIsNull() {
    TeacherPersonTo teacherPersonTo = prepareTeacher();
    TargetPersonTo targetPersonTo = null;

    targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, targetPersonTo);

    assertNull(targetPersonTo);
  }

  @Test
  public void shouldReturnNull_whenTargetObjectIsGivenAndTargetObjectAndSourceIsNull() {
    TeacherPersonTo teacherPersonTo = null;
    TargetPersonTo targetPersonTo = null;

    targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, targetPersonTo);

    assertNull(targetPersonTo);
  }

  @Test
  public void shouldMapAllFieldsWithSameName_whenTargetSupplierIsGiven() {
    TeacherPersonTo teacherPersonTo = prepareTeacher();

    final Supplier<TargetPersonTo> supplier = TargetPersonTo::new;
    TargetPersonTo targetPersonTo = MapByFieldNameUtil.map(teacherPersonTo, supplier);

    assertEquals(teacherPersonTo.getId(), targetPersonTo.getId());
    assertEquals(teacherPersonTo.getLessons(), targetPersonTo.getLessons());
    assertEquals(teacherPersonTo.getSalary(), targetPersonTo.getSalary());
    assertEquals(teacherPersonTo.getGender(), targetPersonTo.getGender());
    assertEquals(teacherPersonTo.getTitle(), targetPersonTo.getTitle());
    assertEquals(teacherPersonTo.getName(), targetPersonTo.getName());
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