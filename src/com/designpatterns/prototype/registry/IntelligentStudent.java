package com.designpatterns.prototype.registry;

public class IntelligentStudent extends Student{
    private int iq;

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent() {
    }

    public IntelligentStudent(IntelligentStudent is) {
        super(is); // copy all attributes present in the parent [Student]
        this.iq = is.iq; // copy the attribute present in the child [IntelligentStudent]
    }

    public IntelligentStudent clone(){
        return new IntelligentStudent(this);
    }
}
