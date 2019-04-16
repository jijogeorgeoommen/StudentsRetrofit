
package com.example.studentsretrofit;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class StudentModel {

    @SerializedName("Result")
    private String mResult;
    @SerializedName("StudentDetails")
    private List<StudentDetail> mStudentDetails;

    public String getResult() {
        return mResult;
    }

    public void setResult(String result) {
        mResult = result;
    }

    public List<StudentDetail> getStudentDetails() {
        return mStudentDetails;
    }

    public void setStudentDetails(List<StudentDetail> studentDetails) {
        mStudentDetails = studentDetails;
    }

}
