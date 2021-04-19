package com.yu.common.querydsl.query.annotation;

import com.yu.common.querydsl.query.enums.YuDateTimeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangxd
 * @date 2020-10-10
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YuDateTimeFormat {
    /**
     * 日期类型
     */
    YuDateTimeEnum value() default YuDateTimeEnum.DATE;
}

