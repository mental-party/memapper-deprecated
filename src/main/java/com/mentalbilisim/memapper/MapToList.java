package com.mentalbilisim.memapper;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author er-han on 30.03.2017
 * This interface is used in MeMapper class to
 * supply more readible code.
 */
public interface MapToList {
  <SourceT> Optional<Iterable<SourceT>> mapToList(Class<SourceT> targetType);

  <SourceT> Iterable<SourceT> mapToList(Supplier<SourceT> supplier);
}
