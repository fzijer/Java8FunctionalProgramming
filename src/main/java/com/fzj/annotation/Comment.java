package com.fzj.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Comment {
  String value();
}
