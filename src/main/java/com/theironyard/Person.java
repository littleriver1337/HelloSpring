package com.theironyard;

/**
 * Created by MattBrown on 11/9/15.
 */
public class Person {
    String name;
    String city;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }
}
