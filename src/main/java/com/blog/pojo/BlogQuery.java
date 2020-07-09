package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/7/6 17:03
 * @Created by xinghang
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {

    private boolean recommend;

    private Long typeId;

    private String title;

}
