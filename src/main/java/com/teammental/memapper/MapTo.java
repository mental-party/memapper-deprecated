package com.teammental.memapper;

import java.util.Optional;

/**
 * @author er-han on 30.03.2017
 *         This interface is used in MeMapper class to
 *         supply more readible code.
 */
public interface MapTo<TargetT> {
  Optional<TargetT> mapTo(Class<TargetT> targetType);
}
