package com.he.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author herui
 * 构建实体类
 */
//自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter,和@RequiredArgsConstructor!
@Data
//自动生成全参数构造函数。
@AllArgsConstructor
//自动生成无参数构造函数。
@NoArgsConstructor
public class Payment {

    private long id;
    private String serial;

}
