package com.designpatterns.prototype.registry;

public class Main {
    public static void main(String[] args) {
        Student template = new Student();
        template.setAvgBatchPsp(90);
        template.setBatchName("NOV-LLD");
        template.setYearOfEnrollment(2021);

        Student copyStud = template.clone();
        System.out.println(copyStud.getAvgBatchPsp());
        System.out.println(copyStud.getBatchName());
        System.out.println(copyStud.getYearOfEnrollment());

    }
}
