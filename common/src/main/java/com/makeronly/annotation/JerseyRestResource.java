package com.makeronly.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Walter Wong
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface JerseyRestResource {
}
