package com.ann.bronze.annotation;

import lombok.Data;

/**
 * @Description //TODO
 * @Author anzongying
 * @Date 19:43 2019-09-15
 **/

@MyAnnotation
@Data
public class AnnotaionDemo {
    @MyAnnotation("name")
    private String name;

    @MyAnnotation("getName")
    public String getName() {
        return this.name;
    }
}
