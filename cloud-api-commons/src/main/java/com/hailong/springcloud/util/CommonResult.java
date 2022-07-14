package com.hailong.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuhailong
 * @date 2022/5/24.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

  private Integer code;

  private String message;

  private T date;

  public CommonResult(Integer code, String message) {
    this(code, message, null);
  }

}
