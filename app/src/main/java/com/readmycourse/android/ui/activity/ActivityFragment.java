package com.readmycourse.android.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.readmycourse.android.constants.ConfigConstants;
import com.readmycourse.android.ui.home.HomeFragment;

import static com.readmycourse.android.constants.ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR_ACTIVITY;

public class ActivityFragment extends HomeFragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=  super.onCreateView(inflater,container,savedInstanceState);
        if(getIsInstructorAccount()){
            webView.loadUrl(READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR_ACTIVITY);
        }
        else {
            webView.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_STUDENT_ACTIVITY);
        }
        return view;
    }

}
