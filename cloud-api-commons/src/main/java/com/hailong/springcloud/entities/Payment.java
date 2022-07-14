package com.hailong.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuhailong
 * @date 2022/5/24.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

  private long id;

  private String serial;

}
