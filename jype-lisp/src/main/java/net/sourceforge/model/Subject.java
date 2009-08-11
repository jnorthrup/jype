package net.sourceforge.model;

import java.util.*;
import java.lang.reflect.*;

/**
 * User: jim
 * Date: Apr 5, 2009
 * Time: 5:25:37 PM
 */
public class Subject {

    int age = new Random(System.currentTimeMillis()).nextInt(99);
    String city = "SmallVille";

    Subject(int age, String city) {
        this.age = age;
        this.city = city;
    }

    public Subject() {
        this(new Random(System.currentTimeMillis()).nextInt(99), "AnyTown");

    }

    public String toString() {

//        XStream x = new XStream();
//        final String s = x.toXML(this);
//        return s;
        String s = "";
        try {
            final Class<?> aClass = Class.forName("com.thoughtworks.xstream.XStream");

            final Object xstream = aClass.newInstance();
            final Method method = aClass.getMethod("toXML", Object.class);
            final Object o = method.invoke(xstream, this);
            s += "" + o+
                    "\n";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (InstantiationException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } finally {


            return s + "{ Subject: " +
                   " age: " + age +
                                  " city: " + city +
                                                   " }";
        }
    }
}
