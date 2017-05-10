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

  public static class When_Wrapper {


    @Test
    public void class_boolean_returns_primitive_bool(){
      Class<?> wrapperBooleanClass = Boolean.class;

      Class<?> primitiveBooleanClass = PrimitiveUtil.getPrimitiveClass(wrapperBooleanClass);

      assertEquals(boolean.class, primitiveBooleanClass);
    }


    @Test
    public void class_byte_returns_primitive_byte(){
      Class<?> wrapperByteClass = Byte.class;

      Class<?> primitiveByteClass = PrimitiveUtil.getPrimitiveClass(wrapperByteClass);

      assertEquals(byte.class, primitiveByteClass);
    }

    @Test
    public void class_short_returns_primitive_short(){
      Class<?> wrapperShortClass = Short.class;

      Class<?> primitiveShortClass = PrimitiveUtil.getPrimitiveClass(wrapperShortClass);

      assertEquals(short.class, primitiveShortClass);
    }

    @Test
    public void class_charachter_returns_primitive_char(){
      Class<?> wrapperCharachterClass = Character.class;

      Class<?> primitiveCharClass = PrimitiveUtil.getPrimitiveClass(wrapperCharachterClass);

      assertEquals(char.class, primitiveCharClass);
    }

    @Test
    public void class_integer_returns_primitive_int(){
      Class<?> wrapperIntegerClass = Integer.class;

      Class<?> primitiveIntClass = PrimitiveUtil.getPrimitiveClass(wrapperIntegerClass);

      assertEquals(int.class, primitiveIntClass);
    }

    @Test
    public void class_long_returns_primitive_long(){
      Class<?> wrapperLongClass = Long.class;

      Class<?> primitiveLongClass = PrimitiveUtil.getPrimitiveClass(wrapperLongClass);

      assertEquals(long.class, primitiveLongClass);
    }

    @Test
    public void class_float_returns_primitive_float(){
      Class<?> wrapperFloatClass = Float.class;

      Class<?> primitiveFloatClass = PrimitiveUtil.getPrimitiveClass(wrapperFloatClass);

      assertEquals(float.class, primitiveFloatClass);
    }

    @Test
    public void class_double_returns_primitive_double(){
      Class<?> wrapperDoubleClass = Double.class;

      Class<?> primitiveDoubleClass = PrimitiveUtil.getPrimitiveClass(wrapperDoubleClass);

      assertEquals(double.class, primitiveDoubleClass);
    }

    @Test
    public void class_void_returns_primitive_void(){
      Class<?> wrapperVoidClass = Void.class;

      Class<?> primitiveVoidClass = PrimitiveUtil.getPrimitiveClass(wrapperVoidClass);

      assertEquals(void.class, primitiveVoidClass);
    }
  }
}