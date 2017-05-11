package com.mentalbilisim.memapper.util;

import com.mentalbilisim.memapper.to.PersonTo;
import com.mentalbilisim.memapper.to.PrimitiveTypeTo;
import com.mentalbilisim.memapper.to.WrapperTypeTo;
import com.mentalbilisim.memapper.util.mapping.CommonMapUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import sun.reflect.misc.*;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 5/11/2017.
 */
@RunWith(Enclosed.class)
public class FieldUtilTest {


  public static class WhenFieldTypeIsBoolean {

    @Test
    public void shouldReturnTrue_whenFieldTypeIsPrimitive() {
      Optional<Field> primitiveBooleanField = CommonMapUtil.getAllFields(PrimitiveTypeTo.class)
          .stream().filter(field -> field.getType().equals(boolean.class)).findFirst();
      if (!primitiveBooleanField.isPresent()) {
        fail();
      }

      boolean isBoolean = FieldUtil.isBoolean(primitiveBooleanField.get());

      assertTrue(isBoolean);
    }

    @Test
    public void shouldReturnTrue_whenFieldTypeIsWrapper() {
      Optional<Field> wrapperBooleanField = CommonMapUtil.getAllFields(WrapperTypeTo.class)
          .stream().filter(field -> field.getType().equals(Boolean.class)).findFirst();
      if (!wrapperBooleanField.isPresent()) {
        fail();
      }

      boolean isBoolean = FieldUtil.isBoolean(wrapperBooleanField.get());

      assertTrue(isBoolean);
    }
  }

  public static class WhenFieldTypeIsNotBoolean {

    @Test
    public void shouldReturnFalse() {
      Optional<Field> notBooleanField = CommonMapUtil.getAllFields(PrimitiveTypeTo.class)
          .stream().filter(field -> !field.getType().equals(boolean.class)).findAny();

      if (!notBooleanField.isPresent()) {
        fail();
      }

      boolean isBoolean = FieldUtil.isBoolean(notBooleanField.get());

      assertFalse(isBoolean);
    }
  }

  public static class WhenFieldIsNull {

    @Test
    public void shouldThrowIllegalArgumentException() {
      Field nullField = null;

      try{
        boolean isBoolean = FieldUtil.isBoolean(nullField);
        fail();
      } catch (IllegalArgumentException ex) {

      }
    }
  }
}