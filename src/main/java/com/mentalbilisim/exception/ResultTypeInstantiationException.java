package com.mentalbilisim.exception;

/**
 * author @er-han on 3/30/2017.
 */
public class ResultTypeInstantiationException extends Exception {

  private String resultTypeInstantiationExceptionMessage = "Can not "
      + "instantiate a new object of given result type: "
      + "%s. The result type must have a public no-args constructor.";


  /**
   * Constructor, used when result type is known.
   * @param resultType The type which couldn't be instantiated.
   */
  public ResultTypeInstantiationException(Class<?> resultType) {
    String message = String.format(resultTypeInstantiationExceptionMessage,
        resultType.getTypeName());
    new ResultTypeInstantiationException(message);
  }

  /**
   * Constructor, used when result type is known.
   * @param resultType The type which couldn't be instantiated.
   * @param cause Throwable object, if any, which has caused the exception.
   */
  public ResultTypeInstantiationException(Class<?> resultType, Throwable cause) {
    String message = String.format(resultTypeInstantiationExceptionMessage,
        resultType.getTypeName());
    new ResultTypeInstantiationException(message, cause);
  }

  public ResultTypeInstantiationException(String message) {
    super(message);
  }

  public ResultTypeInstantiationException(String message, Throwable cause) {
    super(message, cause);
  }

}
