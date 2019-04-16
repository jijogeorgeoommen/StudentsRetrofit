package com.example.studentsretrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {
    @GET("viewstudent.php?")
    Call<StudentModel> viewStudent(@Query("branch") String branch);
}
