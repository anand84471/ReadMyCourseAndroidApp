package com.readmycourse.android.apiclient.ApiLayer.Abstract;



import com.readmycourse.android.apiclient.Modals.HttpRequests.GetClassroomMeetingDetailsDTO;
import com.readmycourse.android.apiclient.Modals.HttpResponse.MasterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IStudentApiController {
    @POST("/api/mobile/bank/urls")
    Call<MasterResponse> getMeetingDetails(@Body GetClassroomMeetingDetailsDTO obj);
}
