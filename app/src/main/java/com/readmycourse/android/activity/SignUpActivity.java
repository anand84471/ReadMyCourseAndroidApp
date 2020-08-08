package com.readmycourse.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioGroup;

import com.readmycourse.android.R;


public class SignUpActivity extends AppCompatActivity {
    private Button submitButton;
    private RadioGroup rgUserSelect;
    private boolean isInstructorSelected=false;
    Animation btnAnim ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(), SplashActivity.class );
            startActivity(mainActivity);
            finish();
        }
        setContentView(R.layout.language_set_up);
        initializeViews();
    }
    private void initializeViews()
    {
        submitButton=findViewById(R.id.userTypeSubmitButton);
        rgUserSelect=findViewById(R.id.userType);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        setSubmitButton();
    }
    private void setSubmitButton()
    {
        rgUserSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.userTypeStudent:
                        isInstructorSelected=false;
                        submitButton.setAnimation(btnAnim);
                        submitButton.setVisibility(View.VISIBLE);
                        // do operations specific to this selection
                        break;
                    case R.id.userTypeInstructor:
                        isInstructorSelected=true;
                        submitButton.setAnimation(btnAnim);
                        submitButton.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePrefsData();
                Intent mainActivity = new Intent(getApplicationContext(), SplashActivity.class );
                startActivity(mainActivity);
                finish();
            }
        });
    }
    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isUserTypeSelected = pref.getBoolean("isUserTypeSelected",false);
        return  isUserTypeSelected;
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isUserTypeSelected",true);
        editor.putBoolean("isInstructorSelected",isInstructorSelected);
        editor.commit();
    }
}
