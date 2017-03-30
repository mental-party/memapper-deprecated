package com.mentalbilisim.memapper.util.mapping;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * author @er-han on 3/30/2017.
 */
public class CommonMapUtil {
  private static final Logger logger = LoggerFactory.getLogger(CommonMapUtil.class);

  /**
   * Gets all public, private, protected fields of the given type.
   * If the given type has superclass, gets it's fields too using recursive call of self.
   *
   * @param type The type which's fields will be returned.
   * @return List of the fields of the given type.
   */
  public static List<Field> getAllFields(Class<?> type) {
    List<Field> fields = new ArrayList<>();
    if (type.getSuperclass() != null) {
      List<Field> fieldsOfSuper = getAllFields(type.getSuperclass());
      fields.addAll(fieldsOfSuper);
    }

    List<Field> fieldsOfCurrent = Arrays.stream(type.getDeclaredFields())
        .map(field -> {
          Iterator<Field> iterator = fields.iterator();
          while (iterator.hasNext()) {
            Field tempField = iterator.next();
            if (tempField.getName().equals(field.getName())) {
              iterator.remove();
              break;
            }
          }
          return field;
        }).collect(Collectors.toList());

    fields.addAll(fieldsOfCurrent);

    return fields;
  }

  /**
   * Extracts a map of fields in given T object.
   * If given object type has a super class,
   * the fields derived from the super class is extracted too.
   *
   * @param source The object which's fields are wanted to be extracted.
   * @return a Map object which contains extracted fields names and values from the given object
   * @throws IllegalAccessException throws this when can't get one of the field's value of source.
   */
  public static <T> Map<String, Object> getFieldsMap(final T source)
      throws IllegalAccessException {
    final Map<String, Object> map = new HashMap<>();
    final List<Field> fields = getAllFields(source.getClass());
    for (final Field field : fields) {
      final boolean isFieldAccessible = field.isAccessible();
      field.setAccessible(true);
      map.put(field.getName(), field.get(source));
      field.setAccessible(isFieldAccessible);
    }
    return map;
  }

}
