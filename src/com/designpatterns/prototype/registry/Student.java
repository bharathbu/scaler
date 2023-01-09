package com.designpatterns.prototype.registry;

public class Student implements Prototype<Student>{
    private int id;
    private String name;
    private int age;
    private double avgBatchPsp;
    private String batchName;
    private int yearOfEnrollment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public Student() {
    }

    public Student(Student s) {
        this.avgBatchPsp = s.avgBatchPsp;
        this.batchName = s.batchName;
        this.yearOfEnrollment = s.yearOfEnrollment;
    }

    /**
     * @return
     */
    @Override
    public Student clone() {
        return new Student(this);
    }
}
