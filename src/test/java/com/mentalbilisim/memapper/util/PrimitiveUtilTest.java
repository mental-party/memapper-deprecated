package com.mentalbilisim.memapper.util;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by erhan.karakaya on 5/10/2017.
 */
@RunWith(Enclosed.class)
public class PrimitiveUtilTest {

  public static class When_Primitive {


    @Test
    public void primitive_boolean_returns_class_bool(){
      Class<?> primitiveBooleanClass = boolean.class;

      Class<?> wrapperBooleanClass = PrimitiveUtil.getWrapperClass(primitiveBooleanClass);

      assertEquals(Boolean.class, wrapperBooleanClass);
    }


    @Test
    public void primitive_byte_returns_class_byte(){
      Class<?> primitiveByteClass = byte.class;

      Class<?> wrapperByteClass = PrimitiveUtil.getWrapperClass(primitiveByteClass);

      assertEquals(Byte.class, wrapperByteClass);
    }

    @Test
    public void primitive_short_returns_class_short(){
      Class<?> primitiveShortClass = short.class;

      Class<?> wrapperShortClass = PrimitiveUtil.getWrapperClass(primitiveShortClass);

      assertEquals(Short.class, wrapperShortClass);
    }

    @Test
    public void primitive_char_returns_class_charachter(){
      Class<?> primitiveCharClass = char.class;

      Class<?> wrapperCharachterClass = PrimitiveUtil.getWrapperClass(primitiveCharClass);

      assertEquals(Character.class, wrapperCharachterClass);
    }

    @Test
    public void primitive_int_returns_class_integer(){
      Class<?> primitiveIntClass = int.class;

      Class<?> wrapperIntegerClass = PrimitiveUtil.getWrapperClass(primitiveIntClass);

      assertEquals(Integer.class, wrapperIntegerClass);
    }

    @Test
    public void primitive_long_returns_class_long(){
      Class<?> primitiveLongClass = long.class;

      Class<?> wrapperLongClass = PrimitiveUtil.getWrapperClass(primitiveLongClass);

      assertEquals(Long.class, wrapperLongClass);
    }

    @Test
    public void primitive_float_returns_class_float(){
      Class<?> primitiveFloatClass = float.class;

      Class<?> wrapperFloatClass = PrimitiveUtil.getWrapperClass(primitiveFloatClass);

      assertEquals(Float.class, wrapperFloatClass);
    }

    @Test
    public void primitive_double_returns_class_double(){
      Class<?> primitiveDoubleClass = double.class;

      Class<?> wrapperDoubleClass = PrimitiveUtil.getWrapperClass(primitiveDoubleClass);

      assertEquals(Double.class, wrapperDoubleClass);
    }

    @Test
    public void primitive_void_returns_class_void(){
      Class<?> primitiveVoidClass = void.class;

      Class<?> wrapperVoidClass = PrimitiveUtil.getWrapperClass(primitiveVoidClass);

      assertEquals(Void.class, wrapperVoidClass);
    }
  }
}