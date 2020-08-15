package com.blog.test.controller;

import com.blog.test.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/8/11 10:44  by xinghang
 */
@RestController
public class StudentController {


    @GetMapping("getAge")
    public String getAge(@Valid Student student, Errors error) {
        if (error.hasErrors()){
            FieldError fieldError = error.getFieldError();
            System.out.println(fieldError);
            List<ObjectError> errors = error.getAllErrors();
            System.out.println(error);
            return "数据校验不成功";
        }
        @Max(value = 100, message = "age不能大于100")
        int age = student.getAge();
        System.out.println(age);
        return age + "";

    }

}
