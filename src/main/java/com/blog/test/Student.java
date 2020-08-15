package com.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2020/8/11 10:43  by xinghang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @NotNull(message = "用户名不能为空。")
    private String name;
    @Max(value = 100,message = "age不能大于100")
    private int age;
    private String descrition;

}
