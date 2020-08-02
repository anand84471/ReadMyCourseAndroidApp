package com.example.myapplication.apiclient.Modals.HttpRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetClassroomMeetingDetailsDTO {
    @SerializedName("access_token")
    @Expose
    public String strAccessToken;
    @SerializedName("classroom_id")
    @Expose
    public long llClassroomId;

}
