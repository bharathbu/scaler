package com.designpatterns.prototype.registry;

public class RegistryTest {
    public static StudentRegistry fillupRegister(StudentRegistry studentRegistry){
        Student aprBatch = new Student();
        aprBatch.setAvgBatchPsp(90);
        aprBatch.setBatchName("APR-LLD");
        aprBatch.setYearOfEnrollment(2021);
        studentRegistry.register(aprBatch.getBatchName(),aprBatch);

        Student mayBatch = new Student();
        mayBatch.setAvgBatchPsp(71);
        mayBatch.setBatchName("MAY-LLD");
        mayBatch.setYearOfEnrollment(2021);
        studentRegistry.register(mayBatch.getBatchName(),mayBatch);

        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setAvgBatchPsp(71);
        intelligentStudent.setBatchName("NOV-LLD");
        intelligentStudent.setYearOfEnrollment(2021);
        intelligentStudent.setIq(100);
        studentRegistry.register(intelligentStudent.getBatchName(),intelligentStudent);

        return studentRegistry;
    }
    public static void main(String[] args) {

        StudentRegistry studentRegistry = new StudentRegistry();
        studentRegistry = fillupRegister(studentRegistry);

        Student aprilBatchStudentObj = ((Student) studentRegistry.get("APR-LLD"));
        Student mayBatchStudentObj = ((Student) studentRegistry.get("MAY-LLD")).clone();// clone will basically get the new object as per prototype design
        IntelligentStudent intelligentStudentObj = ((IntelligentStudent) studentRegistry.get("NOV-LLD")).clone();

    }
}
