package com.example.myapplication.apiclient.Modals.HttpResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MasterResponse {
    @SerializedName("response_code")
    @Expose
    public int iResponseCode;
    @SerializedName("response_message")
    @Expose
    public long strResponseMessage;
}
