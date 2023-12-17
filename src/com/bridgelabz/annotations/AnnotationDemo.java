package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {
    @Override
    @MethodInfo(author = "Riya", comments= "Main method", date = "Nov 17 2012", revision = 2)
    public String toString() {
        return "Overridden toString method";
    }
    @Deprecated
    @MethodInfo (comments = "deprecated method", date= "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }
    public static void main(String[] args) {
        try {
            for (Method method: AnnotationDemo.class.getMethods()) {
            // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent (MethodInfo.class)) {
                    try {
                    // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method" + method + "':"+ anno);
                    }
                    MethodInfo methodAnno=method.getAnnotation(MethodInfo.class);
                    if (methodAnno.revision() == 1) {
                        System.out.println("Method with revision no 1 =" + method);
                    }
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
        }
    } catch (SecurityException e) {
        e.printStackTrace();
    }
}
}