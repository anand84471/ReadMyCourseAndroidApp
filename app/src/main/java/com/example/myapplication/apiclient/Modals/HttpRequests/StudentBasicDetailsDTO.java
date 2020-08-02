package com.example.myapplication.apiclient.Modals.HttpRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentBasicDetailsDTO {
    @SerializedName("student_name")
    @Expose
    public String strStudentName;
    @SerializedName("access_token")
    @Expose
    public String strDateOfJoining;

}
