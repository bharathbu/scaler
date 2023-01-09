package com.designpatterns.builder;

public class Builder {
    private int id;
    private int psp;
    private int yoe;
    private String name;
    private int gradYear;
    private int age;

    public Builder() {
    }

    public Builder setId(int id) {
        this.id = id;
        return this;
    }

    public Builder setPsp(int psp) {
        this.psp = psp;
        return this;
    }

    public Builder setYoe(int yoe) {
        this.yoe = yoe;
        return this;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
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

    /**
     *
     * @return student object after validating all required attributes
     * @throws Exception when validation fails, and stops creation of student obj
     */
    public Student build() throws Exception {
        if(gradYear >= 2023){
            throw new Exception("Grad year is not valid");
        }
        if(age < 18){
            throw new Exception("Age is not valid");
        }
        if(psp < 80){
            throw new Exception("PSP is not valid");
        }
        Student s = new Student(this);
        return s;
    }
}
