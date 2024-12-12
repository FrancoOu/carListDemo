package com.example.demo.utils;


import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility for copying bean. (Especially for conversion between entity and DTO)
 */
public class BeanCopyUtils {
    private BeanCopyUtils() {

    }
    public static <V> V copyBean(Object source, Class<V> clazz) {
        V result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz) {

        return list.stream()
                .map(object -> copyBean(object, clazz))
                .collect(Collectors.toList());

    }

}

