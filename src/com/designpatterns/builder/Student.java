package com.designpatterns.builder;

public class Student {
    private int id;
    private int psp;
    private int yoe;
    private String name;
    private int gradYear;
    private int age;

    // psp > 80, gradYear < 2023, age > 18
    public Student(Builder b){
        this.id = b.getId();
        this.age = b.getAge();
        this.name = b.getName();
        this.yoe = b.getYoe();
        this.psp = b.getPsp();
        this.gradYear = b.getGradYear();
    }

    public static Builder builder() {
        Builder b = new Builder();
        return b;
    }

    public int getId() {
        return id;
    }

    public int getPsp() {
        return psp;
    }

    public int getYoe() {
        return yoe;
    }

    public String getName() {
        return name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public int getAge() {
        return age;
    }
}
