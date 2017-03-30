package com.mentalbilisim.memapper.exception;

/**
 * author @er-han on 3/30/2017.
 */
public class TargetTypeInstantiationException extends Exception {

  private String resultTypeInstantiationExceptionMessage = "Can not "
      + "instantiate a new object of given result type: "
      + "%s. The result type must have a public no-args constructor.";


  /**
   * Constructor, used when result type is known.
   * @param resultType The type which couldn't be instantiated.
   */
  public TargetTypeInstantiationException(Class<?> resultType) {
    String message = String.format(resultTypeInstantiationExceptionMessage,
        resultType.getTypeName());
    new TargetTypeInstantiationException(message);
  }

  /**
   * Constructor, used when result type is known.
   * @param resultType The type which couldn't be instantiated.
   * @param cause Throwable object, if any, which has caused the exception.
   */
  public TargetTypeInstantiationException(Class<?> resultType, Throwable cause) {
    String message = String.format(resultTypeInstantiationExceptionMessage,
        resultType.getTypeName());
    new TargetTypeInstantiationException(message, cause);
  }

  public TargetTypeInstantiationException(String message) {
    super(message);
  }

  public TargetTypeInstantiationException(String message, Throwable cause) {
    super(message, cause);
  }

}
