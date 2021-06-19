package com.koba.exhibitions.controller.dependencyInjection;

import java.lang.reflect.Constructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.SneakyThrows;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

public class Context {
    private static final Logger logger = LogManager.getLogger(Context.class);

    private static final Map<String, Object> applicationContext = new HashMap<>();

    @SneakyThrows
    public static <T> T getObject(Class<T> clazz) {
        String className =  clazz.getCanonicalName();
        if (clazz.isInterface()) {
            Reflections reflections = new Reflections();
            Set<Class<? extends T>> classes = reflections.getSubTypesOf(clazz);
            className = clazz.getCanonicalName();
            clazz = (Class<T>) classes.iterator().next();
        }
        if (clazz.isAnnotationPresent(Component.class)) {
            T existingInstance = (T) applicationContext.get(clazz.getCanonicalName());
            if (existingInstance == null) {
                Constructor constructor = clazz.getDeclaredConstructors()[0];
                Class[] parameters = constructor.getParameterTypes();
                Object[] parametersObjects = Arrays.stream(parameters).map(cls -> getObject(cls)).collect(Collectors.toList()).toArray();
                Object instance = constructor.newInstance(parametersObjects);
                applicationContext.put(className, instance);
                logger.debug(clazz.getCanonicalName() + " created");
                return clazz.cast(instance);
            }
            return existingInstance;
        } else {
            throw new RuntimeException("Can not create object of class " + clazz.getCanonicalName());
        }
    }

    @SneakyThrows
    public static <T> T getCommand(Class<T> clazz) {
        String className =  clazz.getCanonicalName();
        if (clazz.isInterface()) {
            Reflections reflections = new Reflections();
            Set<Class<? extends T>> classes = reflections.getSubTypesOf(clazz);
            className = clazz.getCanonicalName();
            clazz = (Class<T>) classes.iterator().next();
        }
        if (clazz.isAnnotationPresent(Component.class)) {
            T existingInstance = (T) applicationContext.get(clazz.getCanonicalName());
            if (existingInstance == null) {
                Constructor constructor = clazz.getDeclaredConstructors()[0];
                Class[] parameters = constructor.getParameterTypes();
                Object[] parametersObjects = Arrays.stream(parameters).map(cls -> getObject(cls)).collect(Collectors.toList()).toArray();
                Object instance = constructor.newInstance(parametersObjects);
                applicationContext.put(className, instance);
                logger.debug(clazz.getCanonicalName() + " created");
                return clazz.cast(instance);
            }
            return existingInstance;
        } else {
            throw new RuntimeException("Can not create object of class " + clazz.getCanonicalName());
        }
    }
}
