package com.designpatterns.builder;

public class Main {
    public static void main(String[] args) throws Exception{
        Student s = Student.builder()
                .setId(1)
                .setPsp(81)
                .setName("Bharath")
                .setGradYear(2020)
                .setYoe(4)
                .setAge(24).build();

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
