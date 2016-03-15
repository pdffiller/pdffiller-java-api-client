package com.pdffiller.client.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReflection<T> {
    private final Type type;

    public TypeReflection() {
        this.type = getGenericType(getClass());
    }
    
    public TypeReflection(Type type) {
      this.type = getGenericType(getClass());
  }

    private static Type getGenericType(Class<?> klass) {
        Type superclass = klass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("No type parameter provided");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return parameterized.getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }
}
