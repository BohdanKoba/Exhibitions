package com.koba.exhibitions.controller.dependencyInjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
String name() default "";
}
