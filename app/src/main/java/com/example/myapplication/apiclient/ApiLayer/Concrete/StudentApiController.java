package com.example.myapplication.apiclient.ApiLayer.Concrete;

import com.example.myapplication.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.example.myapplication.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.example.myapplication.apiclient.Modals.HttpRequests.GetClassroomMeetingDetailsDTO;
import com.example.myapplication.apiclient.Modals.HttpResponse.MasterResponse;
import com.example.myapplication.constants.ConfigConstants;

import retrofit2.Call;

public class StudentApiController implements IStudentApiController {
    IApplicationRetrofitInterface iApplicationRetrofitInterface;
    public StudentApiController(IApplicationRetrofitInterface iApplicationRetrofitInterface)
    {
        this.iApplicationRetrofitInterface=iApplicationRetrofitInterface;
        setBaseUrl();
    }
    @Override
    public Call<MasterResponse> getMeetingDetails(GetClassroomMeetingDetailsDTO obj) {
        return null;
    }
    private void setBaseUrl()
    {
        this.iApplicationRetrofitInterface.setBaseUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_STUDENT_API_URL);
    }

}
