package com.mentalbilisim.memapper;

import com.mentalbilisim.memapper.exception.TargetTypeInstantiationException;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author er-han on 30.03.2017
 * This interface is used in MeMapper class to
 * supply more readible code.
 */
public interface MapTo {
  <T> Optional<T> mapTo(Class<T> targetType);

  <T> T mapTo(Supplier<T> supplier);
}
