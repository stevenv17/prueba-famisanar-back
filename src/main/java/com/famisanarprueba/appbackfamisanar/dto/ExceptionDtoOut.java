package com.famisanarprueba.appbackfamisanar.dto;

import lombok.Builder;
import lombok.Data;
import utilities.Constants;

@Data
@Builder
public class ExceptionDtoOut {
  private String result = Constants.ERROR;
  private String message;
  private Integer code;
  private Object validations;
}
