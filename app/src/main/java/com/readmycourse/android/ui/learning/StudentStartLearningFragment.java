package com.readmycourse.android.ui.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.readmycourse.android.constants.ConfigConstants;
import com.readmycourse.android.ui.home.HomeFragment;


public class StudentStartLearningFragment extends HomeFragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=  super.onCreateView(inflater,container,savedInstanceState);
        if(getIsInstructorAccount()){
            webView.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_INSTRUCTOR_CLASSROOMS);
        }
        else {
            webView.loadUrl(ConfigConstants.READ_MY_COURSE_PRODUCTION_URL_STUDENT_MY_CLASSROOMS);
        }
        return view;
    }
}
