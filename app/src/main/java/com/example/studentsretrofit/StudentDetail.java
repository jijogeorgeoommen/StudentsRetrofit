
package com.example.studentsretrofit;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class StudentDetail {

    @SerializedName("StudentBranch")
    private String mStudentBranch;
    @SerializedName("StudentClass")
    private String mStudentClass;
    @SerializedName("StudentDob")
    private String mStudentDob;
    @SerializedName("StudentName")
    private String mStudentName;
    @SerializedName("StudentReg.no")
    private String mStudentRegNo;

    public String getStudentBranch() {
        return mStudentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        mStudentBranch = studentBranch;
    }

    public String getStudentClass() {
        return mStudentClass;
    }

    public void setStudentClass(String studentClass) {
        mStudentClass = studentClass;
    }

    public String getStudentDob() {
        return mStudentDob;
    }

    public void setStudentDob(String studentDob) {
        mStudentDob = studentDob;
    }

    public String getStudentName() {
        return mStudentName;
    }

    public void setStudentName(String studentName) {
        mStudentName = studentName;
    }

    public String getStudentRegNo() {
        return mStudentRegNo;
    }

    public void setStudentRegNo(String studentRegNo) {
        mStudentRegNo = studentRegNo;
    }

}
