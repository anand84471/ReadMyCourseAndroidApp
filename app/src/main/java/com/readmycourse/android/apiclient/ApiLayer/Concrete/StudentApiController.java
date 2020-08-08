package com.readmycourse.android.apiclient.ApiLayer.Concrete;


import com.readmycourse.android.apiclient.ApiLayer.Abstract.IApplicationRetrofitInterface;
import com.readmycourse.android.apiclient.ApiLayer.Abstract.IStudentApiController;
import com.readmycourse.android.apiclient.Modals.HttpRequests.GetClassroomMeetingDetailsDTO;
import com.readmycourse.android.apiclient.Modals.HttpResponse.MasterResponse;
import com.readmycourse.android.constants.ConfigConstants;

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
