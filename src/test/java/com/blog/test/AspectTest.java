package com.blog.test;


import com.blog.BlogApplication;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

/**
 * @Description TODO
 * @Date 2020/8/8 20:20  by xinghang
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class AspectTest {


    // @Date 2020/4/15 14:23
    @Test
    public void testJiqMi() {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex("gg".getBytes());
        System.out.println(md5DigestAsHex);
    }


    // @Date 2020/4/15 14:23
    @Test
    public void testHashMap() {
        HashMap<String,Integer> map = new HashMap<>();


    }
}
